package com.magic.handler;

public class NoDoctorForYourSymptomException extends RuntimeException {
	public NoDoctorForYourSymptomException(String msg){
		super(msg);
	}

}
