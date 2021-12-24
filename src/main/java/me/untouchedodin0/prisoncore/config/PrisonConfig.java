package me.untouchedodin0.prisoncore.config;

import lombok.Getter;
import redempt.redlib.config.annotations.ConfigMappable;
import redempt.redlib.configmanager.ConfigManager;

import java.util.List;

@Getter
@ConfigMappable
public class PrisonConfig {

    private List<String> bossbarMessages = ConfigManager.stringList();
}
