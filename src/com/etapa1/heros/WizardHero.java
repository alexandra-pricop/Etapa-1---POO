package com.etapa1.heros;

import com.etapa1.common.Constants;

public class WizardHero extends Hero {

    public WizardHero(int heroPosition) {
        super(heroPosition);
        super.setHeroHP(Constants.W_HP);
        System.out.println("I'M A F***ING WIZARD");
    }

}
