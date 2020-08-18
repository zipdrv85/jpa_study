package com.inzent.selenium.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;

@Cacheable
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "env")
@Entity
@Getter
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

	@OneToMany(mappedBy = "env", fetch = FetchType.EAGER)
	@JsonManagedReference
	List<EnvAttr> envAttr;

}
