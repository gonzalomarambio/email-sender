package com.email.sender.controller;

import com.email.sender.models.dto.EmailDto;
import com.email.sender.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class SendEmailController {

    private final EmailService emailService;

    @Autowired
    public SendEmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<?> sendSingleEmail(@RequestBody EmailDto emailDto){
        emailService.sendEmail(emailDto);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
