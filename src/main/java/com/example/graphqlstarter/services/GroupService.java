package com.example.graphqlstarter.services;

import java.util.List;

import com.example.graphqlstarter.models.Group;
import com.example.graphqlstarter.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("groupService")
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public Group getGroupById(Long id) {
        return groupRepository.getOne(id);
    }

    public List<Group> getAllGroup() {
        return groupRepository.findAll();
    }

    public Group saveGroup(Group group) {
        return groupRepository.save(group);
    }

    public Group updateGroup(Group group,Long id) {
        Group getUpdateGroup = groupRepository.findById(id).orElse(null);
        if(getUpdateGroup != null) {
            getUpdateGroup.setName(group.getName());
            getUpdateGroup.setDescription(group.getDescription());
        }
        final Group updatedGroup = groupRepository.save(getUpdateGroup);
        return updatedGroup;
    }

    public Boolean deleteGroup(Long id) {
        Group getDeleteGroup = groupRepository.findById(id).orElse(null);
        if(getDeleteGroup != null) {
            groupRepository.delete(getDeleteGroup);
            return true;
        }
        return false;
    }

}