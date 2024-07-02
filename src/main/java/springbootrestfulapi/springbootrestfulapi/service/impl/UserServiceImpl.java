package springbootrestfulapi.springbootrestfulapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import springbootrestfulapi.springbootrestfulapi.dto.UserDto;
import springbootrestfulapi.springbootrestfulapi.entity.User;
import springbootrestfulapi.springbootrestfulapi.exception.EmailAlreadyExistsException;
import springbootrestfulapi.springbootrestfulapi.exception.ResourceNotFoundException;
import springbootrestfulapi.springbootrestfulapi.mapper.AutoUserMapper;
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
        // User userSource = UserMapper.mapUserDtoToUser(userDto);
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());

        if (optionalUser.isPresent()) {
            throw new EmailAlreadyExistsException(userDto.getEmail() + "already exists");
        }

        User userSource = AutoUserMapper.MAPPER.mapUserDtoToUser(userDto);
        User savedUser = userRepository.save(userSource);
        UserDto userResultDto = AutoUserMapper.MAPPER.mapUserToUserDto(savedUser);

        return userResultDto;
    }

    @Override
    public UserDto updateUser(Long userId, UserDto user) {
        User userResult = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userId)
        );

        userResult.setEmail(user.getEmail());
        userResult.setFirstName(user.getFirstName());
        userResult.setLastName(user.getLastName());

        User updatedUser = userRepository.save(userResult);
        UserDto updatedUserResult = AutoUserMapper.MAPPER.mapUserToUserDto(updatedUser);
        return updatedUserResult;
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );
        UserDto userResultDto = AutoUserMapper.MAPPER.mapUserToUserDto(user);
        return userResultDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> AutoUserMapper.MAPPER.mapUserToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
