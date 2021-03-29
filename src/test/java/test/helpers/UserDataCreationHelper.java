package test.helpers;

import test.dto.UserDto;
import test.models.*;

import java.math.BigDecimal;
import java.util.Set;

public class UserDataCreationHelper {
    public static final UserDto USER_DTO = new UserDto("test", "test", "test");
    public static final UserId USER_ID = createUserId();
    public static final UserEntity USER_ENTITY = new UserEntity(USER_ID, USER_DTO.getAddress());
    public static final UserEntity USER_ENTITY_WITH_ACCOUNT = createUserEntityWithAccount();

    private static UserId createUserId() {
        UserId userId = new UserId();
        userId.setFirstName(USER_DTO.getFirstName());
        userId.setLastName(USER_DTO.getLastName());
        return userId;
    }

    private static UserEntity createUserEntityWithAccount() {
        return new UserEntity(USER_ID, USER_DTO.getAddress(), Set.of(createAccountEntity()));
    }

    private static AccountEntity createAccountEntity() {
        return new AccountEntity(1L, USER_DTO.getFirstName(), USER_DTO.getLastName(), "123456789012",
                BigDecimal.valueOf(200), "USD", createOperations());
    }

    private static Operations createOperations() {
        return new Operations(
                1L, USER_DTO.getFirstName(), USER_DTO.getLastName(), 2, BigDecimal.valueOf(120), Operation.INCOME);
    }
}
