package com.inzent.selenium.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NonNull;

@Table(name = "envattr")
@Entity
@Getter
public class EnvAttr implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EnvAttr() { }

	@NonNull
	@Id
	@Column(name = "envid", nullable = false, updatable = false)
	private String envid;
	
	@NonNull
	@Id
	@Column(name = "ATTR_NAME", nullable = false, updatable = false)
	private String attrName;	//속성명

	private String attrValue;	//속성 이름
	
	private String description;	//속성 설명

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "envid", nullable = false)
	@JsonBackReference
	private Env env;

	//연관관계 메소드 (FK 보단 비즈니스 관점에서 위치한다)
	public void setEnv(Env env) {
		this.env = env;
		env.getEnvAttr().add(this);
	}

	@Override
	public String toString() {
		return "EnvAttr [envid=" + envid + ", attrName=" + attrName
				+ ", attrValue=" + attrValue + ", description=" + description
				+ ", env=" + env + "]";
	}
}
