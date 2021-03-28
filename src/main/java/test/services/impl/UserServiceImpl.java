package test.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import test.coverter.UserDtoConverter;
import test.dto.UserDto;
import test.models.UserEntity;
import test.repositories.UserRepository;
import test.services.AccountService;
import test.services.UserService;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AccountService accountService;
    private final UserDtoConverter userDtoConverter;

    public UserServiceImpl(UserRepository userRepository, AccountService accountService, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.accountService = accountService;
        this.userDtoConverter = userDtoConverter;
    }

    @Override
    public Set<UserEntity> getUsersList() {
        return userRepository.getUsersList();
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void saveUser(UserDto userDto) {
        UserEntity userEntity = userDtoConverter.convert(userDto);
        userRepository.save(userEntity);
        accountService.createDefault(userDto);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void deleteUser(UserDto userDto) {
        userRepository.delete(userDtoConverter.convert(userDto));
    }
}
