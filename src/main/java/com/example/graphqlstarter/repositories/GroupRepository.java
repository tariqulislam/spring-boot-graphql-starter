package com.example.graphqlstarter.repositories;

import com.example.graphqlstarter.models.Group;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}