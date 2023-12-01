package com.huutri.TwilioMessaggedemo.service;

import com.huutri.TwilioMessaggedemo.dto.SendRequest;

import java.io.IOException;

public interface SendSMSService {
    void sendSms(SendRequest sendRequest) throws IOException;
}
