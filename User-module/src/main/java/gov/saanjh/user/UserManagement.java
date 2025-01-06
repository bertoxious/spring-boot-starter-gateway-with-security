package gov.saanjh.user;

import io.swagger.v3.oas.models.annotations.OpenAPI30;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@OpenAPI30
@SpringBootApplication
@RestController
public class UserManagement {
    public static void main(String[] args) {
        SpringApplication.run(UserManagement.class, args);
    }
}