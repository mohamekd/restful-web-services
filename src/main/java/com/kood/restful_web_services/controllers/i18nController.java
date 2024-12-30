package com.kood.restful_web_services.controllers;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kood.restful_web_services.daos.UserDaoService;
import com.kood.restful_web_services.entitys.User;

import jakarta.validation.Valid;

//@RestController
public class i18nController {
	
	private MessageSource msgSource;
	
	public i18nController(MessageSource messageSource){
		this.msgSource=messageSource;
	}
	@GetMapping("/hello")
	public String helloInternationalize() {
		return msgSource.getMessage("good.morning.message",
				null,
				"Default Message",
				LocaleContextHolder.getLocale());
	}
}
