package com.inzent.selenium.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;

@Entity
@Getter
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "parent_id")  // <-- 여기!!
    private List<Child> children = new ArrayList<>();

    protected Parent() {}

    public Parent(String name) {
        this.name = name;
    }

    public Parent(String name, List<Child> children) {
        this.name = name;
        this.children.addAll(children);
    }
	
}
