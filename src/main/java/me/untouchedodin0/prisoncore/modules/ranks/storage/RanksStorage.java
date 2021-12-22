package me.untouchedodin0.prisoncore.modules.ranks.storage;

import me.untouchedodin0.prisoncore.modules.ranks.Rank;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RanksStorage {

    private Map<UUID, Rank> playerRanks = new HashMap<>();

    public Map<UUID, Rank> getPlayerRanks() {
        return playerRanks;
    }
}
