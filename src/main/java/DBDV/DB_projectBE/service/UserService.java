package DBDV.DB_projectBE.service;

import DBDV.DB_projectBE.dto.IsSuccessDto;
import DBDV.DB_projectBE.dto.UserDto;
import DBDV.DB_projectBE.repository.UserRepository;
import DBDV.DB_projectBE.table.IdPassword;
import DBDV.DB_projectBE.table.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User isMember(IdPassword idPassword){
        User user = new User();
        try{
            user = userRepository.findByIdAndPassword(idPassword);
        } catch(EmptyResultDataAccessException e){

        } finally {
            return user;
        }
    }

    public IsSuccessDto saveUser(UserDto user){
        try {
            IsSuccessDto isSuccessDto = userRepository.insertUser(user);
            return isSuccessDto;
        } catch (DuplicateKeyException e){
            return new IsSuccessDto(false);
        }
    }
}
