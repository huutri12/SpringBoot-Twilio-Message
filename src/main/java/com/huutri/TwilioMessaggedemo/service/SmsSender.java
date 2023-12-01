package com.huutri.TwilioMessaggedemo.service;

import com.huutri.TwilioMessaggedemo.dto.SmsRequest;

import java.io.IOException;

public interface SmsSender {
    void sendSms(SmsRequest smsRequest) throws IOException;
}
