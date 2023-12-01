package com.huutri.TwilioMessaggedemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendRequest {

    @JsonProperty("phoneNumber")
    private String phoneNumber; // destination

    @JsonProperty("message")
    private String message;

}
