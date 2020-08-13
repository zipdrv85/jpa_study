package com.inzent.selenium.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Table(name = "USERS")
@Entity
@Getter
public class User {
	
	private User() { }
	
	@Id
    @GeneratedValue
	private String ID;
	private String PASSWORD;
	private String NAME;
	private String AUTHORITY;
	private boolean ENABLED;
	
    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", PASSWORD='" + PASSWORD + '\'' +
                ", AUTHORITY='" + AUTHORITY + '\'' +
                ", ENABLED='" + ENABLED + '\'' +
                '}';
    }
}
