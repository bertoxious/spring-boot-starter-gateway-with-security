package gov.saanjh.user.domain;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String email;
    private String password;
}
