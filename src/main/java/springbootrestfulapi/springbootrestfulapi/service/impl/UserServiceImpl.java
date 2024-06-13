package springbootrestfulapi.springbootrestfulapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import springbootrestfulapi.springbootrestfulapi.dto.UserDto;
import springbootrestfulapi.springbootrestfulapi.entity.User;
import springbootrestfulapi.springbootrestfulapi.mapper.UserMapper;
import springbootrestfulapi.springbootrestfulapi.repository.UserRepository;
import springbootrestfulapi.springbootrestfulapi.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class    UserServiceImpl implements UserService {

    private UserRepository userRepository;


    @Override
    public UserDto createUser(UserDto userDto) {
        User userSource = UserMapper.mapUserDtoToUser(userDto);
        User savedUser = userRepository.save(userSource);
        UserDto userResultDto = UserMapper.mapUserToUserDto(savedUser)

        return userResultDto;
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
    public UserDto getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        UserDto userResultDto = UserMapper.mapUserToUserDto(optionalUser.get());
        return userResultDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::mapUserToUserDto).collect(Collectors.toList());
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
