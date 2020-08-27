package com.inzent.selenium.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@Cacheable
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "env")
@Entity
@Getter
@Setter
/*@TableGenerator(
 name="ENV_SEQ_GENERATOR",
 table ="ENV",
 pkColumnValue = "ENVID", allocationSize = 50
)*/
public class Env implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Env() { }
	public Env(String envid) { 
		this.envid = envid;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "envid", nullable = false)
	private String envid;
	@Column(name = "version", nullable = false)
	private String version;
	@Column(name = "enabled", nullable = false)
	private boolean enabled;
	private String url;
	private String targetUrl;
	private String id;
	private String password;
	private String description;

	@Override
	public String toString() {
		return "Env [envid=" + envid + ", version=" + version + ", enabled="
				+ enabled + ", url=" + url + ", targetUrl=" + targetUrl
				+ ", id=" + id + ", password=" + password + ", description="
				+ description + "]";
	}
	
	//Cascadetype.ALL ->모두 적용
	//Cascadetype.PRESIST ->영속
	//Cascadetype.MERGE ->병합
	//Cascadetype.REMOVE ->삭제
	//Cascadetype.REFRESH ->REFRESH
	//Cascadetype.DETACH ->DETACH
	//@OneToMany(mappedBy = "env", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "envid")
	@JsonManagedReference
	List<EnvAttr> envAttr = new ArrayList<EnvAttr>();

	public void addEnvAttrs(String envid, List<EnvAttr> envAttrs) {
		this.envid = envid;
		envAttr.clear();
		envAttr.addAll(envAttrs);
	}
}
