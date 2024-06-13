package com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.domain.model.commands;

import com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.domain.model.entities.Group;

public record CreateCategorieCommand(
        String name,
        Long groupId,
        String description,
        String referenceImageUrl
) {


    public CreateCategorieCommand {

        if (name == null || name.isBlank() || name.length() > 55) {
            throw new IllegalArgumentException("Categorie name is required and must be less than 55 characters");
        }
        if (groupId == null || groupId <= 0) {
            throw new IllegalArgumentException("Categorie type is required");
        }
        if (description == null || description.isBlank() || description.length() > 250) {
            throw new IllegalArgumentException("Description is required and must be less than 250 characters");
        }

        if (referenceImageUrl == null || referenceImageUrl.isBlank()) {
            throw new IllegalArgumentException("Reference Image Url is required");
        }

    }

}
