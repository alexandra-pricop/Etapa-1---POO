package com.etapa1.heroes;

import com.etapa1.common.Constants;
import com.etapa1.main.GameInput;
import com.etapa1.visitors.AbilityVisitor;
import com.etapa1.visitors.BackStabVisitor;
import com.etapa1.visitors.ParalysisVisitor;

public class RogueHero extends Hero {

    public int backStabDmg = Constants.BASE_BS;
    public int paralysisDmg = Constants.BASE_PAR;
    public int criticalHits = 0;

    public RogueHero(final int heroPosition) {
        super(heroPosition);
        this.heroHP = Constants.R_HP;
        this.maxLvlHp = heroHP;
    }

    @Override
    /**
     * @return
     */
    public String toString() {
        if (this.heroHP > 0) {
            return "R " + heroLevel + " " + heroXP
                    + " " + heroHP
                    + " " + heroPosition / GameInput.getInstance().getUnit()
                    + " " + heroPosition % GameInput.getInstance().getUnit();
        }
        return "R dead";
    }

    @Override
    /**
     * @return
     */
    public void restoreHealth() {
        if (this.heroHP > 0) {
            this.heroHP = maxLvlHp + this.heroLevel * Constants.R_HP_MUL;
            maxLvlHp = heroHP;
        }
    }

    @Override
    /**
     * @return
     */
    public float landAmp() {
        if (GameInput.getInstance().getGameMap().get(heroPosition).equals("W")) {
            return Constants.R_AMP;
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
        AbilityVisitor backStabVisitor = new BackStabVisitor(this);
        AbilityVisitor paralysisVisitor = new ParalysisVisitor(this);
        heroPlayer.accept(backStabVisitor);
        heroPlayer.accept(paralysisVisitor);
        this.criticalHits++;
    }

    @Override
    /**
     * @return
     */
    public void powerUp() {
        backStabDmg += Constants.BS_PU;
        paralysisDmg += Constants.PAR_PU;
    }

}
