package DBDV.DB_projectBE.repository;

import DBDV.DB_projectBE.dto.IsSuccessDto;
import DBDV.DB_projectBE.dto.UserDto;
import DBDV.DB_projectBE.table.IdPassword;
import DBDV.DB_projectBE.table.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User findByIdAndPassword(IdPassword idPassword) throws EmptyResultDataAccessException{
        var rowMapper = BeanPropertyRowMapper.newInstance(User.class);
        User user = jdbcTemplate.queryForObject("SELECT *\n" + "FROM USER\n" + "WHERE USER_ID=? AND PW=?", rowMapper, idPassword.getId(), idPassword.getPw());
    return user;
    }

    public IsSuccessDto insertUser(UserDto userDto) throws DuplicateKeyException{
        jdbcTemplate.update("insert into USER " + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)", 1, userDto.getId(), userDto.getPw(), userDto.getName(), 0, userDto.getEmail(), 0, 0, 0);
        return new IsSuccessDto(true);
    }
}
