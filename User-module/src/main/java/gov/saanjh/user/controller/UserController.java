package gov.saanjh.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static gov.saanjh.user.domain.UserConstants.USER;

@RestController
@CrossOrigin
@RequestMapping(USER)
public class UserController {

    @GetMapping("/authorized")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok().body("Authorized Success!");
    }
}
