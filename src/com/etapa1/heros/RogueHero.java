package com.etapa1.heros;

import com.etapa1.common.Constants;

public class RogueHero extends Hero {

    public RogueHero(int heroPosition) {
        super(heroPosition);
        super.setHeroHP(Constants.R_HP);
        System.out.println("I'M A F***ING ROGUE");
    }
}
