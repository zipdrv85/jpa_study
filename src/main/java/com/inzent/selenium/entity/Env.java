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

@Table(name = "env")
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
	@Column(name = "envid", nullable = false)
	private String envid;
	@Column(name = "version", nullable = false)
	private String version;
	@Column(name = "enabled", nullable = false)
	private boolean enabled;
	private String url;
	private String id;
	private String password;
	private String description;

	@Override
	public String toString() {
		return "Env [envid=" + envid + ", url=" + url + ", id=" + id + ", password=" + password + ", enabled=" + enabled
				+ ", description=" + description + "]";
	}
}
