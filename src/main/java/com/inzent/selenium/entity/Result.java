package com.inzent.selenium.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.domain.Persistable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Getter
@Setter
@Entity
@Data
@Table(name = "result")
public class Result implements Persistable<UUID>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resultid", nullable = false, updatable = false)
	private String resultid;

	@Column(name = "executeMethod")
	private String executeMehtod;

	@Column(name = "executeTime")
	private String executeTime;

	@Column(name = "executeClass")
	private String executeClass;

	@Column(name = "imagePath")
	private String imagePath;
	
	@Column(name = "version")
	private String version;
	
	@Column(name = "className")
	private String className;
	
	@Column(name = "testNumber")
	private String testNumber;
	
	@Column(name = "testId")
	private String testId;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "resultid")
	@JsonManagedReference
	List<ResultAttr> resultAttr = new ArrayList<ResultAttr>();

	@Override
	public String toString() {
		return "Result [resultid=" + resultid + ", executeMehtod="
				+ executeMehtod + ", executeTime=" + executeTime
				+ ", executeClass=" + executeClass + ", imagePath=" + imagePath
				+ ", version=" + version + ", className=" + className
				+ ", testNumber=" + testNumber + ", testId=" + testId
				+ ", resultAttr=" + resultAttr + "]";
	}

	@Override
	public UUID getId() { return null; }

	@Override
	public boolean isNew() { return true; }
}