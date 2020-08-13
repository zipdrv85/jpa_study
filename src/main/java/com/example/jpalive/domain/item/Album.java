package com.example.jpalive.domain.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("Album")
@Getter
@Setter
public class Album extends Item {
	
	private String artist;
	private String etc;
}
