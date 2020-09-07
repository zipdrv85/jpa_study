package com.inzent.selenium.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "resultAttr")
public class ResultAttr implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "resultid", nullable = false, updatable = false)
	private String resultid;
	
	@Id
	@Column(name = "attrName", nullable = false, updatable = false)
	private String attrName;	//속성명
	
	@Column(name = "attrValue")
	private String attrValue;
	
	@Column(name = "description")
	private String description;	//속성 설명

	@Override
	public String toString() {
		return "ResultAttr [resultid=" + resultid + ", attrName=" + attrName
				+ ", attrValue=" + attrValue + ", description=" + description
				+ "]";
	}
}
