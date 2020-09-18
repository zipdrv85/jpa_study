package com.inzent.selenium.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.junit.Test;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.inzent.selenium.entity.ids.EnvAttrIds;

@Table(name = "envattr")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Getter
@Setter
@IdClass(EnvAttrIds.class)
public class EnvAttr implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long envid;

	@Id
	private String attrName;	//속성명

	private String attrValue;	//속성 이름

	private String uioption;	//ui에서 어떻게 보여줄지옵션

	private String description;	//속성 설명

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "envid")
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
				+ ", attrValue=" + attrValue + ", uioption=" + uioption
				+ ", description=" + description + "]";
	}
}
