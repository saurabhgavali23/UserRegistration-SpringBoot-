package userregistration.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import userregistration.dto.UserDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer userId;
    private String name;
    private String email;
    private String password;
    private String mobileNo;

    public User(UserDTO userDTO) {
        this.email = userDTO.email;
        this.name = userDTO.name;
        this.mobileNo = userDTO.mobileNo;
        this.password = new BCryptPasswordEncoder().encode(userDTO.password);
    }
}
