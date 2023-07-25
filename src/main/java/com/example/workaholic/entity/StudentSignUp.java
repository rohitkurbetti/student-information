package com.example.workaholic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_signup")
public class StudentSignUp {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private String password;

	@Column(name = "city")
	private String city;

	@Column(name = "email_phone")
	private String emailPhone;

	@Column(name = "mobile")
	private String mobile;

	public StudentSignUp() {
		
	}
	

	public StudentSignUp(String name, String password, String city, String emailPhone, String mobile) {
		super();
		this.name = name;
		this.password = password;
		this.city = city;
		this.emailPhone = emailPhone;
		this.mobile = mobile;
	}


	public StudentSignUp(long id, String name, String password, String city, String emailPhone, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.city = city;
		this.emailPhone = emailPhone;
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmailPhone() {
		return emailPhone;
	}

	public void setEmailPhone(String emailPhone) {
		this.emailPhone = emailPhone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	@Override
	public String toString() {
		return "StudentSignUp [id=" + id + ", name=" + name + ", password=" + password + ", city=" + city
				+ ", emailPhone=" + emailPhone + ", mobile=" + mobile + "]";
	}
	
	
	
}
