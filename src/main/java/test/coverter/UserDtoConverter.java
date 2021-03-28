package test.coverter;

import org.springframework.stereotype.Component;
import test.dto.UserDto;
import test.models.UserEntity;
import test.models.UserId;

@Component
public class UserDtoConverter {

    public UserEntity convert(UserDto userDto) {
        UserId userId = new UserId();
        userId.setFirstName(userDto.getFirstName());
        userId.setLastName(userDto.getLastName());
        return new UserEntity(userId, userDto.getAddress());
    }
}
