package com.app.licenta.schedulers;

import com.app.licenta.diplomas.PdfDiplomaGenerator;
import com.app.licenta.emails.EmailService;
import com.app.licenta.entities.ChildrenGroupStatus;
import com.app.licenta.entities.Group;
import com.app.licenta.entities.Session;
import com.app.licenta.repositories.GroupRepository;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

import static com.app.licenta.entities.ChildrenGroupStatus.ACTIVE;

@Configuration
@EnableScheduling
public class GroupClosingScheduler {

    private final EmailService emailService;
    private final PdfDiplomaGenerator pdfDiplomaGenerator;
    private final GroupRepository groupRepository;

    public GroupClosingScheduler(EmailService emailService,
                                 PdfDiplomaGenerator pdfDiplomaGenerator,
                                 GroupRepository groupRepository) {
        this.emailService = emailService;
        this.pdfDiplomaGenerator = pdfDiplomaGenerator;
        this.groupRepository = groupRepository;
    }

    @Scheduled(cron = "0 * * * * *")
    @Transactional
    public void changeGroupsStatusToCompleted() {
        LocalDate today = LocalDate.now();
        Set<Group> activeGroups = groupRepository.findAllByAdEndDateBeforeAndStatus(today, ACTIVE);
        Set<Group> groupsToClose = activeGroups.stream()
                .filter(group -> group.getSessions().stream()
                        .allMatch(session -> session.getEndDateTime().isBefore(today.atStartOfDay())))
                .collect(Collectors.toSet());
        groupsToClose.forEach(group -> group.setStatus(ChildrenGroupStatus.COMPLETED));
        groupRepository.saveAll(groupsToClose);

        groupsToClose.forEach(group -> group.getChildren().forEach(child ->
                {
                    LocalDateTime adEndDate = group.getAd().getEndDate().atStartOfDay();
                    LocalDateTime lastSession = group.getSessions().stream()
                            .map(Session::getEndDateTime)
                            .sorted(Comparator.reverseOrder())
                            .toList()
                            .stream()
                            .findFirst()
                            .orElse(adEndDate);
                    LocalDateTime endDate = adEndDate.isBefore(lastSession) ? lastSession : adEndDate;
                    byte[] attachment = pdfDiplomaGenerator.generateDiploma(child.getFullName(), group.getActivity().getTitle(), group.getAd().getStartDate(), endDate.toLocalDate(), group.getActivity().getTrainer().getFullName());
                    emailService.sendGroupCompletedDiplomaEmail("stanescu.ariana02@gmail.com", child.getFullName(), group.getActivity().getTitle(), attachment);
                }
        ));
    }
}
