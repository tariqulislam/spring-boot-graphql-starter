package com.example.graphqlstarter.repositories;

import com.example.graphqlstarter.models.Member;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("memberRepository")
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);
    Page<Member> findMemberByGroupIdPage(Long id, Pageable pageable);
}