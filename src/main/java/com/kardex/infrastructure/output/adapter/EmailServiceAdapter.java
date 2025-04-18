package com.kardex.infrastructure.output.adapter;

import com.kardex.domain.exception.EmailSendingException;
import com.kardex.domain.spi.IEmailPersistencePort;
import com.kardex.infrastructure.util.ApiConstants;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@RequiredArgsConstructor
public class EmailServiceAdapter implements IEmailPersistencePort {
    private final JavaMailSender mailSender;

    @Override
    public void sendEmail(String to, String token){
        try{
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject("🔑 Restablece tu contraseña de forma segura");
            helper.setText(ApiConstants.EMAIL.CONTENT(token), true);
            mailSender.send(message);
        }catch (MessagingException e){
            throw new EmailSendingException();
        }
    }
}