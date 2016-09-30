package res.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import res.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByUsername(String username);
}
