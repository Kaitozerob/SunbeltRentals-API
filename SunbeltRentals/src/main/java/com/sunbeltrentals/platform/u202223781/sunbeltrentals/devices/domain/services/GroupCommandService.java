package com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.domain.services;

import com.sunbeltrentals.platform.u202223781.sunbeltrentals.devices.domain.model.commands.SeedGroupCommand;

public interface GroupCommandService {

        void handle(SeedGroupCommand command);
}
