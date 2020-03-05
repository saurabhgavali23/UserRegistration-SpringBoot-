package userregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import userregistration.dto.ResponseDTO;
import userregistration.dto.UserDTO;
import userregistration.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/update")
public class UserUpdateController {

    @Autowired
    UserService userService;

    @PostMapping("/updateuser")
    public ResponseEntity<ResponseDTO> loginUser(@RequestParam(name = "token") String token, @Valid @RequestBody UserDTO userDTO){
        String user = userService.updateUser(token,userDTO);
        ResponseDTO responseDTO = new ResponseDTO("Successfully Update User: "+user, null);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
