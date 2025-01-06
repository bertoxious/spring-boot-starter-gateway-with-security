package gov.saanjh.user.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailRequestDTO {
    private String emailAddress;
    private EmailType emailType;
    private String otp;
}
