package com.kood.restful_web_services.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND)
public class UserNotFoundError extends RuntimeException {

	public UserNotFoundError(String msg) {
		super(msg);
	}

}
