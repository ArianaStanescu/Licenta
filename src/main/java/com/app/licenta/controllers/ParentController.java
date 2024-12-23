package com.app.licenta.controllers;

import com.app.licenta.dtos.ParentDto;
import com.app.licenta.entities.Parent;
import com.app.licenta.mappers.ParentMapper;
import com.app.licenta.services.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parents")
public class ParentController {

    @Autowired
    private ParentService parentService;

    @Autowired
    private ParentMapper parentMapper;

    @GetMapping("/{id}")
    public ParentDto get(@PathVariable Integer id) {
        Parent parent = parentService.getById(id);
        return parentMapper.parentToParentDto(parent);
    }
//
//    @GetMapping("email/{email}")
//    public UserDto getByEmail(@PathVariable String email) {
//        return userMapper.userToUserDto(userService.getByEmail(email));
//    }
//
    @GetMapping("/list")
    public List<ParentDto> findAll() {
        return parentMapper.parentListToParentDtoList(parentService.findAll());
    }

    @PostMapping("/register")
    public ParentDto create(@RequestBody ParentDto parentDto) {
        Parent parentToCreate = parentMapper.parentDtoToParent(parentDto);
        Parent createdParent = parentService.createParent(parentToCreate);
        return parentMapper.parentToParentDto(createdParent);
    }

    //update

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        parentService.deleteById(id);
    }
}
