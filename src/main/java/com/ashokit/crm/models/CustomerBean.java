package com.ashokit.crm.models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.ashokit.crm.constraint.Phone;

import lombok.Data;

@Data
public class CustomerBean {
	@NotEmpty
	private  String  firstName;
	
	@NotEmpty
	private  String  lastName;
	
	@NotEmpty
	@Email
	private  String  email;
	
	@NotEmpty
	@Pattern(regexp="^[a-z][a-z0-9#@!]*")
	@Size(min=8, max=15)
	private  String  password;
	
	@Min(21)
	@Max(35)
	@NotNull
	private  Integer  age;
	
	@NotNull
	private  Gender  gender;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Past
	@DateTimeFormat(pattern="yyyy-MM-dd") //spring formatter
	private  Date  dateOfBirth;
	
	@NotNull
	@Phone  //user-defined constraint
	private  Long  contactNumber;
	
	@NotEmpty
	private  String  country;
	
	private  Map<String,String>  countries=new  HashMap<>();
	
	public CustomerBean() {
		countries.put("INDIA", "india");
		countries.put("AUSTRALIA", "australia");
		countries.put("USA", "usa");
		countries.put("NEWZELAND", "newzeland");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Map<String, String> getCountries() {
		return countries;
	}

	public void setCountries(Map<String, String> countries) {
		this.countries = countries;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

}
