package res.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import res.domain.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
