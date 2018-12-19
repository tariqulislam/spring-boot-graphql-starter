package com.example.graphqlstarter.services;

import com.example.graphqlstarter.models.Member;
import com.example.graphqlstarter.repositories.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberService {
   private MemberRepository memberRepository;

   @Autowired
   public MemberService(MemberRepository memberRepository) {
       this.memberRepository=  memberRepository;
   }

   public Member findMemberByEmail(String email) {
       return memberRepository.findByEmail(email);
   }
} 