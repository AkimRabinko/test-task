package test.services;

import test.dto.UserDto;
import test.models.UserEntity;

import java.util.Set;

public interface UserService {
    Set<UserEntity> getUsersList();

    void saveUser(UserDto userDto);

    void deleteUser(UserDto userDto);
}
