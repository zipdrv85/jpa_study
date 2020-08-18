package com.inzent.selenium.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inzent.selenium.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
