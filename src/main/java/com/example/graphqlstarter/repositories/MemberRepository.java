package com.example.graphqlstarter.repositories;

import java.awt.print.Pageable;
import java.util.List;

import com.example.graphqlstarter.models.Member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("memberRepository")
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);
    List<Member> findAll(Pageable pageable);
}