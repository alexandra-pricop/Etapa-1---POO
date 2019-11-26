package com.etapa1.map;

import com.etapa1.heroes.Hero;

import java.util.ArrayList;

public class BattleGround {

    public BattleGround() {}

    public ArrayList<Hero> fighters = new ArrayList<Hero>();
    public void addFighters (Hero fighter) {
        fighters.add(fighter);
    }

    public void clearGround() {
        fighters.clear();
    }
}
