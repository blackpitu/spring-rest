package com.pitu.spring_rest.controller.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(reason="bad name", value=HttpStatus.BAD_REQUEST)
public class BadNameException extends Exception {
	private static final long serialVersionUID = -458661063107038518L;
}
