package com.etapa1.heroes;

import com.etapa1.common.Constants;
import com.etapa1.visitors.AbilityVisitor;
import com.etapa1.visitors.BackStabVisitor;
import com.etapa1.visitors.ParalysisVisitor;

public class RogueHero extends Hero {

    public int backStabDmg = 200;
    public int paralysisDmg = 40;

    public int getBackStabDmg() {
        return backStabDmg;
    }

    public int getParalysisDmg() {
        return paralysisDmg;
    }

    public RogueHero(int heroPosition) {
        super(heroPosition);
        this.heroHP = Constants.R_HP;
        System.out.println("I'M A F***ING ROGUE");
    }

    @Override
    public String toString() {
        return "RogueHero{" +
                "heroLevel = " + heroLevel +
                ", heroXP = " + heroXP +
                ", heroHP = " + heroHP +
                ", heroPosition = " + heroPosition +
                '}' + "\n";
    }

    @Override
    public void restoreHealth() {
        this.heroHP = Constants.R_HP;
    }

    @Override
    public void accept(AbilityVisitor abilityVisitor) {
        abilityVisitor.visit(this);
    }

    @Override
    public void attack(Hero heroPlayer) {
        AbilityVisitor backStabVisitor = new BackStabVisitor(this);
        AbilityVisitor paralysisVisitor = new ParalysisVisitor(this);
        heroPlayer.accept(backStabVisitor);
        heroPlayer.accept(paralysisVisitor);
        if(heroPlayer.heroHP <= 0) {
            this.XPCalculator(this, heroPlayer);
            this.levelUp();
        }
    }

    @Override
    public void powerUp() {
        backStabDmg += 20;
        paralysisDmg += 10;
    }

}
