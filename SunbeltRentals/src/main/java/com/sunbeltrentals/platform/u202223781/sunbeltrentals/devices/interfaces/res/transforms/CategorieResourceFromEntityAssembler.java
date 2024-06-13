package com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.interfaces.res.transforms;

import com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.domain.model.aggregates.Categorie;
import com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.interfaces.res.resources.CategorieResource;

public class CategorieResourceFromEntityAssembler {

        public static CategorieResource fromEntity(Categorie entity) {
            return new CategorieResource(
                    entity.getId(),
                    entity.getName(),
                    entity.getGroupId(),
                    entity.getDescription(),
                    entity.getReferenceImageUrl()
            );
        }
}
