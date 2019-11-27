package com.etapa1.heroes;

import com.etapa1.common.Constants;
import com.etapa1.main.GameInput;
import com.etapa1.visitors.AbilityVisitor;
import com.etapa1.visitors.BackStabVisitor;
import com.etapa1.visitors.DeflectVisitor;
import com.etapa1.visitors.DrainVisitor;

public class WizardHero extends Hero {

    public float drainDmg = 0.2f;
    public float deflectDmg = 0.35f;
    public int overtime = 0;
    public int DoT = 0;

    public WizardHero(int heroPosition) {
        super(heroPosition);
        this.heroHP = Constants.W_HP;
        this.maxLvlHp = heroHP;
        //System.out.println("I'M A F***ING WIZARD");
    }

    public float getDrainDmg() {
        return drainDmg;
    }

    public float getDeflectDmg() {
        return deflectDmg;
    }

    @Override
    public String toString() {
        if(this.heroHP > 0) {
            return "W " + heroLevel + " " + heroXP +
                    " " + heroHP +
                    " " + heroPosition / GameInput.getInstance().getUnit() +
                    " " + heroPosition % GameInput.getInstance().getUnit();
        }
        return "W dead";
    }

    @Override
    public void restoreHealth() {
        this.heroHP = maxLvlHp + 30;
        maxLvlHp = heroHP;
    }

    @Override
    public float landAmp() {
        if(GameInput.getInstance().getGameMap().get(heroPosition).equals("D")) {
            return Constants.W_AMP;
        }
        return Constants.BASE_AMP;
    }

    @Override
    public void accept(AbilityVisitor abilityVisitor) {
        abilityVisitor.visit(this);
    }

    @Override
    public void attack(Hero heroPlayer) {
        AbilityVisitor deflectVisitor = new DeflectVisitor(this);
        AbilityVisitor drainVisitor = new DrainVisitor(this);
        //this.overtimeDmg(DoTRounds, DoTDmg);
        heroPlayer.accept(drainVisitor);
        heroPlayer.accept(deflectVisitor);
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
