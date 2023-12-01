package com.huutri.TwilioMessaggedemo.controller;

import com.huutri.TwilioMessaggedemo.dto.SendRequest;
import com.huutri.TwilioMessaggedemo.service.SendSMSServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/sms")
public class SendSMSController {
    private final SendSMSServiceImpl sendSMSService;

    @Autowired
    public SendSMSController(SendSMSServiceImpl sendSMSService) {
        this.sendSMSService = sendSMSService;
    }

    @PostMapping
    public void sendSms(@RequestBody SendRequest sendRequest) {
        try {
            sendSMSService.sendSms(sendRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
