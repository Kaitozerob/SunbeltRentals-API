package com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.infrastructure.persistence.jpa.repositories;

import com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.domain.model.aggregates.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long>{

    boolean existsByNameAndGroupId(String name, Long groupId);

}
