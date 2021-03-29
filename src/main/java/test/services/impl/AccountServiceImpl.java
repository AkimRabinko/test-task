package test.services.impl;

import org.springframework.stereotype.Service;
import test.dto.UserDto;
import test.models.AccountEntity;
import test.repositories.AccountRepository;
import test.services.AccountService;
import test.utils.AccountNumberGeneratorUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    private static final String DEFAULT_CURRENCY = "USD";

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void createDefault(UserDto userDto) {
        String accountNumber = AccountNumberGeneratorUtils.generateAccountNumber(getPresentAccounts());
        accountRepository.save(BigDecimal.ZERO, accountNumber, DEFAULT_CURRENCY, userDto.getFirstName(), userDto.getLastName());
    }

    private List<String> getPresentAccounts() {
        return accountRepository.findAll()
                .stream()
                .map(AccountEntity::getAccountNumber)
                .collect(Collectors.toUnmodifiableList());
    }
}
