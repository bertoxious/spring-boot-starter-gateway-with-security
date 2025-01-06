package gov.saanjh.user.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseDTO {
    private String idToken;
    private String refreshToken;
    private String message;
}
