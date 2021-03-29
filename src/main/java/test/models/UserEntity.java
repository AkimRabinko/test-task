package test.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity {
    @EmbeddedId
    private UserId userId;
    private String address;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "userEntity", orphanRemoval = true)
    private Set<AccountEntity> accounts;

    public UserEntity() {
    }

    public UserEntity(UserId userId, String address) {
        this.userId = userId;
        this.address = address;
    }

    public UserEntity(UserId userId, String address, Set<AccountEntity> accounts) {
        this.userId = userId;
        this.address = address;
        this.accounts = accounts;
    }

    public UserId getUserId() {
        return userId;
    }

    public String getAddress() {
        return address;
    }

    public Set<AccountEntity> getAccounts() {
        return accounts;
    }
}
