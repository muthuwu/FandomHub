package com.thiruacademy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OtpResponseDto {
	private OtpStatus status;
    private String message;
    private String ottp;
	public OtpResponseDto() {
		
		
	}
	
	public String getOttp() {
		return ottp;
	}

	public void setOttp(String ottp) {
		this.ottp = ottp;
	}

	public OtpResponseDto(OtpStatus delivered, String otpMessage, String otp) {
		status=delivered;
		message=otpMessage;
		ottp=otp;
	}
	
    
    
}
