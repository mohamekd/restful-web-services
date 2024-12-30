package com.kood.restful_web_services.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.kood.restful_web_services.entitys.UserBean;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public MappingJacksonValue filterBean() {
		UserBean user = new UserBean(1,"kood","123","gmail",26);
		MappingJacksonValue mapAllButNot = new MappingJacksonValue(user);
		SimpleBeanPropertyFilter propertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("name","email","age");
		FilterProvider filters = new SimpleFilterProvider().addFilter("userBeanFilter", propertyFilter);
		mapAllButNot.setFilters(filters);
		return mapAllButNot;
	}

	@GetMapping("/filtering-list")
	public List<UserBean> filterBeansList() {
		return Arrays.asList(new UserBean(1,"kood","123","gmail",25),
				new UserBean(2,"medo","456","yahooo",15));
	}
	
}
