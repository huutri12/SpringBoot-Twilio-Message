package com.huutri.TwilioMessaggedemo.controller;

import com.huutri.TwilioMessaggedemo.dto.SmsRequest;
import com.huutri.TwilioMessaggedemo.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/sms")
public class TwilioController {
    private final SmsService smsService;

    @Autowired
    public TwilioController(SmsService smsService) {
        this.smsService = smsService;
    }

    @PostMapping
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
        smsService.sendSms(smsRequest);
    }
}
