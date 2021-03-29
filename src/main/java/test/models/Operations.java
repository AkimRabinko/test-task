package test.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "operations")
public class Operations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "account_id", insertable = false, updatable = false)
    private int accountId;
    @Column(name = "total_sum")
    private BigDecimal totalSum;
    @Column(name = "operation")
    private Operation operation;


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private AccountEntity accountEntity;


    public Operations() {
    }

    public Operations(long id, String firstName, String lastName, int accountId, BigDecimal totalSum, Operation operation) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountId = accountId;
        this.totalSum = totalSum;
        this.operation = operation;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAccountId() {
        return accountId;
    }

    public BigDecimal getTotalSum() {
        return totalSum;
    }

    public Operation getOperation() {
        return operation;
    }
}
