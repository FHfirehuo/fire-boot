package com.ciecc.fire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciecc.fire.data.jpa.PersonRepository;
import com.ciecc.fire.domain.Person;

//@Controller
@RestController
@RequestMapping("jpa")
public class JpaController {

	@Autowired
	PersonRepository personRepository;

	// 保存支持批量保存：
	// <S extends T> Iterable<S> save(Iterable<S> entities);

	// 删除
	/*
	 * void delete(ID id); void delete(T entity); void delete(Iterable<？ extends
	 * T> entities); void deleteAll();
	 */

	// url:https://127.0.0.1:8443/jpa/save?name=赵云&age=100&address=正定&email=
	@PostMapping("save")
	public Person save(String name, String address, Integer age, String eamil) {
		Person p = personRepository.save(new Person(name, age, address, eamil));

		return p;
	}

	// url:https://127.0.0.1:8443/jpa/a?name=王涛
	@GetMapping("a")
	public List<Person> a(String name) {
		List<Person> people = personRepository.findByName(name);

		return people;
	}

	// url:https://127.0.0.1:8443/jpa/a1?name=刘燚&address=北京
	@GetMapping("a1")
	public List<Person> a1(String name, String address) {

		List<Person> people = personRepository.findByNameAndAddress(name, address);
		return people;
	}

	// url:https://127.0.0.1:8443/jpa/a2?address=北京
	@GetMapping("a2")
	public List<Person> a2(String address) {
		List<Person> people = personRepository.findByAddress(address);

		return people;
	}

	// url:https://127.0.0.1:8443/jpa/a3?address=北京
	@GetMapping("a3")
	public List<Person> a3(String address) {
		List<Person> people = personRepository.findByAddress2(address);

		return people;
	}

	// url:https://127.0.0.1:8443/jpa/a4
	@PostMapping("a4")
	public int a4(String name) {
		Integer a = personRepository.setName(name);

		return a;
	}

	// url:https://127.0.0.1:8443/jpa/a5?email=511374191@qq.com
	@GetMapping("a5")
	public Person a5(String email) {
		Person p = personRepository.findByEmail(email);

		return p;
	}

	// url:https://127.0.0.1:8443/jpa/a6?city=北京
	@GetMapping("a6")
	public Page<Person> a6(String city) {
		Pageable pageable = new PageRequest(1, 10);
		Page<Person> people = personRepository.queryByAddress(city, pageable);

		return people;
	}
}
