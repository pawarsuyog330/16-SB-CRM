package com.ashokit.crm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashokit.crm.models.CustomerBean;
import com.ashokit.crm.service.EmailService;
import com.ashokit.crm.service.RegistrationService;

@Controller
public class RegisterController {
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	RegistrationService service;
	
	@GetMapping("/index")
	public  String  getIndexPage() {
		return "index";
	}
	
	@GetMapping("/register")
	public  String  getRegisterPage(Model  model) {
		
		CustomerBean  customerBean = new CustomerBean();
		model.addAttribute("custBean", customerBean);
		return  "register";
	}
	
	@PostMapping("/save")
	public  String  registerCustomer(@Valid @ModelAttribute("custBean") CustomerBean customerBean, BindingResult result, Model  model) {
		
		if(result.hasErrors()) {
			return "register";
		}
		else {
			boolean  flag = service.doRegistration(customerBean);
			if(flag==false) {
				model.addAttribute("message", "A customer has already registered with given mail id, try with another");
				return "register";
			}
			else {
				String fullname=customerBean.getFirstName()+" "+customerBean.getLastName();
				
				emailService.sendEmailToCustomer(customerBean.getEmail(), fullname);
				
				return "registrationSuccess";
			}
		}
		
	}
	
	
}
