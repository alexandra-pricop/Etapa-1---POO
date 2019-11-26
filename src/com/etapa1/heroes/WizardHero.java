package com.etapa1.heroes;

import com.etapa1.common.Constants;
import com.etapa1.visitors.AbilityVisitor;
import com.etapa1.visitors.DeflectVisitor;
import com.etapa1.visitors.DrainVisitor;

public class WizardHero extends Hero {

    public float drainDmg = 0.2f;
    public float deflectDmg = 0.35f;
    public int overtime = 0;
    public WizardHero(int heroPosition) {
        super(heroPosition);
        this.heroHP = Constants.W_HP;
        System.out.println("I'M A F***ING WIZARD");
    }

    public float getDrainDmg() {
        return drainDmg;
    }

    public float getDeflectDmg() {
        return deflectDmg;
    }

    @Override
    public String toString() {
        return "WizardHero{" +
                "heroLevel = " + heroLevel +
                ", heroXP = " + heroXP +
                ", heroHP = " + heroHP +
                ", heroPosition = " + heroPosition +
                '}' + "\n";
    }

    @Override
    public void restoreHealth() {
        this.heroHP = Constants.W_HP;
    }

    @Override
    public void accept(AbilityVisitor abilityVisitor) {
        abilityVisitor.visit(this);
    }

    @Override
    public void attack(Hero heroPlayer) {
        AbilityVisitor deflectVisitor = new DeflectVisitor(this);
        AbilityVisitor drainVisitor = new DrainVisitor(this);
        heroPlayer.accept(deflectVisitor);
        heroPlayer.accept(drainVisitor);
        if(heroPlayer.heroHP <= 0) {
            this.XPCalculator(this, heroPlayer);
            heroPlayer.levelUp();
        }
    }

    @Override
    public void powerUp() {
        drainDmg += 0.05f;
        if (deflectDmg <= 0.68f) {
            deflectDmg += 0.2f;
        }
    }
}