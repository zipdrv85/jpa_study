package com.example.jpalive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpalive.domain.Member;

@Repository
public interface MemberRepositoryRefectoring extends JpaRepository<Member, Long>{
	
	public List<Member> findByName(String name);
}
