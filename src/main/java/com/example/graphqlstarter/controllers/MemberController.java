package com.example.graphqlstarter.controllers;

import com.example.graphqlstarter.models.Member;
import com.example.graphqlstarter.services.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class MemberController {
  @Autowired
  private MemberService memberService;

  @GetMapping("/members")
  public List<Member> all() {
     return memberService.getAllMembers();
  }

  @PostMapping("/members")
  public ResponseEntity<Member> createMember (@Valid @RequestBody Member member) {
      return ResponseEntity.ok(memberService.saveMember(member));
  }

  @PutMapping("/members/{id}")
  public ResponseEntity<Member> updateMember(@Valid @RequestBody Member member,
    @PathVariable(value= "id") Long id) {
        return ResponseEntity.ok(memberService.updateMember(member, id));
    }

  @DeleteMapping("/members/{id}")
  public ResponseEntity<?> deleteMemeber(@PathVariable Long id) {
     return ResponseEntity.ok(memberService.deleteMember(id));
  }
}
