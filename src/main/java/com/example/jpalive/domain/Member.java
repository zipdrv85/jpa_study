package com.example.jpalive.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.jpalive.domain.variable.Address;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "member")
public class Member {
	
	@Id @GeneratedValue
	@Column(name = "member_id")
	private Long id;
	
	private String name;
	
	@Embedded
	private Address address;
	
	@OneToMany(mappedBy = "member")
	List<Order> orders = new ArrayList<>();
	
}
