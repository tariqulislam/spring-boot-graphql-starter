package com.example.graphqlstarter.services;

import com.example.graphqlstarter.models.Member;
import com.example.graphqlstarter.repositories.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("memberService")
public class MemberService {
   @Autowired
   private MemberRepository memberRepository;

   public Member findMemberByEmail(String email) {
       return memberRepository.findByEmail(email);
   }

   public List<Member> getAllMembers() {
       return memberRepository.findAll();
   }
}