package springbootrestfulapi.springbootrestfulapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootrestfulapi.springbootrestfulapi.dto.UserDto;
import springbootrestfulapi.springbootrestfulapi.service.UserService;

import java.util.List;

@Tag(
        name="CRUD REST APIs for User Resource",
        description = "CURD REST APIs - Create User, Update User, Get User, Get All Users, Delete User"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    @Operation(
            summary = "Create User REST API",
            description = "Create User REST API is used to save user in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    // build create User REST API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user) {
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        System.out.println(user.getEmail());
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<UserDto>(savedUser, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get User By ID REST API",
            description = "Get a single User REST API is used to get a single user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("{userId}")
    public  ResponseEntity<UserDto> getUserById(@PathVariable Long userId) {
        UserDto userResult = userService.getUserById(userId);
        return new ResponseEntity<>(userResult, HttpStatus.OK);
    }

    @Operation(
            summary = "Get All Users REST API",
            description = "Get All Users REST API is used to get all users from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> usersResult = userService.getAllUsers();
        return new ResponseEntity<List<UserDto>>(usersResult, HttpStatus.OK);
    }

    @Operation(
            summary = "Update User By ID REST API",
            description = "Update a single User REST API is used to update a single user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @PutMapping("{userId}")
    public ResponseEntity<UserDto> updateUserById(@PathVariable Long userId, @RequestBody UserDto user) {
        UserDto updatedUser = userService.updateUser(userId, user);
        return new ResponseEntity<UserDto>(updatedUser, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete User By ID REST API",
            description = "Delete a single User REST API is used to get a single user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @DeleteMapping("{userId}")
    public ResponseEntity<String> updateUserById(@PathVariable Long userId) {
        userService.deleteUserById(userId);
        return new ResponseEntity<>("Deleted user success", HttpStatus.OK);
    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetail> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest webRequest) {
//        ErrorDetail errorDetail = new ErrorDetail(
//                LocalDateTime.now(),
//                ex.getMessage(),
//                webRequest.getDescription(false),
//                "USER_NOT_FOUND"
//        );
//
//        return new ResponseEntity<ErrorDetail>(errorDetail, HttpStatus.NOT_FOUND);
//    }
}
