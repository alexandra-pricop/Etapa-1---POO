package com.etapa1.heros;

import com.etapa1.common.Constants;

public class KnightHero extends Hero {

    public KnightHero(int heroPosition) {
        super(heroPosition);
        super.setHeroHP(Constants.K_HP);
        System.out.println("I'M A F***ING KNIGHT");
    }
}
