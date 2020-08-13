package com.example.jpalive.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.jpalive.domain.variable.Address;
import com.example.jpalive.domain.variable.DeliveryStatus;

import lombok.Getter;

@Getter
@Entity
@Table(name = "delivery")
public class Delivery {

	@Id @GeneratedValue
	@Column(name = "delivery_id")
	private Long id;
	
	@OneToOne(mappedBy = "delivery")
	private Order order;
	
	@Embedded
	private Address address;
	
	@Enumerated(EnumType.STRING)
	private DeliveryStatus status;

	public void setOrder(Order order) {
		this.order = order;
	}
	
}
