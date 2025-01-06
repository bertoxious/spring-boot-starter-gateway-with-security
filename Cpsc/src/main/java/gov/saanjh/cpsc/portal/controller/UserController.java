package gov.saanjh.cpsc.portal.controller;

import gov.saanjh.cpsc.portal.domain.User;
import gov.saanjh.cpsc.portal.dto.LoginResponse;
import gov.saanjh.cpsc.portal.services.JwtService;
import gov.saanjh.cpsc.portal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
//@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping({"","/"})
    public ResponseEntity<?> getByUserId(@RequestParam String userId){
        Optional<User> users = userService.getByUserId(userId);
        if(users.isPresent()) {
            return ResponseEntity.ok(users);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("This user id is not present");
    }

    @GetMapping("/users")
    public List<User> getCharacterVerifications(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return userService.getUsersWithPagination(page, size);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getCountOfUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getCountOfUsers());
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody Map<String, String> request) {
        String userId = request.get("userId");
        String password = request.get("password");

        User user = userService.createUser(userId, password);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<LoginResponse> authenticateAndGetToken(@RequestBody Map<String, String> request) {
        String userId = request.get("userId");
        String password = request.get("password");
        Optional<User> dbUser = userService.getByUserId(userId);
        if (dbUser.isPresent() && dbUser.get().getStatus().equalsIgnoreCase(password)){
            return ResponseEntity.ok().body(LoginResponse.builder().token(jwtService.generateToken(userId)).build());
        } else {
            throw new NullPointerException("Invalid user request!");
        }
    }
    @PostMapping("/internal/{userId}")
    public Optional<User> getUser(@PathVariable String userId){
        return userService.getByUserId(userId);
    }

}
