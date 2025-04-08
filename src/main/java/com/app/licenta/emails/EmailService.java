package com.app.licenta.emails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import static com.app.licenta.commons.EmailNotificationMessages.*;

@Service
public class EmailService {


    @Autowired
    private JavaMailSender mailSender;

    @Async
    public void sendEmailForNewlyCreatedAd(String to, String trainerName) {
        sendEmail(to, NEW_AD_CREATED_TITLE, NEW_AD_CREATED_BODY.formatted(trainerName));
    }

    @Async
    public void sendEmailForNewlyCreatedGroup(String to, String groupName) {
        sendEmail(to, NEW_GROUP_CREATED_TITLE, NEW_GROUP_CREATED_BODY.formatted(groupName));
    }

    private void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("stanescu.ariana02@gmail.com");
        message.setSubject(subject);
        message.setText(body + "\n, supposed to be sent to: " + to);
        mailSender.send(message);
    }

}