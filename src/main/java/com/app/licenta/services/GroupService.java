package com.app.licenta.services;

import com.app.licenta.entities.*;
import com.app.licenta.repositories.GroupRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private ActivityService activityService;
    @Autowired
    private AdService adService;

    public Group createGroup(Integer activityId, Integer adId) {
        Activity activity = activityService.getById(activityId);
        Ad ad = adService.getById(adId);

        Group group = new Group();
        group.setTitle(ad.getTitle());
        group.setDescription(ad.getDescription());
        group.setMinAge(ad.getMinAge());
        group.setMaxAge(ad.getMaxAge());
        group.setGender(ad.getGender());
        group.setStatus(ChildrenGroupStatus.ACTIVE);
        group.setActivity(activity);
        group.setActivityDays(ad.getActivityDays());
        long approvedCount = ad.getEnrollmentRequests().stream()
                .filter(er -> er.getStatus() == EnrollmentStatus.APPROVED)
                .count();
        if (approvedCount == ad.getTotalSpots()) {
            group.setChildrenCount(ad.getTotalSpots());
        } else {
            group.setChildrenCount((int) approvedCount);
        }
        activity.getGroups().add(group);

        return groupRepository.save(group);
    }

    public Group getById(Integer id) {
        return groupRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Group with id " + id + " not found"));
    }

//    public List<Activity> findAll() {
//        return activityRepository.findAll();
//    }

    public Set<Group> findAllByActivityId(Integer activityId) {
        return groupRepository.findAllByActivityId(activityId);
    }

    public Set<Group> findAllByChildId(Integer childId) {
        return groupRepository.findAllByChildId(childId);
    }

    // update

    public Group update(Group group) {
        if (!groupRepository.existsById(group.getId())) {
            throw new EntityNotFoundException("Group with id " + group.getId() + " not found");
        }
        return groupRepository.save(group);
    }

    public void deleteById(Integer id) {
        groupRepository.deleteById(id);
    }
}
