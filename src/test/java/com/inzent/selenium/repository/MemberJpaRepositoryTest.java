package com.inzent.selenium.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import com.inzent.selenium.entity.Member;

@SpringBootTest
@Transactional
@Rollback(false)
@RunWith(SpringRunner.class)
public class MemberJpaRepositoryTest {

	@Autowired MemberJpaRepository memberJpaRepository;
	
	@Test
	public void testMember() {
		/*
		Member member = new Member("memberA");
		Member savedMember = memberJpaRepository.save(member);
		
		Member findMember = memberJpaRepository.find(saveMember);
		
		assertThat(findMember.getId()).*/
	}
	
	@Test
	public void basicCRUD() {
		Member member1 = new Member("Member1");
		Member member2 = new Member("Member2");
		
		memberJpaRepository.save(member1);
		memberJpaRepository.save(member2);
		
		//단건조회검증
		Member findMember1 = memberJpaRepository.findById(member1.getId()).get();
		Member findMember2 = memberJpaRepository.findById(member2.getId()).get();
		
		assertThat(findMember1, is(member1));
		assertThat(findMember2, is(member2));

		//리스트 검증
		List<Member> all = memberJpaRepository.findAll();
		assertThat(all.size(), is(equalTo(2)));
		
		//카운트 검증
		Long cnt = memberJpaRepository.count();
		assertThat(cnt, is(equalTo(Long.parseLong("2"))));
		
		memberJpaRepository.delete(member1);
		memberJpaRepository.delete(member2);
		
		Long deleteCount = memberJpaRepository.count();
		assertThat(deleteCount, is(equalTo(Long.parseLong("0"))));

		//assertThat(findMember1).isEqualsTo(member1);
		//assertThat(findMember2).isEqualsTo(member2);
	}
	
}
