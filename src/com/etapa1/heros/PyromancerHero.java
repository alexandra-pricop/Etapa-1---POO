package com.etapa1.heros;

import com.etapa1.common.Constants;

public class PyromancerHero extends Hero {

    public PyromancerHero(int heroPosition) {
        super(heroPosition);
        super.setHeroHP(Constants.P_HP);
        System.out.println("I'M A F***ING PYROMANCER");
    }


}
