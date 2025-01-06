package gov.saanjh.user.controller;

import gov.saanjh.user.domain.SignUpConfirmRequestDTO;
import gov.saanjh.user.domain.SignUpInitRequestDTO;
import gov.saanjh.user.service.SignUpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static gov.saanjh.user.domain.UserConstants.CONFIRM;
import static gov.saanjh.user.domain.UserConstants.SIGN_UP;

@RestController
@RequestMapping(SIGN_UP)
@CrossOrigin
@Slf4j
public class SignUpController {

    @Autowired
    SignUpService signUpService;

    @PostMapping
    public ResponseEntity<String> signUp(@RequestBody SignUpInitRequestDTO signUpInitRequestDTO, Model model){
        log.info("user-mang::SignUpController::sendMail::Initiating signup for user: {}", signUpInitRequestDTO.getEmail());
        return ResponseEntity.ok().body(signUpService.signUp(signUpInitRequestDTO,model));
    }


    @PostMapping(CONFIRM)
    public ResponseEntity<String> confirmSignUp(@RequestBody SignUpConfirmRequestDTO signUpConfirmRequestDTO) {
        log.info("user-mang::SignUpController::confirmSignUp::Confirming signup for user: {}", signUpConfirmRequestDTO.getEmail());
        return ResponseEntity.ok().body(signUpService.confirmSignUp(signUpConfirmRequestDTO));
    }


}