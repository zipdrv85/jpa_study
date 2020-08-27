package com.inzent.selenium.service;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inzent.selenium.entity.Child;
import com.inzent.selenium.entity.Env;
import com.inzent.selenium.entity.EnvAttr;
import com.inzent.selenium.entity.Parent;
import com.inzent.selenium.repository.EnvRepository;
import com.inzent.selenium.repository.ParentRepository;

@Slf4j
@Service
public class ParentTestService {

    private ParentRepository parentRepository;

	public ParentTestService (ParentRepository parentRepository) {
		this.parentRepository = parentRepository;
	}
	
	@Transactional(readOnly = true)
	public void save() {		
        Parent parent1 = new Parent("parent 1");
        for (int i = 1 ; i <= 10 ; i++) {
            parent1.getChildren().add(
                    new Child("child " + i)
            );
        }

        Parent dbParent = this.parentRepository.saveAndFlush(parent1);

        System.out.println("*****************************");
        
        List<Child> children = dbParent.getChildren();
        children.removeIf(child -> 
                child.getId() == 1L || child.getId() == 2L);
        
	}
}

