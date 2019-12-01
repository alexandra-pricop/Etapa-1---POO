package com.etapa1.heroes;

import com.etapa1.common.Constants;
import com.etapa1.main.GameInput;
import com.etapa1.visitors.AbilityVisitor;
import com.etapa1.visitors.FireBlastVisitor;
import com.etapa1.visitors.IgniteVisitor;

public class PyromancerHero extends Hero {

    public int fireBlastDmg = Constants.BASE_FB;
    public int igniteBaseDmg = Constants.BASE_IGN;
    public int igniteDoT = Constants.BASE_IGN_DOT;

    public PyromancerHero(final int heroPosition) {
        super(heroPosition);
        this.heroHP = Constants.P_HP;
        this.maxLvlHp = heroHP;
    }

    @Override
    /**
     * @return
     */
    public String toString() {
        if (this.heroHP > 0) {
            return "P " + heroLevel + " " + heroXP
                    + " " + heroHP
                    + " " + heroPosition / GameInput.getInstance().getUnit()
                    + " " + heroPosition % GameInput.getInstance().getUnit();
        }
        return "P dead";
    }

    @Override
    /**
     * @return
     */
    protected void restoreHealth() {
        if (this.heroHP > 0) {
            this.heroHP = maxLvlHp + this.heroLevel * Constants.P_HP_MUL;
            maxLvlHp = heroHP;
        }
    }

    @Override
    /**
     * @return
     */
    public float landAmp() {
        if (GameInput.getInstance().getGameMap().get(heroPosition).equals("V")) {
            return Constants.P_AMP;
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
        AbilityVisitor fireBlastVisitor = new FireBlastVisitor(this);
        AbilityVisitor igniteVisitor = new IgniteVisitor(this);
        heroPlayer.accept(fireBlastVisitor);
        heroPlayer.accept(igniteVisitor);
    }

    @Override
    /**
     * @return
     */
    protected void powerUp() {
        fireBlastDmg += Constants.FB_PU;
        igniteBaseDmg += Constants.IGN_PU;
        igniteDoT += Constants.IGN_DOT_PU;
    }

}
