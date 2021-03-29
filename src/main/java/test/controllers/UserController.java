package test.controllers;

import org.springframework.web.bind.annotation.*;
import test.dto.UserDto;
import test.models.UserEntity;
import test.models.UserId;
import test.services.UserService;

import java.util.Set;

@RequestMapping("api/users")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("list")
    public Set<UserEntity> getUsersList() {
        return userService.getUsersList();
    }

    @PostMapping
    public void saveUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
    }

    @DeleteMapping
    public void deleteUser(@RequestBody UserId userId) {
        userService.deleteUser(userId);
    }
}
