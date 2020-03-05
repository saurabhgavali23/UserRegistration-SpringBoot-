package userregistration.dto;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import userregistration.configuration.UserSecurity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Component
@Getter
public class UserDTO {

    @Length(min = 3,max = 10,message = "Invalid User Name")
    public String name;
    @Email(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$",message = "Enter Valid Email")
    public String email;
    @Pattern(regexp ="^[a-zA-Z0-9]{3,}",message="length min 3")
    public String password;
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Invalid Mobile No.")
    public String mobileNo;
}
