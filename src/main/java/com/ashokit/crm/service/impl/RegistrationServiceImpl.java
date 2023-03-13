package com.ashokit.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.crm.dao.IRegisterDAO;
import com.ashokit.crm.models.CustomerBean;
import com.ashokit.crm.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	IRegisterDAO dao;

	@Override
	public boolean doRegistration(CustomerBean customerBean) {
		return dao.saveCustomer(customerBean);
	}

}
