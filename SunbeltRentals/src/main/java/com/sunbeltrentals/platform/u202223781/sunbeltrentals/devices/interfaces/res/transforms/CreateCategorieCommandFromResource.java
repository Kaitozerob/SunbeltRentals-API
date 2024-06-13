package com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.interfaces.res.transforms;

import com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.domain.model.commands.CreateCategorieCommand;
import com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.interfaces.res.resources.CreateCategorieResource;

public class CreateCategorieCommandFromResource {

    public static CreateCategorieCommand fromResource(CreateCategorieResource resource) {
        return new CreateCategorieCommand(
                resource.name(),
                resource.groupId(),
                resource.description(),
                resource.referenceImageUrl()
        );
    }
}