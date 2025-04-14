package com.app.licenta.mappers;

import com.app.licenta.dtos.ParentDto;
import com.app.licenta.dtos.ParentWithChildrenDto;
import com.app.licenta.entities.Child;
import com.app.licenta.entities.Parent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParentMapper {

    public Parent parentDtoToParent(ParentDto parentDto) {
        Parent parent = new Parent();
       // parent.setId(parentDto.getId());
        parent.setFirstName(parentDto.getFirstName());
        parent.setLastName(parentDto.getLastName());
        parent.setEmail(parentDto.getEmail());
        parent.setPhoneNumber(parentDto.getPhoneNumber());
        parent.setGender(parentDto.getGender());
        return parent;
    }

    public ParentDto parentToParentDto(Parent parent) {
        ParentDto parentDto = new ParentDto();
        parentDto.setId(parent.getId());
        parentDto.setFirstName(parent.getFirstName());
        parentDto.setLastName(parent.getLastName());
        parentDto.setEmail(parent.getEmail());
        parentDto.setPhoneNumber(parent.getPhoneNumber());
        parentDto.setGender(parent.getGender());
        return parentDto;
    }

    public ParentWithChildrenDto parentToParentWithChildrenDto(Parent parent, List<Child> childrenInGroup) {
        ParentWithChildrenDto parentDto = new ParentWithChildrenDto();
        parentDto.setId(parent.getId());
        parentDto.setFirstName(parent.getFirstName());
        parentDto.setLastName(parent.getLastName());
        parentDto.setEmail(parent.getEmail());
        parentDto.setPhoneNumber(parent.getPhoneNumber());
        parentDto.setGender(parent.getGender());
        parentDto.setChildren(parent.getChildren().stream()
                .filter(child -> childrenInGroup.stream()
                        .anyMatch(childInGroup -> childInGroup.getId().equals(child.getId())))
                .map(Child::getFirstName)
                .toList());
        return parentDto;
    }

    public List<ParentDto> parentListToParentDtoList(List<Parent> parentList){
        return parentList.stream().map(this::parentToParentDto).collect(Collectors.toList());
    }
}
