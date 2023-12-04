package DBDV.DB_projectBE.table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private String id;
    private String pw;
    private String email;
    private String name;
}
