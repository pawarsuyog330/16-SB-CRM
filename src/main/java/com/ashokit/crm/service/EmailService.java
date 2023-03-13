package com.ashokit.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	@Autowired
	JavaMailSender  mailSender;
	
	public void sendEmailToCustomer(String mailId,String name) {
		System.out.println("**** entered: sendEmailToCustomer *****");
		
		SimpleMailMessage  mailMessage =new  SimpleMailMessage();
		
		mailMessage.setTo(mailId);
		mailMessage.setSubject("Mail from CRM application");
		mailMessage.setText("Dear "+name+" , \n Thanks for registering with application\n\n\n Regards\n Support Team");
		
		mailSender.send(mailMessage);
		System.out.println("**** exit: sendEmailToCustomer *****");
	}
}
