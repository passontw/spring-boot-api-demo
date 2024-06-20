package springbootrestfulapi.springbootrestfulapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import springbootrestfulapi.springbootrestfulapi.dto.UserDto;
import springbootrestfulapi.springbootrestfulapi.entity.User;

@Mapper
public interface AutoUserMapper {
    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);
//    @Mapping(source = "email", target = "email")
    UserDto mapUserToUserDto(User user);
    User mapUserDtoToUser(UserDto userDto);
}
