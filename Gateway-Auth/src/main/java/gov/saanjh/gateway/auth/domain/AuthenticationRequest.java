package gov.saanjh.gateway.auth.domain;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String email;
    private String password;
}

