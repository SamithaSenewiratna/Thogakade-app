package dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private String userName;
    private String email;
    private String password;
}
