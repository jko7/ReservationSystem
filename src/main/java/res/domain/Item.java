package res.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Item extends AbstractPersistable<Long> {

    private String name;
    @Id
    private Long id;

    public Item() {
    }
    
    public Item(String name) {
        this.name = name;
      
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
