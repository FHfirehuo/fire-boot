package com.ciecc.fire.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.UniqueConstraint;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Person extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 4117389529426684605L;

	private String name;
	private int age;
	private String address;

	@Column(unique = true)
	private String email;

	protected Person() {
		super();
	}

	public Person(String name, int age, String address, String email) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
