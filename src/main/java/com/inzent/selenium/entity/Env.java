package com.inzent.selenium.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import lombok.Getter;

@Table(name = "ENV")
@Entity
@Getter
@TableGenerator(
 name="ENV_SEQ_GENERATOR",
 table ="ENV",
 pkColumnValue = "ENVID", allocationSize = 50
)
public class Env implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Env() { }
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ENVID", nullable = false)
	private String ENVID;
	private String URL;
	private String ID;
	private String PASSWORD;
	private boolean ENABLED;
	private String DESCRIPTION;

	@Override
	public String toString() {
		return "Env [ENVID=" + ENVID + ", URL=" + URL + ", ID=" + ID + ", PASSWORD=" + PASSWORD + ", ENABLED=" + ENABLED
				+ ", DESCRIPTION=" + DESCRIPTION + "]";
	}
}
