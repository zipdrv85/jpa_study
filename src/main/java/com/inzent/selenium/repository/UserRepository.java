package com.inzent.selenium.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inzent.selenium.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
