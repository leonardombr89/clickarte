package com.clickarte.crm.services;

import org.springframework.stereotype.Service;
import com.clickarte.crm.repositories.GroupRepository;

@Service
public class GroupService {
    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }
}


