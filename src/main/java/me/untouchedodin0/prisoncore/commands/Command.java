package me.untouchedodin0.prisoncore.commands;

import me.untouchedodin0.prisoncore.PrisonCore;
import org.bukkit.entity.Player;
import redempt.redlib.commandmanager.CommandHook;

public class Command {

    private final PrisonCore prisonCore;

    public Command(PrisonCore prisonCore) {
        this.prisonCore = prisonCore;
    }

    @CommandHook("rankHook")
    public void rankCommand(Player player) {
        player.sendMessage("Rank Command!");
    }

    @CommandHook("ranksHook")
    public void ranksCommand(Player player) {
        player.sendMessage("Ranks Command!");
    }

    @CommandHook("tokensHook")
    public void tokensCommand(Player player) {
        player.sendMessage("Tokens Command!");
    }
}
