package com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.interfaces.res.resources;

public record CreateCategorieResource(
        String name,
        Long groupId,
        String description,
        String referenceImageUrl
) {
}
