package me.untouchedodin0.prisoncore.commands.tokens;

import me.untouchedodin0.prisoncore.PrisonCore;
import org.bukkit.entity.Player;
import redempt.redlib.commandmanager.CommandHook;

public class TokensCommand {

    private final PrisonCore prisonCore;

    public TokensCommand(PrisonCore prisonCore) {
        this.prisonCore = prisonCore;
    }

    @CommandHook("tokens")
    public void tokens(Player player) {
        player.sendMessage("Tokens! " + prisonCore.getTokens());
    }
}
