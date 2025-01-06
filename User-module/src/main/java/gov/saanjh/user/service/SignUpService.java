package gov.saanjh.user.service;

import gov.saanjh.user.domain.*;
import gov.saanjh.user.exception.BadRequestException;
import gov.saanjh.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@Slf4j
public class SignUpService {

    @Autowired
    EmailService emailService;

    @Autowired
    RedisService redisService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public String signUp(SignUpInitRequestDTO signUpInitRequestDTO, Model model) {
        try {
            String otp = AuthService.generateOTP();
            emailService.sendEmail(EmailRequestDTO.builder()
                    .emailAddress(signUpInitRequestDTO.getEmail())
                    .emailType(EmailType.REGISTRATION)
                    .otp(otp)
                    .build(), model);

            User user = new User();
            user.setFirstName(signUpInitRequestDTO.getName());
            user.setPassword(passwordEncoder.encode(signUpInitRequestDTO.getPassword()));
            user.setEmail(signUpInitRequestDTO.getEmail());
            user.setType(signUpInitRequestDTO.getUserType().name());
            redisService.saveDataToRedis(signUpInitRequestDTO.getEmail(), otp);
            redisService.saveDataToRedis(signUpInitRequestDTO.getEmail() + "-" + otp, user);
            return "A registration code has been sent on the email";
        } catch (Exception e) {
            log.error("user-mang::SignUpController::sendMail::Error during signup for user: {}. Error: {}", signUpInitRequestDTO.getEmail(), e.getMessage());
            throw new BadRequestException(e.getMessage());
        }
    }

    public String confirmSignUp(SignUpConfirmRequestDTO signUpConfirmRequestDTO) {
        try {
            String redisOTP = (String) redisService.getDataFromRedis(signUpConfirmRequestDTO.getEmail());
            log.info("redisOTP :: {}", redisOTP);
            if (redisOTP.equals(signUpConfirmRequestDTO.getCode())) {
                User user = (User) redisService.getDataFromRedis(signUpConfirmRequestDTO.getEmail() + "-" + signUpConfirmRequestDTO.getCode());
                user.setEmailVerified(true);
                userRepository.save(user);
                return "User registered successfully !";
            }
            throw new BadRequestException("Invalid Confirmation Code");
        } catch (Exception e) {
            log.error("user-mang::SignUpController::confirmSignUp::Error confirming signup for user: {}. Error: {}", signUpConfirmRequestDTO.getEmail(), e.getMessage());
            throw new BadRequestException(e.getMessage());
        }
    }
}
