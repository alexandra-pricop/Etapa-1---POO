package com.etapa1.heroes;

public final class HeroFactory {

    private HeroFactory() { }
    public static Hero createHero(final HeroTypes type, final int position) {
        switch (type) {
            case K:
                return new KnightHero(position);
            case P:
                return new PyromancerHero(position);
            case W:
                return new WizardHero(position);
            case R:
                return new RogueHero(position);
            default:
                break;
        }

        return null;
    }
}
