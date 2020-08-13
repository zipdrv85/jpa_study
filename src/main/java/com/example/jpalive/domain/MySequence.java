package com.example.jpalive.domain;

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
	@Column(name = "SEQUENCE_NAME")
	private String SEQUENCE_NAME;
	private long NEXT_VAL;

	@Override
	public String toString() {
		return "MySequence [SEQUENCE_NAME=" + SEQUENCE_NAME + ", NEXT_VAL=" + NEXT_VAL + "]";
	}

}
