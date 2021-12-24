package me.untouchedodin0.prisoncore.config;

import lombok.Getter;
import me.untouchedodin0.prisoncore.PrisonCore;
import redempt.redlib.config.annotations.ConfigMappable;
import redempt.redlib.config.annotations.ConfigPostInit;

import java.util.ArrayList;
import java.util.List;

@Getter
@ConfigMappable
public class BossBarConfig {

    PrisonCore prisonCore;
    PrisonConfig prisonConfig;

    public static List<String> messages = new ArrayList<>();


    public BossBarConfig(PrisonCore prisonCore) {
        this.prisonCore = prisonCore;
        this.prisonConfig = PrisonCore.getPrisonConfig();
    }


    @ConfigPostInit
    public void postInit() {
        prisonCore.getLogger().info("Loaded " + messages.size() + " boss bar messages!");
    }

    public static List<String> getMessages() {
        return messages;
    }

    //    public int getMessagesCount() {
//        return messages.size();
//    }
}
