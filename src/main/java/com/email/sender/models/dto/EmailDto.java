package com.email.sender.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto {

    private String to;
    private String subject;
    private String cc;
    private String cco;
    private String body;
}
