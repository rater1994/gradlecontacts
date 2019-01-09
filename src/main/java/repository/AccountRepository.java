package repository;

import entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository <Account, Integer> {
    Optional<Account> findByUsername(String username);
    Optional <Account> findByPassword(String password);
    boolean existsByUsername(String username);
    boolean existsByPassword(String password);
    Account findById(int id);
}
