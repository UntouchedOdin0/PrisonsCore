package me.untouchedodin0.prisoncore.commands.rank;

import me.untouchedodin0.prisoncore.PrisonCore;
import org.bukkit.entity.Player;
import redempt.redlib.commandmanager.CommandHook;

public class RankCommand {

    private final PrisonCore prisonCore;

    public RankCommand(PrisonCore prisonCore) {
        this.prisonCore = prisonCore;
    }

    @CommandHook("rankHook")
    public void mainHook(Player player) {
        player.sendMessage("Hi");
    }
}
