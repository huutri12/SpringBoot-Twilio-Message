package com.huutri.TwilioMessaggedemo.service;

import com.huutri.TwilioMessaggedemo.dto.SmsRequest;
public interface SmsSender {
    void sendSms(SmsRequest smsRequest);
}
