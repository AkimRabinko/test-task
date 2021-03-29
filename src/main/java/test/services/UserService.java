package test.services;

import test.dto.UserDto;
import test.models.UserEntity;
import test.models.UserId;

import java.util.Set;

public interface UserService {
    Set<UserEntity> getUsersList();

    void saveUser(UserDto userDto);

    void deleteUser(UserId userId);
}
