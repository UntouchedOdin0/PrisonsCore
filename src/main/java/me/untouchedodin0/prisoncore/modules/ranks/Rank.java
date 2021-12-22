package me.untouchedodin0.prisoncore.modules.ranks;

import lombok.Getter;

@Getter
public class Rank {

    private final String name; // Name of rank
    private final double price; // Price of the rank
    private final int order; // Order in the rankup list.

    public Rank(String name, Double price, Integer order) {
        this.name = name;
        this.price = price;
        this.order = order;
    }
}
