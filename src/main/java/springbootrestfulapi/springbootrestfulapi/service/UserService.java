package springbootrestfulapi.springbootrestfulapi.service;

import springbootrestfulapi.springbootrestfulapi.dto.UserDto;
import springbootrestfulapi.springbootrestfulapi.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    User updateUser(Long userId, User user);
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
    void deleteUserById(Long id);
}
