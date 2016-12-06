package com.ciecc.fire.setting;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/***
 * 通过@ConfigurationProperties加载properties文件内的配置，通过prefix属性指定properties的配置前缀，
 * 通过locations指定properties文件的位置,例如:
 * 
 * @ConfigurationProperties(prefix = "author", locations =
 *                                 {"classpath:config/author.properties"})
 * 
 * @author fire
 *
 */
@Component
@ConfigurationProperties(prefix = "author")
public class AuthorSettings {

	private String name;
	private Long age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("-------------------:" + name);
		this.name = name;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		System.out.println("-------------------:" + age);
		this.age = age;
	}

}
