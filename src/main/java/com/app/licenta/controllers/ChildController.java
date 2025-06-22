package com.app.licenta.controllers;

import com.app.licenta.dtos.ChildDto;
import com.app.licenta.dtos.ChildUpdateDto;
import com.app.licenta.entities.Child;
import com.app.licenta.entities.Parent;
import com.app.licenta.mappers.ChildMapper;
import com.app.licenta.mappers.ParentMapper;
import com.app.licenta.services.ChildService;
import com.app.licenta.services.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/children")
public class ChildController {

    @Autowired
    private ChildService childService;

    @Autowired
    private ChildMapper childMapper;

    @Autowired
    private ParentMapper parentMapper;

    @Autowired
    private ParentService parentService;

    @GetMapping("/{id}")
    public ChildDto get(@PathVariable Integer id) {
        Child child = childService.getById(id);
        return childMapper.childToChildDto(child);
    }

    @GetMapping("/list/{parentId}")
    public Set<ChildDto> findAllByParentId(@PathVariable Integer parentId) {
        return childMapper.childListToChildDtoList(childService.findAllByParentId(parentId)).stream().sorted(Comparator.comparing(ChildDto::getFirstName)).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @PostMapping("/create/{parentId}")
    public ChildDto create(@PathVariable Integer parentId, @RequestBody ChildDto childDto) {
        Parent parent = parentService.getById(parentId);
        childDto.setParent(parentMapper.parentToParentDto(parent));
        Child childToCreate = childMapper.childDtoToChild(childDto);
        childToCreate.setParent(parent);
        parent.getChildren().add(childToCreate);
        Child createdChild = childService.createChild(childToCreate);

        return childMapper.childToChildDto(createdChild);
    }

    @PutMapping("/{id}")
    public ChildUpdateDto update(@RequestBody ChildUpdateDto childUpdateDto, @PathVariable Integer id) {
        return childMapper.childToChildUpdateDto(childService.update(id, childMapper.childUpdateDtoToChild(childUpdateDto)));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        childService.deleteById(id);
    }
}
