package com.huutri.TwilioMessaggedemo.controller;

import com.huutri.TwilioMessaggedemo.dto.SmsRequest;
import com.huutri.TwilioMessaggedemo.service.SmsSenderImpl;
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
public class TwilioController {
    private final SmsSenderImpl smsSenderImpl;

    @Autowired
    public TwilioController(SmsSenderImpl smsSenderImpl) {
        this.smsSenderImpl = smsSenderImpl;
    }

    @PostMapping
    public void sendSms(@RequestBody SmsRequest smsRequest) {
        try {
            smsSenderImpl.sendSms(smsRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
