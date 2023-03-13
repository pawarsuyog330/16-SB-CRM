package com.ashokit.crm.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ashokit.crm.dao.ILoginDAO;

@Repository
public class LoginDAOImpl implements ILoginDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public boolean loginCheck(String email, String password) {
		int count = jdbcTemplate.queryForObject("select  count(*) from  customer_tab where email=? and password=?", Integer.class, email, password);
		if(count==0) {
			return false;
		}
		else {
			return true;
		}
	}

}
