package com.app.licenta.services;

import com.app.licenta.entities.*;
import com.app.licenta.repositories.GroupRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private ActivityService activityService;
    @Autowired
    private AdService adService;
    @Autowired
    private ChildService childService;

    @Transactional
    public Group createGroup(Integer activityId, Integer adId) {
        Activity activity = activityService.getById(activityId);
        Ad ad = adService.getById(adId);

        Group group = new Group();
        group.setTitle(ad.getTitle());
        group.setDescription(ad.getDescription());
        group.setMinAge(ad.getMinAge());
        group.setMaxAge(ad.getMaxAge());
        group.setGender(ad.getGender());
        group.setLocation(ad.getLocation());
        group.setStatus(ChildrenGroupStatus.ACTIVE);
        group.setActivity(activity);
        group.setAd(ad);
        group.setDurationRules(ad.getDurationRules());

        List<EnrollmentRequest> approvedRequests = ad.getEnrollmentRequests().stream()
                .filter(er -> er.getStatus() == EnrollmentStatus.APPROVED)
                .toList();
        for (EnrollmentRequest er : approvedRequests) {
            Child child = er.getChild();
            group.getChildren().add(child);
            child.getGroups().add(group);
        }
        group.setChildrenCount(approvedRequests.size());
        ad.setStatus(AdStatus.COMPLETED);

        activity.getGroups().add(group);

        return groupRepository.save(group);
    }

    public Group getById(Integer id) {
        return groupRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Group with id " + id + " not found"));
    }

    public Set<Group> findAllByActivityId(Integer activityId) {
        return groupRepository.findAllByActivityId(activityId);
    }

    public Set<Group> findAllByTrainerId(Integer trainerId) {
        return groupRepository.findAllByTrainerId(trainerId);
    }

    public Set<Group> findAllByChildId(Integer childId) {
        return groupRepository.findAllByChildId(childId);
    }

    public Group update(Integer groupId, Group groupToUpdate) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new EntityNotFoundException("Group with id " + groupId + " not found"));
        group.setTitle(groupToUpdate.getTitle());
        group.setDescription(groupToUpdate.getDescription());
        group.setMinAge(groupToUpdate.getMinAge());
        group.setMaxAge(groupToUpdate.getMaxAge());
        group.setGender(groupToUpdate.getGender());
        group.setLocation(groupToUpdate.getLocation());
        group.setStatus(groupToUpdate.getStatus());
        return groupRepository.save(group);
    }

    public Group addChild(Integer groupId, Integer childId) {
        Group group = getById(groupId);
        Child child = childService.getById(childId);
        group.getChildren().add(child);
        return groupRepository.save(group);
    }

    public Group removeChild(Integer groupId, Integer childId) {
        Group group = getById(groupId);
        Child child = childService.getById(childId);
        group.getChildren().remove(child);
        return groupRepository.save(group);
    }

    public void deleteById(Integer id) {
        groupRepository.deleteById(id);
    }
}
