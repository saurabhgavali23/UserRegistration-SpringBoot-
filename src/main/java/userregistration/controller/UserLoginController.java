package userregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import userregistration.dto.ResponseDTO;
import userregistration.service.UserService;

@RestController
@RequestMapping("/login")
public class UserLoginController {

    @Autowired
    UserService userService;

    @PostMapping("/loginuser")
    public ResponseEntity<ResponseDTO> loginUser(@RequestParam(name = "email") String uName, @RequestParam(name = "password") String pass){
        String user = userService.loginUser(uName, pass);
        ResponseDTO responseDTO = new ResponseDTO("Successfully Login By User: "+user, null);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
