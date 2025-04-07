package com.app.licenta.controllers;

import com.app.licenta.dtos.GroupDto;
import com.app.licenta.dtos.GroupGetDto;
import com.app.licenta.emails.EmailService;
import com.app.licenta.entities.Child;
import com.app.licenta.entities.Group;
import com.app.licenta.mappers.GroupMapper;
import com.app.licenta.notifications.FirebaseNotificationSender;
import com.app.licenta.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private EmailService emailService;
    @Autowired
    private FirebaseNotificationSender firebaseNotificationSender;

    @GetMapping("/{id}")
    public GroupGetDto get(@PathVariable Integer id) {
        Group group = groupService.getById(id);
        return groupMapper.groupToGroupGetDto(group);
    }

    @GetMapping("/list-by-activity/{activityId}")
    public Set<GroupDto> findAllByActivityId(@PathVariable Integer activityId) {
        return groupMapper.groupListToGroupDtoList(groupService.findAllByActivityId(activityId));
    }

    @GetMapping("/list-by-trainer/{trainerId}")
    public Set<GroupDto> findAllByTrainerId(@PathVariable Integer trainerId) {
        return groupMapper.groupListToGroupDtoList(groupService.findAllByTrainerId(trainerId));
    }

    @GetMapping("/list-by-child/{childId}")
    public Set<GroupDto> findAllByChildId(@PathVariable Integer childId) {
        return groupMapper.groupListToGroupDtoList(groupService.findAllByChildId(childId));
    }

    @PostMapping("/create/{activityId}/{adId}")
    public GroupDto create(@PathVariable Integer activityId, @PathVariable Integer adId) {
        Group createdGroup = groupService.createGroup(activityId, adId);

        String bodyMessage = "Grupa " + createdGroup.getTitle() + " a fost creata cu succes!";
        String subjectMessage = "Grupa a fost creata!";


        Set<Child> children = createdGroup.getChildren();
        for (Child child : children) {
            Integer parentId = child.getParent().getId();
            emailService.sendVerificationEmail(child.getParent().getEmail(), subjectMessage, bodyMessage);
            firebaseNotificationSender.sendNotificationForParent(parentId, subjectMessage, bodyMessage);
        }

        return groupMapper.groupToGroupDto(createdGroup);
    }

//    @PutMapping("/update/{groupId}")
//    public GroupDto update(@PathVariable Integer groupId, @RequestBody GroupDto groupDto) {
//        Group group = groupMapper.groupDtoToGroup(groupDto);
//        Group updatedGroup = groupService.update(groupId, groupDto);
//        return groupMapper.groupToGroupDto(updatedGroup);
//    }


    @PutMapping("/add-child/{groupId}/{childId}")
    public GroupDto addChildToGroup(@PathVariable Integer groupId, @PathVariable Integer childId) {
        return groupMapper.groupToGroupDto(groupService.addChild(groupId, childId));
    }

    @PutMapping("/remove-child/{groupId}/{childId}")
    public GroupDto removeChildFromGroup(@PathVariable Integer groupId, @PathVariable Integer childId) {
        Group updatedGroup = groupService.removeChild(groupId, childId);
        return groupMapper.groupToGroupDto(updatedGroup);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        groupService.deleteById(id);
    }
}
