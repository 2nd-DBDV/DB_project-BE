package DBDV.DB_projectBE.controller;

import DBDV.DB_projectBE.dto.IsSuccessDto;
import DBDV.DB_projectBE.dto.UserDto;
import DBDV.DB_projectBE.service.UserService;
import DBDV.DB_projectBE.table.IdPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> authorizeUser(@RequestBody IdPassword idPassword){
        return new ResponseEntity<>(userService.isMember(idPassword), HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody UserDto user){
        IsSuccessDto isSuccessDto=userService.saveUser(user);
        return new ResponseEntity<>(isSuccessDto, HttpStatus.OK);
    }

}
