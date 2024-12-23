package com.app.licenta.controllers;

import com.app.licenta.dtos.GroupDto;
import com.app.licenta.dtos.GroupGetDto;
import com.app.licenta.entities.Activity;
import com.app.licenta.entities.Group;
import com.app.licenta.mappers.ActivityMapper;
import com.app.licenta.mappers.GroupMapper;
import com.app.licenta.services.ActivityService;
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
    private ActivityMapper activityMapper;

    @Autowired
    private ActivityService activityService;

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

    @PostMapping("/create/{activityId}")
    public GroupDto create(@PathVariable Integer activityId, @RequestBody GroupDto groupDto) {
        Activity activity = activityService.getById(activityId);
        groupDto.setActivity(activityMapper.activityToActivityDto(activity));
        Group groupToCreate = groupMapper.groupDtoToGroup(groupDto);
        groupToCreate.setActivity(activity);
        activity.getGroups().add(groupToCreate);
        Group createdGroup = groupService.createGroup(groupToCreate);

        return groupMapper.groupToGroupDto(createdGroup);
    }

    //update


//    @DeleteMapping("/{id}")
//    public void deleteById(@PathVariable Integer id) {
//        activityService.deleteById(id);
//    }
}
