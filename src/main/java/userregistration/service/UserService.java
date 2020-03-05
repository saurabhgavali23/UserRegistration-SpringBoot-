package userregistration.service;


import userregistration.dto.UserDTO;
import userregistration.model.User;

public interface UserService {
    User addUser(UserDTO userDTO);

    String loginUser(String uName, String pass);

    String updateUser(String token, UserDTO userDTO);
}
