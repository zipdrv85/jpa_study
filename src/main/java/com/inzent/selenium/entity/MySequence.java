package com.inzent.selenium.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Table(name = "mysequence")
@Entity
@Getter
public class MySequence implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MySequence() { }
	
	@Id
	@Column(name = "sequenceName")
	private String sequenceName;
	private long nextVal;

	@Override
	public String toString() {
		return "MySequence [sequenceName=" + sequenceName + ", nextVal=" + nextVal + "]";
	}

}
