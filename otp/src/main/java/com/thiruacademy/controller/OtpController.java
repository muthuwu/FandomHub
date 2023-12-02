package com.thiruacademy.controller;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thiruacademy.config.TwilioConfig;
import com.thiruacademy.dto.OtpRequest;
import com.thiruacademy.dto.OtpResponseDto;
import com.thiruacademy.dto.OtpStatus;
import com.thiruacademy.dto.OtpValidationRequest;
import com.thiruacademy.service.SmsService;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/otp")
@Slf4j
public class OtpController {

	@Autowired
	private SmsService smsService;
	
	@Autowired
	private TwilioConfig twilioConfig;
    Map<String, String> otpMap = new HashMap<>();


	public OtpResponseDto sendSMS(OtpRequest otpRequest) {
		OtpResponseDto otpResponseDto = null;
		try {
			PhoneNumber to = new PhoneNumber(otpRequest.getPhoneNumber());//to
			PhoneNumber from = new PhoneNumber(twilioConfig.getPhoneNumber()); // from
			String otp = generateOTP();
			String otpMessage = "Dear Customer , Your OTP is  " + otp + " for sending sms through Spring boot application. Thank You.";
			System.out.println(otp);
			Message message = Message
			        .creator(to, from,
			                otpMessage)
			        .create();
			otpMap.put(otpRequest.getUsername(), otp);
			otpResponseDto = new OtpResponseDto(OtpStatus.DELIVERED, otpMessage, otp);
		} catch (Exception e) {
			e.printStackTrace();
			otpResponseDto = new OtpResponseDto(OtpStatus.FAILED, e.getMessage(), "");
		}
		return otpResponseDto;
	}
	
	private String generateOTP() {
		String otp = new DecimalFormat("000000")
                .format(new Random().nextInt(999999));
        return otp;
    }
	
	@GetMapping("/process")
	public String processSMS() {
		return "SMS sent";
	}

	@PostMapping("/send-otp")
	public String sendOtp(@RequestBody OtpRequest otpRequest) {
		System.out.println("inside sendOtp :: "+otpRequest.getUsername());
		PhoneNumber to = new PhoneNumber(otpRequest.getPhoneNumber());//to
		PhoneNumber from = new PhoneNumber(twilioConfig.getPhoneNumber()); // from
		String otp = generateOTP();
		String otpMessage = "Dear Customer , Your OTP is  " + otp + " for sending sms through Spring boot application. Thank You.";
		
		Message message = Message
		        .creator(to, from,
		                otpMessage)
		        .create();
		otpMap.put(otpRequest.getUsername(), otp);
		return otp;
	}
	@PostMapping("/validate-otp")
    public String validateOtp(@RequestBody OtpValidationRequest otpValidationRequest) {
		System.out.println("inside validateOtp :: "+otpValidationRequest.getUsername()+" "+otpValidationRequest.getOtpNumber());
		return smsService.validateOtp(otpValidationRequest);
    }
	
}
