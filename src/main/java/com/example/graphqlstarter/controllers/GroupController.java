package com.example.graphqlstarter.controllers;

import java.util.List;

import javax.validation.Valid;

import com.example.graphqlstarter.models.Group;
import com.example.graphqlstarter.services.GroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping("/groups")
    public List<Group> all() {
        return groupService.getAllGroup();
    }

    @GetMapping("/groups/{id}")
    public ResponseEntity<?> getGroupInfoById(
        @PathVariable(value= "id") Long id
    ) {
      return ResponseEntity.ok(groupService.getGroupById(id));
    }

    @PostMapping("/group")
    public ResponseEntity<?> saveGroup(@Valid @RequestBody Group group) {
        return ResponseEntity.ok(groupService.saveGroup(group));
    }

    @PutMapping("/group/{id}")
    public ResponseEntity<?> updateGroup(@Valid @RequestBody Group group, @PathVariable(value="id") Long id) {
        return ResponseEntity.ok(groupService.updateGroup(group, id));
    }

    public ResponseEntity<?> deleteGroup(@PathVariable Long id) {
        return ResponseEntity.ok(groupService.deleteGroup(id));
    }
}