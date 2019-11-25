package com.etapa1.heros;

public class Hero {

    private int heroLevel;
    private int heroXP;
    private int heroHP;
    private int heroPosition;

    public void setHeroHP(int heroHP) {
        this.heroHP = heroHP;
    }

    public Hero(int heroPosition) {
        heroXP = 0;
        heroLevel = 0;
        this.heroPosition = heroPosition;
    }
}
