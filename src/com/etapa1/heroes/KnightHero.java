package com.etapa1.heroes;

import com.etapa1.common.Constants;
import com.etapa1.main.GameInput;
import com.etapa1.visitors.AbilityVisitor;
import com.etapa1.visitors.ExecuteVisitor;
import com.etapa1.visitors.SlamVisitor;

public class KnightHero extends Hero {

    public int executeDmg = Constants.BASE_EX;
    public int slamDmg = Constants.BASE_SLAM;
    public float enemyXPLimit = Constants.BASE_HP_LIM;

    public KnightHero(final int heroPosition) {
        super(heroPosition);
        this.heroHP = Constants.K_HP;
        this.maxLvlHp = heroHP;
    }

    @Override
    /**
     * @return
     */
    public String toString() {
        if (this.heroHP > 0) {
            return "K " + heroLevel + " " + heroXP
                    + " " + heroHP
                    + " " + heroPosition / GameInput.getInstance().getUnit()
                    + " " + heroPosition % GameInput.getInstance().getUnit();
        }
        return "K dead";
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
        AbilityVisitor executeVisitor = new ExecuteVisitor(this);
        AbilityVisitor slamVisitor = new SlamVisitor(this);
        heroPlayer.accept(executeVisitor);
        heroPlayer.accept(slamVisitor);
    }

    @Override
    /**
     * @return
     */
    protected void powerUp() {
        executeDmg += Constants.EX_PU;
        slamDmg += Constants.SLAM_PU;
        if (enemyXPLimit + Constants.HP_LIM_PU <=  Constants.HP_LIM) {
            enemyXPLimit += Constants.HP_LIM_PU;
        }
    }

    @Override
    /**
     * @return
     */
    protected void restoreHealth() {
        if (this.heroHP > 0) {
            this.heroHP = maxLvlHp + this.heroLevel * Constants.K_HP_MUL;
            maxLvlHp = heroHP;
        }
    }

    @Override
    /**
     * @return
     */
    public float landAmp() {
        if (GameInput.getInstance().getGameMap().get(heroPosition).equals("L")) {
            return Constants.K_AMP;
        }
        return Constants.BASE_AMP;
    }
}
