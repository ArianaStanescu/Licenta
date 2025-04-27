package com.app.licenta.emails;

import jakarta.mail.internet.MimeMessage;
import jakarta.mail.util.ByteArrayDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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

    @Async
    public void sendGroupCompletedDiplomaEmail(String to, String childName, String activityName, byte[] attachment) {
        sendEmailWithAttachment(to, GROUP_COMPLETED_DIPLOMA_TITLE.formatted(childName), GROUP_COMPLETED_DIPLOMA_BODY.formatted(childName, activityName), "diploma-participare.pdf", "application/pdf", attachment);
    }

    private void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("stanescu.ariana02@gmail.com");
        message.setSubject(subject);
        message.setText(body + "\n, supposed to be sent to: " + to);
        mailSender.send(message);
    }

    private void sendEmailWithAttachment(String to, String subject, String body, String filename, String type, byte[] attachment) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body);

            ByteArrayDataSource dataSource = new ByteArrayDataSource(attachment, type);
            helper.addAttachment(filename, dataSource);

            mailSender.send(message);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}