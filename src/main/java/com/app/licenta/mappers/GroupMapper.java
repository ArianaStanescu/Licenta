package com.app.licenta.mappers;

import com.app.licenta.dtos.GroupDto;
import com.app.licenta.dtos.GroupGetDto;
import com.app.licenta.entities.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class GroupMapper {

    @Autowired
    private ActivityMapper activityMapper;

    public Group groupDtoToGroup(GroupDto groupDto) {
        Group group = new Group();
        //group.setId(groupDto.getId());
        group.setTitle(groupDto.getTitle());
        group.setDescription(groupDto.getDescription());
        group.setChildrenCount(groupDto.getChildrenCount());
        group.setMinAge(groupDto.getMinAge());
        group.setMaxAge(groupDto.getMaxAge());
        group.setGender(groupDto.getGender());
        group.setStatus(groupDto.getStatus());
        group.setActivityDays(groupDto.getActivityDays());
        group.setActivity(activityMapper.activityDtoToActivity(groupDto.getActivity()));
        return group;
    }

    public GroupDto groupToGroupDto(Group group) {
        GroupDto groupDto = new GroupDto();
        groupDto.setId(group.getId());
        groupDto.setTitle(group.getTitle());
        groupDto.setDescription(group.getDescription());
        groupDto.setChildrenCount(group.getChildrenCount());
        groupDto.setMinAge(group.getMinAge());
        groupDto.setMaxAge(group.getMaxAge());
        groupDto.setGender(group.getGender());
        groupDto.setStatus(group.getStatus());
        groupDto.setActivityDays(group.getActivityDays());
        groupDto.setActivity(activityMapper.activityToActivityDto(group.getActivity()));
        return groupDto;
    }

    public Set<GroupDto> groupListToGroupDtoList(Set<Group> groupList) {
        return groupList.stream().map(this::groupToGroupDto).collect(Collectors.toSet());
    }

    public GroupGetDto groupToGroupGetDto(Group group) {
        GroupGetDto groupGetDto = new GroupGetDto();
        groupGetDto.setId(group.getId());
        groupGetDto.setTitle(group.getTitle());
        groupGetDto.setDescription(group.getDescription());
        groupGetDto.setChildrenCount(group.getChildrenCount());
        groupGetDto.setMinAge(group.getMinAge());
        groupGetDto.setMaxAge(group.getMaxAge());
        groupGetDto.setGender(group.getGender());
        groupGetDto.setStatus(group.getStatus());
        groupGetDto.setActivityDays(group.getActivityDays());
        groupGetDto.setActivity(activityMapper.activityToActivityDto(group.getActivity()));
        groupGetDto.setChildren(group.getChildren());
        return groupGetDto;
    }
}
