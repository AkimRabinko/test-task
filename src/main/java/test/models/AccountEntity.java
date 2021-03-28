package test.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name", insertable = false, updatable = false)
    private String firstName;
    @Column(name = "last_name", insertable = false, updatable = false)
    private String lastName;
    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "account_balance")
    private BigDecimal accountBalance;
    @Column(name = "currency")
    private String currency;

    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "first_name", referencedColumnName = "first_name"),
            @JoinColumn(name = "last_name", referencedColumnName = "last_name")
    })
    private UserEntity userEntity;

    @OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "accountEntity", orphanRemoval = true)
    private Operations operations;

    public AccountEntity() {
    }

    public AccountEntity(String firstName, String lastName, String accountNumber, BigDecimal accountBalance, String currency) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.currency = currency;
    }

    public AccountEntity(Long id, String firstName, String lastName, String accountNumber, BigDecimal accountBalance, String currency, Operations operations) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.currency = currency;
        this.operations = operations;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public String getCurrency() {
        return currency;
    }

    public Operations getOperations() {
        return operations;
    }
}
