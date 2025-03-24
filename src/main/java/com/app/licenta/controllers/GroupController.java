package com.app.licenta.controllers;

import com.app.licenta.dtos.GroupDto;
import com.app.licenta.dtos.GroupGetDto;
import com.app.licenta.entities.Activity;
import com.app.licenta.entities.Child;
import com.app.licenta.entities.Group;
import com.app.licenta.mappers.ActivityMapper;
import com.app.licenta.mappers.GroupMapper;
import com.app.licenta.services.ActivityService;
import com.app.licenta.services.ChildService;
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
    private ChildService childService;

    @GetMapping("/{id}")
    public GroupGetDto get(@PathVariable Integer id) {
        Group group = groupService.getById(id);
        return groupMapper.groupToGroupGetDto(group);
    }

    @GetMapping("/list-by-activity/{activityId}")
    public Set<GroupDto> findAllByActivityId(@PathVariable Integer activityId) {
        return groupMapper.groupListToGroupDtoList(groupService.findAllByActivityId(activityId));
    }

    @GetMapping("/list-by-child/{childId}")
    public Set<GroupDto> findAllByChildId(@PathVariable Integer childId) {
        return groupMapper.groupListToGroupDtoList(groupService.findAllByChildId(childId));
    }

    @PostMapping("/create/{activityId}/{adId}")
    public GroupDto create(@PathVariable Integer activityId, @PathVariable Integer adId) {
        Group createdGroup = groupService.createGroup(activityId, adId);

        return groupMapper.groupToGroupDto(createdGroup);
    }

    //update

    @PutMapping("/add-child/{groupId}/{childId}")
    public GroupDto addChildToGroup(@PathVariable Integer groupId, @PathVariable Integer childId) {
        Group group = groupService.getById(groupId);
        Child child = childService.getById(childId);
        group.getChildren().add(child);
        Group updatedGroup = groupService.update(group);
        return groupMapper.groupToGroupDto(updatedGroup);
    }

    @PutMapping("/remove-child/{groupId}/{childId}")
    public GroupDto removeChildToGroup(@PathVariable Integer groupId, @PathVariable Integer childId) {
        Group group = groupService.getById(groupId);
        Child child = childService.getById(childId);
        group.getChildren().remove(child);
        Group updatedGroup = groupService.update(group);
        return groupMapper.groupToGroupDto(updatedGroup);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        groupService.deleteById(id);
    }
}
