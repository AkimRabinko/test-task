package test.services.impl;

import org.junit.jupiter.api.Test;
import test.coverters.UserDtoConverter;
import test.repositories.UserRepository;
import test.services.AccountService;
import test.services.UserService;

import static org.mockito.Mockito.*;
import static test.helpers.UserDataCreationHelper.*;

public class UserServiceImplTest {
    private final UserRepository userRepository = mock(UserRepository.class);
    private final AccountService accountService = mock(AccountService.class);
    private final UserDtoConverter userDtoConverter = mock(UserDtoConverter.class);

    private final UserService userService = new UserServiceImpl(userRepository, accountService, userDtoConverter);

    @Test
    public void testSaveUserVerifyCalls() {
        when(userDtoConverter.convert(USER_DTO)).thenReturn(USER_ENTITY);
        userService.saveUser(USER_DTO);
        verify(userRepository).save(USER_ENTITY);
        verify(accountService).createDefault(USER_DTO);
    }

    @Test
    public void testDeleteUserVerifyCalls() {
        userService.deleteUser(USER_ID);
        verify(userRepository).deleteById(USER_ID);
    }


}
