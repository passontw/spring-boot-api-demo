package springbootrestfulapi.springbootrestfulapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import springbootrestfulapi.springbootrestfulapi.entity.User;
import springbootrestfulapi.springbootrestfulapi.repository.UserRepository;
import springbootrestfulapi.springbootrestfulapi.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class    UserServiceImpl implements UserService {

    private UserRepository userRepository;


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long userId, User user) {
        User userResult = userRepository.findById(userId).get();
        userResult.setEmail(user.getEmail());
        userResult.setFirstName(user.getFirstName());
        userResult.setLastName(user.getLastName());

        User updatedUser = userRepository.save(userResult);
        return updatedUser;
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
