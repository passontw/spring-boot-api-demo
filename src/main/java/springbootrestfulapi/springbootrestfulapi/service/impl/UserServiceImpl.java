package springbootrestfulapi.springbootrestfulapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import springbootrestfulapi.springbootrestfulapi.entity.User;
import springbootrestfulapi.springbootrestfulapi.repository.UserRepository;
import springbootrestfulapi.springbootrestfulapi.service.UserService;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
