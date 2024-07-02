package springbootrestfulapi.springbootrestfulapi.service;

import springbootrestfulapi.springbootrestfulapi.dto.UserDto;
import springbootrestfulapi.springbootrestfulapi.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto updateUser(Long userId, UserDto user);
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
    void deleteUserById(Long id);
}
