package gov.saanjh.user.controller;

import gov.saanjh.user.domain.LoginRequestDTO;
import gov.saanjh.user.domain.LoginResponseDTO;
import gov.saanjh.user.service.AuthService;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static gov.saanjh.user.domain.UserConstants.*;


@RestController
@CrossOrigin
@Slf4j
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping(LOGIN)
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.ok().body(authService.login(loginRequestDTO));
    }

    @PostMapping(LOGOUT)
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok().body(authService.logout(token));
    }

    @PostMapping(FORGET_PASSWORD)
    public ResponseEntity<String> forgotPassword(@RequestParam String username, Model model) throws MessagingException {
        return ResponseEntity.ok().body(authService.initiateForgotPassword(username,model));
    }

    @PostMapping(CONFIRM_PASSWORD)
    public ResponseEntity<String> confirmForgotPassword(
            @RequestParam String username,
            @RequestParam String newPassword,
            @RequestParam String confirmationCode) {
        return ResponseEntity.ok().body(authService.confirmNewPassword(username, newPassword, confirmationCode));
    }

    @GetMapping("/validate")
    public ResponseEntity<Boolean> validateToken(@RequestParam String token){
        return ResponseEntity.ok().body(authService.validateToken(token));

    }

}
