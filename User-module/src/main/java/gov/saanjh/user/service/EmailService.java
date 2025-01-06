package gov.saanjh.user.service;

import gov.saanjh.user.domain.EmailRequestDTO;
import gov.saanjh.user.domain.EmailType;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Date;

@Service
@Slf4j
public class EmailService {

    @Autowired
    JavaMailSender mailSender;

    @Value("${email.active}")
    private String activeEmail;

    @Autowired
    TemplateEngine templateEngine;


    public void sendEmail(EmailRequestDTO requestDTO, Model model) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        log.info("Sending email to the address: {} ",requestDTO.getEmailAddress());
        helper.setFrom(activeEmail);
        helper.setTo(requestDTO.getEmailAddress());
        helper.setText(getMailContent(requestDTO,model), true);
        mailSender.send(message);
    }

    String getMailContent(EmailRequestDTO emailRequestDTO, Model model) {
        Context context = new Context();
        model.addAttribute("otp",emailRequestDTO.getOtp());
        model.addAttribute("year",1900+new Date().getYear());
        if (emailRequestDTO.getEmailType().equals(EmailType.REGISTRATION)) {
            context.setVariables(model.asMap());
            return templateEngine.process("registration", context);
        }
        if (emailRequestDTO.getEmailType().equals(EmailType.FORGOT_PASSWORD)){
            context.setVariables(model.asMap());
            return templateEngine.process("forgot-password", context);
        }
        return null;
    }

}
