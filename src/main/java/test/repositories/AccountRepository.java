package test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import test.models.AccountEntity;

import java.math.BigDecimal;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    @Modifying
    @Query(value = "insert into accounts (account_balance, account_number, currency, first_name, last_name) " +
            "values (:balance, :account_number, :currency, :first_name, :last_name)",
            nativeQuery = true)
    void save(@Param("balance") BigDecimal balance,
                       @Param("account_number") String accountNumber,
                       @Param("currency") String currency,
                       @Param("first_name") String firstName,
                       @Param("last_name") String lastName);
}
