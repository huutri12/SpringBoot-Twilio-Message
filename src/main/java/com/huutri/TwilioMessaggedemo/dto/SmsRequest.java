package com.huutri.TwilioMessaggedemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmsRequest {

    @JsonProperty("phoneNumber")
    @NotBlank
    private String phoneNumber; // destination

    @JsonProperty("message")
    @NotBlank
    private String message;

}
