package com.etapa1.heroes;

import com.etapa1.common.Constants;
import com.etapa1.main.GameInput;
import com.etapa1.visitors.AbilityVisitor;
import com.etapa1.visitors.DeflectVisitor;
import com.etapa1.visitors.DrainVisitor;

public class WizardHero extends Hero {

    public float drainDmg = Constants.BASE_DR;
    public float deflectDmg = Constants.BASE_DEF;
    public int overtime = 0;
    public int DoT = 0;

    public WizardHero(final int heroPosition) {
        super(heroPosition);
        this.heroHP = Constants.W_HP;
        this.maxLvlHp = heroHP;
    }

    @Override
    /**
     * @return
     */
    public String toString() {
        if (this.heroHP > 0) {
            return "W " + heroLevel + " " + heroXP
                    + " " + heroHP
                    + " " + heroPosition / GameInput.getInstance().getUnit()
                    + " " + heroPosition % GameInput.getInstance().getUnit();
        }
        return "W dead";
    }

    @Override
    /**
     * @return
     */
    public void restoreHealth() {
        if (this.heroHP > 0) {
            this.heroHP = maxLvlHp + this.heroLevel * Constants.W_HP_MUL;
            maxLvlHp = heroHP;
        }
    }

    @Override
    /**
     * @return
     */
    public float landAmp() {
        if (GameInput.getInstance().getGameMap().get(heroPosition).equals("D")) {
            return Constants.W_AMP;
        }
        return Constants.BASE_AMP;
    }

    @Override
    /**
     * @return
     */
    public void accept(final AbilityVisitor abilityVisitor) {
        abilityVisitor.visit(this);
    }

    @Override
    /**
     * @return
     */
    public void attack(final Hero heroPlayer) {
        AbilityVisitor deflectVisitor = new DeflectVisitor(this);
        AbilityVisitor drainVisitor = new DrainVisitor(this);
        heroPlayer.accept(drainVisitor);
        heroPlayer.accept(deflectVisitor);
    }

    @Override
    /**
     * @return
     */
    public void powerUp() {
        drainDmg += Constants.DR_PU;
        if (deflectDmg <= Constants.DEF_MAX) {
            deflectDmg += Constants.DEF_PU;
        }
    }
}
