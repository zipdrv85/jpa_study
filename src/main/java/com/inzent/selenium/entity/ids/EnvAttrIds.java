package com.inzent.selenium.entity.ids;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class EnvAttrIds implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator = "MEMBER_SEQ_GENERATOR")
    @TableGenerator(
            name="MEMBER_SEQ_GENERATOR",
            table="MY_SEQUENCE", //시퀀스 생성용 테이블 이름
            pkColumnName="SEQUENCE_NAME", //MY_SEQUENCE 테이블에 생성할 필드이름(시퀀스네임)
            pkColumnValue="SEQUENCE_ENVATTR", //SEQ_NAME이라고 지은 칼럼명에 들어가는 값.(키로 사용할 값)
            allocationSize=50
    )
	@Column(name = "envattrid", nullable = false, updatable = false)
	private Long envid;

	@Id
	@Column(name = "attrName", nullable = false, updatable = false)
	private String attrName;	//속성명

	public EnvAttrIds(Long envid, String attrName) {
		super();
		this.envid = envid;
		this.attrName = attrName;
	}
}
