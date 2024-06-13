package com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.application.internal.commandservices;

import com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.domain.model.aggregates.Categorie;
import com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.domain.model.commands.CreateCategorieCommand;
import com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.domain.services.CategorieCommandService;
import com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.infrastructure.persistence.jpa.repositories.CategorieRepository;
import com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.infrastructure.persistence.jpa.repositories.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategorieCommandServiceImpl implements CategorieCommandService {

    private final CategorieRepository categorieRepository;
    private final GroupRepository groupRepository;

    public CategorieCommandServiceImpl(CategorieRepository categorieRepository, GroupRepository groupRepository) {
        this.categorieRepository = categorieRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    public Optional<Categorie> handle(CreateCategorieCommand command) {
        if (categorieRepository.existsByNameAndGroupId(command.name(), command.groupId())) {
            throw new RuntimeException("Categorie with name and groupId already exists");
        }
        if (!groupRepository.existsById(command.groupId())) {
            throw new RuntimeException("Group with id does not exist");
        }
        var categorie = new Categorie(command);
        return Optional.of(categorieRepository.save(categorie));
    }
}
