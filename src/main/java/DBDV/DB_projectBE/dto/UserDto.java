package DBDV.DB_projectBE.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private String id;
    private String pw;
    private String email;
    private String name;
    private String board_id;
}
