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
import com.kood.restful_web_services.entitys.FullName;
import com.kood.restful_web_services.entitys.PersonV1;
import com.kood.restful_web_services.entitys.PersonV2;
import com.kood.restful_web_services.entitys.User;

import jakarta.validation.Valid;

//@RestController
public class VersioningPersonController {
	//Versioning REST API - Options
	//URI
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new FullName("moha","koka"));
	}
	//Request Parameter
	@GetMapping(path = "/person", params = "version=1")
	public PersonV1 getFirstVersionOfPersonReqParam() {
		return new PersonV1("Moha Koka");
	}
	
	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 getSecondVersionOfPersonReqParam() {
		return new PersonV2(new FullName("Moha","Koka"));
	}
	//Headers
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 getFirstVersionOfPersonReqHeader() {
		return new PersonV1("Moha Koka");
	}
	
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 getSecondVersionOfPersonReqHeader() {
		return new PersonV2(new FullName("Moha","Koka"));
	}
	//Media Type 
	@GetMapping(path = "/person/accept", produces = "application/vnd.cpmpany.app-v1+json")
	public PersonV1 getFirstVersionOfPersonAcceptHeader() {
		return new PersonV1("Moha Koka");
	}
	
	@GetMapping(path = "/person/accept", produces = "application/vnd.cpmpany.app-v2+json")
	public PersonV2 getSecondVersionOfPersonAcceptHeader() {
		return new PersonV2(new FullName("Moha","Koka"));
	}
	
}
