package com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.domain.model.aggregates;

import com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.domain.model.commands.CreateCategorieCommand;
import com.sunbeltrentals.platform.u202223781.sunbeltrentals.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
@Entity
public class Categorie extends AuditableAbstractAggregateRoot<Categorie> {

    @Size(max = 55)
    @NotBlank
    @Column(length = 55, nullable = false)
    private String name;


    @NotBlank
    @Column(nullable = false)
    private Long groupId;

    @Size(max = 250)
    @NotBlank
    @Column(length = 250, nullable = false)
    private String description;

    @NotBlank
    @Column(nullable = false)
    private String referenceImageUrl;

    public Categorie() {
    }

    public Categorie(String name, Long groupId, String description, String referenceImageUrl) {
        this.name = name;
        this.groupId = groupId;
        this.description = description;
        this.referenceImageUrl = referenceImageUrl;
    }

    public Categorie(CreateCategorieCommand command) {
        this.name = command.name();
        this.groupId = command.groupId();
        this.description = command.description();
        this.referenceImageUrl = command.referenceImageUrl();
    }


}
