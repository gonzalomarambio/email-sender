package com.email.sender.service;

import com.email.sender.models.dto.EmailDto;

public interface EmailService {

    void sendEmail(EmailDto emailDto);
}
