package com.app.licenta.controllers;

import com.app.licenta.dtos.UserDto;
import com.app.licenta.mappers.UserMapper;
import com.app.licenta.entities.User;
import com.app.licenta.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/{id}")
    public UserDto get(@PathVariable Integer id) {
        User user = userService.getById(id);
        return userMapper.userToUserDto(user);
    }

    @GetMapping("email/{email}")
    public UserDto getByEmail(@PathVariable String email) {
        return userMapper.userToUserDto(userService.getByEmail(email));
    }

    @GetMapping("/list")
    public List<UserDto> findAll() {
        return userMapper.userListToUserDtoList(userService.findAll());
    }

    @PostMapping("/register")
    public UserDto create(@RequestBody UserDto userDto) {
        User userToCreate = userMapper.userDtoToUser(userDto);
        User createdUser = userService.createUser(userToCreate);
        return userMapper.userToUserDto(createdUser);
    }

    @PutMapping("/{id}")
    public UserDto update(@RequestBody UserDto userDto, @PathVariable Integer id) {
        User userToUpdate = userMapper.userDtoToUser(userDto);
        User updatedUser = userService.update(id, userToUpdate);
        return userMapper.userToUserDto(updatedUser);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        userService.deleteById(id);
    }
}
