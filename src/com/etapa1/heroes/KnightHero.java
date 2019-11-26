package com.etapa1.heroes;

import com.etapa1.common.Constants;
import com.etapa1.visitors.AbilityVisitor;
import com.etapa1.visitors.ExecuteVisitor;
import com.etapa1.visitors.SlamVisitor;

public class KnightHero extends Hero {

    public KnightHero(int heroPosition) {
        super(heroPosition);
        this.heroHP = Constants.K_HP;
        System.out.println("I'M A F***ING KNIGHT");
    }

    @Override
    public String toString() {
        return "KnightHero{" +
                "heroLevel = " + heroLevel +
                ", heroXP = " + heroXP +
                ", heroHP = " + heroHP +
                ", heroPosition = " + heroPosition +
                '}' + "\n";
    }

    @Override
    public void accept(AbilityVisitor abilityVisitor) {
        abilityVisitor.visit(this);
    }



    @Override
    public void attack(Hero heroPlayer) {
        AbilityVisitor executeVisitor = new ExecuteVisitor(this);
        AbilityVisitor slamVisitor = new SlamVisitor(this);
        heroPlayer.accept(executeVisitor);
        heroPlayer.accept(slamVisitor);
    }

    @Override
    protected void powerUp() {

    }

    @Override
    protected void restoreHealth() {
        this.heroHP = Constants.K_HP;
    }
}
