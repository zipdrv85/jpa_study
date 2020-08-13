package com.example.jpalive.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpalive.domain.Member;
import com.example.jpalive.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	//create
	@Transactional
	public Long join(Member member) {
		checkDuplicated(member);
		memberRepository.save(member);
		return member.getId();
	}
	
	private void checkDuplicated(Member member) {
		List<Member> memberList = memberRepository.findByName(member.getName());
		if(!memberList.isEmpty())
			throw new IllegalStateException("Exception");
	}

	//read
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}
	
	public Member findOne(Long memberId) {
		return memberRepository.findOne(memberId);
	}
}
