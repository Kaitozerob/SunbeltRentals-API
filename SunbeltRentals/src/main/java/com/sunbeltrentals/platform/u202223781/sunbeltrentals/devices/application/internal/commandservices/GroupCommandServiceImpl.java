package com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.application.internal.commandservices;

import com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.domain.model.commands.SeedGroupCommand;
import com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.domain.model.entities.Group;
import com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.domain.model.valueobjects.Groups;
import com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.domain.services.GroupCommandService;
import com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.infrastructure.persistence.jpa.repositories.GroupRepository;



import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class GroupCommandServiceImpl implements GroupCommandService{

    private final GroupRepository groupRepository;

    public GroupCommandServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public void handle(SeedGroupCommand command) {
        Arrays.stream(Groups.values()).forEach(name -> {
            if (!groupRepository.existsByName(name)) {
                groupRepository.save(new Group(name));
            }
        });
    }

}
