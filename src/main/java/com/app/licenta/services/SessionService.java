package com.app.licenta.services;

import com.app.licenta.dtos.SessionUpdateDto;
import com.app.licenta.entities.*;
import com.app.licenta.repositories.GroupRepository;
import com.app.licenta.repositories.SessionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private GroupRepository groupRepository;

    public List<Session> createSessions(Integer groupId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new EntityNotFoundException("Group with id " + groupId + " not found"));

        group.setStatus(ChildrenGroupStatus.ACTIVE);
        Set<Session> sessions = createSessions(group);

        return sessionRepository.saveAll(sessions);
    }

    private Set<Session> createSessions(Group group) {
        Ad ad = group.getAd();
        Set<DurationRule> durationRules = group.getDurationRules();

        Set<Session> sessions = createSessionsWithDates(ad.getStartDate(), ad.getEndDate(), durationRules);
        sessions.forEach(session -> {
            session.setGroup(group);
            group.getSessions().add(session);
        });

        return sessions;
    }

    private Set<Session> createSessionsWithDates(LocalDate startDate, LocalDate endDate, Set<DurationRule> durationRules) {
        LocalDate localDate = startDate;
        Set<Session> generatedSessions = new HashSet<>();
        while (localDate.isBefore(endDate)) {
            LocalDate currentDate = localDate;
            DurationRule foundRule = durationRules.stream().filter(durationRule ->
                    durationRule.getDay().ordinal() + 1 == currentDate.getDayOfWeek().ordinal())
                    .findFirst()
                    .orElse(null);

            if(foundRule != null) {
                Session session = new Session();
                session.setStartDateTime(LocalDateTime.of(currentDate, LocalTime.of(foundRule.getStartHour(), 0)));
                session.setEndDateTime(LocalDateTime.of(currentDate, LocalTime.of(foundRule.getStartHour() + foundRule.getNumberOfHours(), 0)));
                generatedSessions.add(session);
            }

            localDate = localDate.plusDays(1);
        }

        return generatedSessions;
    }

    public Session getById(Integer id) {
        return sessionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Session with id " + id + " not found"));
    }


    public List<Session> findAllByGroupId(Integer groupId, Integer pageNumber, Integer pageSize, String sortBy, String sortDirection) {
        Sort.Direction direction = Optional.ofNullable(sortDirection)
                .map(Sort.Direction::fromString)
                .orElse(Sort.Direction.ASC);
        Sort sort = Optional.ofNullable(sortBy)
                .map(s -> Sort.by(direction, s))
                .orElse(Sort.by(direction, "startDateTime"));
        Pageable page = PageRequest.of(pageNumber, pageSize, sort);
        return sessionRepository.findAllByGroupId(groupId, page);
    }

    public Session updateNote(Integer id, SessionUpdateDto noteDto) {
        Session session = sessionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Session with id " + id + " not found"));
        session.setNote(noteDto.getNote());
        return sessionRepository.save(session);
    }

    public Session updateDate(Integer id, SessionUpdateDto dateDto) {
        Session session = sessionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Session with id " + id + " not found"));
        session.setStartDateTime(dateDto.getStartDateTime());
        session.setEndDateTime(dateDto.getEndDateTime());
        return sessionRepository.save(session);
    }

    public void deleteById(Integer id) {
        sessionRepository.deleteById(id);
    }
}
