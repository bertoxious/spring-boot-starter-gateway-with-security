package gov.saanjh.user.domain;

import lombok.Data;

@Data
public class SignUpConfirmRequestDTO {
    private String email;
    private String code;
}
