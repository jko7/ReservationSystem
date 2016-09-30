package res.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Account extends AbstractPersistable<Long> {
    
    @Id
    private Long id;

    @NotBlank
    @Length(min = 4, max = 10)
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    @Length(min = 4, max = 30)
    private String name;
    @NotBlank
    @Email
    private String email;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> authorities;
    

    public Account() {
        List <String> authorities = Arrays.asList("USER");
        this.authorities = authorities;
    }

    public Account(String username, String password, String name, String email, List<String> authorities) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.authorities = authorities;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public List<String> getAuthorities() {
        return authorities;
    }
 
    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Username: " + username +"\n" + "Name: " + name + "\n" + "Email: " + email;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.password);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
