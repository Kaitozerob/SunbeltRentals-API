package com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.infrastructure.persistence.jpa.repositories;

import com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.domain.model.entities.Group;
import com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.domain.model.valueobjects.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

        boolean existsByName(Groups name);
}
