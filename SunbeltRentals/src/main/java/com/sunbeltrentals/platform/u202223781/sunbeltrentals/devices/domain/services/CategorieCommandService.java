package com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.domain.services;

import com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.domain.model.aggregates.Categorie;
import com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.domain.model.commands.CreateCategorieCommand;

import java.util.Optional;

public interface CategorieCommandService {

    Optional<Categorie> handle(CreateCategorieCommand command);
}
