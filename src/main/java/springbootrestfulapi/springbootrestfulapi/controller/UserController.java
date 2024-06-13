package springbootrestfulapi.springbootrestfulapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootrestfulapi.springbootrestfulapi.dto.UserDto;
import springbootrestfulapi.springbootrestfulapi.entity.User;
import springbootrestfulapi.springbootrestfulapi.service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    // build create User REST API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        System.out.println(user.getEmail());
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<UserDto>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{userId}")
    public  ResponseEntity<UserDto> getUserById(@PathVariable Long userId) {
        UserDto userResult = userService.getUserById(userId);
        return new ResponseEntity<>(userResult, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> usersResult = userService.getAllUsers();
        return new ResponseEntity<List<UserDto>>(usersResult, HttpStatus.OK);
    }
    @PutMapping("{userId}")
    public ResponseEntity<User> updateUserById(@PathVariable Long userId, @RequestBody User user) {
        User updatedUser = userService.updateUser(userId, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<String> updateUserById(@PathVariable Long userId) {
        userService.deleteUserById(userId);
        return new ResponseEntity<>("Deleted user success", HttpStatus.OK);
    }
}
