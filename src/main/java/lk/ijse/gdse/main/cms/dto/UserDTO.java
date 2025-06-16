package lk.ijse.gdse.main.cms.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class UserDTO {
    private int id;
    private String fullName;
    private String username;
    private String password;
    private String role;

    public UserDTO(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public UserDTO(String fullname, String username, String password, String role) {
        this.fullName = fullname;
        this.username = username;
        this.password = password;
        this.role = role;
    }


}
