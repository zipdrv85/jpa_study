package com.inzent.selenium.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.inzent.selenium.entity.Member;
import com.inzent.selenium.entity.Team;

@SpringBootTest
@Transactional
@Rollback(false)
@RunWith(SpringRunner.class)
public class EnvTest {

	@PersistenceContext
	EntityManager em;
	
	@Test
	public void testEntity() {
		
		Team teamA = new Team("testA");
		Team teamB = new Team("testB");
		em.persist(teamA);
		em.persist(teamB);
		
		Member member1 = new Member("member1", 10, teamA);
		Member member2 = new Member("member2", 10, teamA);
		Member member3 = new Member("member3", 10, teamB);
		Member member4 = new Member("member4", 10, teamB);
		
		em.persist(member1);
		em.persist(member2);
		em.persist(member3);
		em.persist(member4);
		
		em.flush();
		em.clear();
		
		List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
		
		members.forEach(e -> {
			System.out.println("e.toString " + e);
			System.out.println("e.getTeam " + e.getTeam());
		});
	}
	
}
