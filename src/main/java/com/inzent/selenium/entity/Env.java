package com.inzent.selenium.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.inzent.selenium.entity.ids.EnvIds;

@Data
@Cacheable
@Table(name = "env")
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"envid", "version", "enabled", "isadmin", "url",  "targetUrl", "id", "password", "description"})
public class Env {
	
	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator = "MEMBER_SEQ_GENERATOR")
    @TableGenerator(
            name="MEMBER_SEQ_GENERATOR",
            table="MY_SEQUENCE", //시퀀스 생성용 테이블 이름
            pkColumnName="SEQUENCE_NAME", //MY_SEQUENCE 테이블에 생성할 필드이름(시퀀스네임)
            pkColumnValue="SEQUENCE_ENV", //SEQ_NAME이라고 지은 칼럼명에 들어가는 값.(키로 사용할 값)
            allocationSize=50
    )
	private Long envid;
	
	//@Id
	@Column(name = "version", nullable = false, updatable = false)
	private String version;

	@Column(name = "enabled", nullable = false)
	private boolean enabled;

	@Column(name = "isadmin", nullable = false)
	private boolean isadmin;

	private String url;
	private String targetUrl;
	private String id;
	private String password;
	private String description;

	@OneToMany(mappedBy = "env")
	@JsonManagedReference
	List<EnvAttr> envAttr = new ArrayList<EnvAttr>();
}
