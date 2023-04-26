package com.magic.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
public class Patient {
	@Id
	@GeneratedValue(generator = "p_seq")
	@SequenceGenerator(name = "p_seq", initialValue = 201)
	private int pid;
	@NotNull(message = "Name is required")
	@Length(min = 3, message = "name should be at least 3 characters")
	private String name;
	@NotNull(message = "City is required")

	@Length(max = 20, message = "enter a small city")
	private String city;
	@NotNull(message = "email is required")
	@Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
	private String email;
	@NotNull(message = "phone number is required")
	@Length(min = 10, max = 10, message = "enter valid phone no")
	private String phone;
	private String symptom;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

}
