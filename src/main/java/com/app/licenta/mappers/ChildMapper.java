package com.app.licenta.mappers;

import com.app.licenta.dtos.ChildDto;
import com.app.licenta.entities.Child;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ChildMapper {

    @Autowired
    private ParentMapper parentMapper;

    public Child childDtoToChild(ChildDto childDto) {
        Child child = new Child();
        //child.setId(childCreateDto.getId());
        child.setFirstName(childDto.getFirstName());
        child.setLastName(childDto.getLastName());
        child.setGender(childDto.getGender());
        child.setBirthDate(childDto.getBirthDate());
        child.setParent(parentMapper.parentDtoToParent(childDto.getParent()));
        return child;
    }

    public ChildDto childToChildDto(Child child) {
        ChildDto childDto = new ChildDto();
        childDto.setId(child.getId());
        childDto.setFirstName(child.getFirstName());
        childDto.setLastName(child.getLastName());
        childDto.setGender(child.getGender());
        childDto.setBirthDate(child.getBirthDate());
        childDto.setParent(parentMapper.parentToParentDto(child.getParent()));
        return childDto;
    }

    public Set<ChildDto> childListToChildDtoList(Set<Child> childList) {
        return childList.stream().map(this::childToChildDto).collect(Collectors.toSet());
    }
}
