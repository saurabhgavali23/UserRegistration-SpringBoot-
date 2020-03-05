package userregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import userregistration.dto.ResponseDTO;
import userregistration.dto.UserDTO;
import userregistration.model.User;
import userregistration.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserRegisterController {

    @Autowired
    UserService userService;

    @PostMapping("/registeruser")
    public ResponseEntity<ResponseDTO> registerUser(@Valid @RequestBody UserDTO userDTO){
        User user = userService.addUser(userDTO);
        ResponseDTO responseDTO = new ResponseDTO("User Successfully Register",user);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
