package me.untouchedodin0.prisoncore.commands.rank;

import me.untouchedodin0.prisoncore.PrisonCore;
import org.bukkit.command.CommandSender;
import redempt.redlib.commandmanager.CommandHook;

public class RanksCommand {

    private final PrisonCore prisonCore;

    public RanksCommand(PrisonCore prisonCore) {
        this.prisonCore = prisonCore;
    }

    @CommandHook("ranks")
    public void someCommand(CommandSender sender) {
        sender.sendMessage("Hi");
        //Do stuff
    }
}
