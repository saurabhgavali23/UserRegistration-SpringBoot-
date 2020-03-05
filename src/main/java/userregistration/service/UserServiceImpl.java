package userregistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import userregistration.dto.UserDTO;
import userregistration.exception.UserException;
import userregistration.model.User;
import userregistration.repository.UserRepository;
import userregistration.util.JwtToken;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    JwtToken token;

    @Override
    public User addUser(UserDTO userDTO) {
        User user = new User(userDTO);
        Optional<User> byEmailId = userRepository.findByEmail(userDTO.email);
        if (byEmailId.isPresent()) {
            throw new UserException("User already registered with this email Id");
        }
        userRepository.save(user);
        return user;
    }

    @Override
    public String loginUser(String uName, String pass) {
        User user = userRepository.findByEmail(uName)
                .orElseThrow(()->  new UserException("User Nor Register With this email id"));

        if (!encoder.matches(pass,user.getPassword())) {
            throw new UserException("PassWord Is Invalid");
        }
        String token = this.token.generateToken(user.getEmail());
        return token;
    }

    @Override
    public String updateUser(String token, UserDTO userDTO) {
        User user = userRepository.findByEmail(userDTO.email).orElseThrow(()-> new UserException("User Nor Register With this email id"));
        Boolean validateToken = this.token.validateToken(token, userDTO);
        if (validateToken){
            User user1 = new User(userDTO);
            user1.userId = user.userId;
            userRepository.save(user1);
        }
        return user.getEmail();
    }
}
