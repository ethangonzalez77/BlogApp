package com.codeup.blogapp.services;

import com.codeup.blogapp.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class EmailService {

    @Autowired
    public JavaMailSender emailSender;


    @Value("${spring.mail.from}")
    private String from;

    public void preparedAndSend (Post post, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(from);
        message.setSubject(from);
        message.setText(from);


        try {
            this.emailSender.send(message);
        }catch (MailException ex) {
            System.out.println(ex.getMessage());
        }



    }


}
