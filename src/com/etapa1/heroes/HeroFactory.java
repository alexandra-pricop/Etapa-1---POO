package com.etapa1.heroes;

public class HeroFactory {

//    private static HeroFactory instance = null;
//
//    public static HeroFactory getInstance() {
//        if(instance == null) {
//            instance = new HeroFactory();
//        }
//        return instance;
//    }

    private HeroFactory() {}

    public static Hero createHero(HeroTypes heroType, int heroPosition) {

        switch (heroType) {
            case K:
                return new KnightHero(heroPosition);
            case P:
                return new PyromancerHero(heroPosition);
            case W:
                return new WizardHero(heroPosition);
            case R:
                return new RogueHero(heroPosition);
        }

        return null;
    }
}
