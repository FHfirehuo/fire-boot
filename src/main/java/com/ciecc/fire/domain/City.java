package com.ciecc.fire.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class City implements Serializable {

	private static final long serialVersionUID = -9056381342506595664L;

	@Id
    @GeneratedValue ///(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String state;
    
    
    @Column(nullable = false)
    private String country;
    

    public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	//附加成员，通常包括@OneToMany映射
    protected City() {
    	//JPA规范要求的无参数构造函数
    	//这一个是受保护的，因为它不应该直接使用
    }

    public City(String name, String state) {
        this.name = name;
        this.state = state;
    }

    public String getName() {
        return this.name;
    }

    public String getState() {
        return this.state;
    }


}