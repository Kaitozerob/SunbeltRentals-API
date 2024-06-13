package com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.domain.model.entities;


import com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.domain.model.valueobjects.Groups;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false, unique = true)
    private Groups name;

    public Group() {
    }

    public Group(Groups group) {
        this.name = group;
    }

    public static Group toGroupFromName(String name) {
        return new Group(Groups.valueOf(name));
    }
}
