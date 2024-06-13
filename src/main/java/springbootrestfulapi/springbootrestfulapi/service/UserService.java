package springbootrestfulapi.springbootrestfulapi.service;

import springbootrestfulapi.springbootrestfulapi.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(Long userId, User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    void deleteUserById(Long id);
}
