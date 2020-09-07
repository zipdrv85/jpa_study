package com.inzent.selenium.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name = "envattr")
@Entity
@Getter
@Setter
public class EnvAttr implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EnvAttr() { }
	
	@Id
	@Column(name = "envid", nullable = false, updatable = false)
	private String envid;

	@Id
	@Column(name = "ATTR_NAME", nullable = false, updatable = false)
	private String attrName;	//속성명

	private String attrValue;	//속성 이름

	private String uioption;	//ui에서 어떻게 보여줄지옵션

	private String description;	//속성 설명

	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "envid", nullable = false)
	//@JsonBackReference
	//private Env env;

	//연관관계 메소드 (FK 보단 비즈니스 관점에서 위치한다)
	/*
	public void setEnv(Env env) {
		this.env = env;
		env.getEnvAttr().add(this);
	}*/

	@Override
	public String toString() {
		return "EnvAttr [envid=" + envid + ", attrName=" + attrName
				+ ", attrValue=" + attrValue + ", uioption=" + uioption
				+ ", description=" + description + "]";
	}
}
