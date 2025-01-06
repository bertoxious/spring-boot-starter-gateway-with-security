package gov.saanjh.cpsc.portal.services;

import gov.saanjh.cpsc.portal.domain.User;
import gov.saanjh.cpsc.portal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService{

    @Autowired
    UserRepository userRepository;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> userDetail = userRepository.findByUserId(username); // Assuming 'email' is used as username
//
//        // Converting UserInfo to UserDetails
//        return userDetail.map(UserInfoDetails::new)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
//    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }

    public List<User> getUsersWithPagination(int page, int size) {
        int offset = page * size;
        return userRepository.findAllWithNativePagination(size, offset);
    }

    public Long getCountOfUsers() {
        return userRepository.findAll().stream().count();
    }

    public User createUser(String userId, String password) {
        if (userRepository.findByUserId(userId).isPresent()) {
            throw new IllegalArgumentException("Username already exists.");
        }
        validatePassword(userId, password);
        User user = new User();
        user.setUserId(userId);
        user.setStatus(password);
        user.setRole("4");
        user.setEnterDate(LocalDateTime.now());
        user.setPasswordChangeDate(OffsetDateTime.now());
        return userRepository.save(user);
    }

    private void validatePassword(String userId, String password) {
        if (password.length() < 8 || password.length() > 20) {
            throw new IllegalArgumentException("Password must be between 8 and 20 characters.");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new IllegalArgumentException("Password must contain at least one uppercase letter.");
        }
        if (!password.matches(".*[a-z].*")) {
            throw new IllegalArgumentException("Password must contain at least one lowercase letter.");
        }
        if (!password.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Password must contain at least one digit.");
        }
        if (!password.matches(".*[@#$%^&+=!].*")) {
            throw new IllegalArgumentException("Password must contain at least one special character.");
        }
        if (password.contains(" ")) {
            throw new IllegalArgumentException("Password must not contain spaces.");
        }
        if (password.contains(userId)) {
            throw new IllegalArgumentException("Password must not contain the username.");
        }
    }
}
