package com.email.sender.service.impl;

import com.email.sender.models.dto.EmailDto;
import com.email.sender.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class);
    private final JavaMailSender emailSender;

    public EmailServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Async
    @Override
    public void sendEmail(@NonNull EmailDto emailDto) {
        try{
            LOGGER.info("Send email to: {}...", emailDto.getTo());
            MimeMessage mimeMessage = emailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(emailDto.getTo());
            mimeMessageHelper.setSubject(emailDto.getSubject());

            if(emailDto.getCc() != null){
                mimeMessageHelper.setCc(emailDto.getCc());
            }
            if(emailDto.getCco() != null){
                mimeMessageHelper.setBcc(emailDto.getCc());
            }
            mimeMessageHelper.setText(emailDto.getBody());

            emailSender.send(mimeMessage);
            LOGGER.info("Email to: {} sent...", emailDto.getTo());
        } catch (Exception e){
            LOGGER.error("[ERROR] send email to {}...", emailDto.getTo(), e);
        }
    }
}
