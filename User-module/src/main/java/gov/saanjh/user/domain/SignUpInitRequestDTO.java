package gov.saanjh.user.domain;

import lombok.Data;

@Data
public class SignUpInitRequestDTO {
    private String name;
    private String email;
    private String password;
    private UserType userType;
}
