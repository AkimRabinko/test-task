package test.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import test.models.UserEntity;

import java.util.List;
import java.util.Set;


public interface UserRepository extends CrudRepository<UserEntity, Long> {

    @Query(value = "SELECT us.*, ac.id AS accounts_id, ac.first_name AS accounts_first_name,  " +
            "ac.last_name AS accounts_last_name, ac.account_number, ac.account_balance, ac.currency, " +
            "op.id AS operations_id, op.first_name AS operations_first_name, op.last_name AS operations_last_name, " +
            "op.account_id, op.total_sum, op.operation, op.datetime " +
            "FROM USERS AS us " +
            "LEFT JOIN ACCOUNTS AS ac ON (ac.first_name = us.first_name AND ac.last_name= us.last_name) " +
            "LEFT JOIN OPERATIONS AS op ON (op.account_id = ac.id AND op.datetime = (SELECT max(datetime) FROM OPERATIONS WHERE account_id = ac.id)) " +
            "ORDER BY ac.account_number ASC, ac.currency DESC ",
            nativeQuery = true)
    Set<UserEntity> getUsersList();


}
