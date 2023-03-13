package com.ashokit.crm.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ashokit.crm.dao.IRegisterDAO;
import com.ashokit.crm.models.CustomerBean;

@Repository
public class RegisterDAOImpl implements IRegisterDAO {
	
	@Value("${customer.select}")
	private  String SELECT_QUERY;
	
	@Value("${customer.insert}")
	private String INSERT_QUERY;
	
	
	@Autowired
	JdbcTemplate  jdbcTemplate;

	@Override
	public boolean saveCustomer(CustomerBean customerBean) {
		int count=jdbcTemplate.queryForObject(SELECT_QUERY, Integer.class, customerBean.getEmail());
		if(count==1) {
			return false;
		}
		else {
			jdbcTemplate.update(INSERT_QUERY, customerBean.getEmail(),customerBean.getFirstName(),customerBean.getLastName(),customerBean.getPassword(),customerBean.getGender().toString(),customerBean.getAge(),customerBean.getContactNumber(),customerBean.getDateOfBirth(),customerBean.getCountry() );
			return true;
		}
	}

}
