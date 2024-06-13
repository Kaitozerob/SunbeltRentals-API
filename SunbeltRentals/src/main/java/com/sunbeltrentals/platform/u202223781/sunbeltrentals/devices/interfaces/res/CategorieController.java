package com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.interfaces.res;


import com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.domain.services.CategorieCommandService;
import com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.interfaces.res.resources.CategorieResource;
import com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.interfaces.res.resources.CreateCategorieResource;
import com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.interfaces.res.transforms.CategorieResourceFromEntityAssembler;
import com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.interfaces.res.transforms.CreateCategorieCommandFromResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;import java.awt.*;

@RestController
@RequestMapping(value = "/api/v1/categories", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Categorie", description = "Categorie Controller")
public class CategorieController {

        private final CategorieCommandService categorieCommandService;

        public CategorieController(CategorieCommandService categorieCommandService) {
            this.categorieCommandService = categorieCommandService;
        }

        @PostMapping
        public ResponseEntity<CategorieResource> createCategorie(@RequestBody CreateCategorieResource resource) {
            var createCategorieCommand = CreateCategorieCommandFromResource.fromResource(resource);
            var categorieEntity = categorieCommandService.handle(createCategorieCommand);
            if (categorieEntity.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            var categorieResource = CategorieResourceFromEntityAssembler.fromEntity(categorieEntity.get());
            return new ResponseEntity<>(categorieResource, HttpStatus.CREATED);
        }
}
