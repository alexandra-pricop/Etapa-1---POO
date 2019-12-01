package com.etapa1.heroes;

import com.etapa1.common.Constants;
import com.etapa1.main.GameInput;
import com.etapa1.visitors.AbilityVisitor;

import java.util.ArrayList;

public abstract class Hero {

    public int heroLevel;
    public int heroXP;
    public int heroHP;
    public int heroPosition;
    public int DoTRounds;
    public int DoTDmg;
    public int maxLvlHp;
    public int stunRounds;
    public ArrayList<String> heroMoves = new ArrayList<String>();

    /**
     * @param heroHP
     */
    public void setHeroHP(final int heroHP) {
        this.heroHP = heroHP;
    }

    public Hero(final int heroPosition) {
        heroXP = 0;
        heroLevel = 0;
        this.heroPosition = heroPosition;
        DoTRounds = 0;
        DoTDmg = 0;
        stunRounds = 0;
    }

    public abstract void accept(AbilityVisitor abilityVisitor);

    public abstract void attack(Hero heroPlayer);

    /**
     * @param winner
     * @param loser
     */
    public void XPCalculator(final Hero winner, final Hero loser) {
        winner.heroXP += Math.max(0, Constants.HP_MAX
                - (winner.heroLevel - loser.heroLevel) * Constants.HP_MUL);
    }

    /**
     * @return
     */
    public void levelUp() {
        boolean flag = false;
        if (this.heroXP >= Constants.LEVEL_1_MIN) {
            this.heroLevel = Constants.LVL_1;
            flag = true;
        }
        if (this.heroXP >= Constants.LEVEL_2_MIN) {
            this.heroLevel = Constants.LVL_2;
            flag = true;
        }
        if (this.heroXP >= Constants.LEVEL_3_MIN) {
            this.heroLevel = Constants.LVL_3;
            flag = true;
        }
        if (this.heroXP >= Constants.LEVEL_4_MIN) {
            this.heroLevel = Constants.LVL_4;
            flag = true;
        }
        if (flag) {
            this.restoreHealth();
            this.powerUp();
        }
    }

    protected abstract void powerUp();

    protected abstract void restoreHealth();

    public final void move(final String direction) {
        if (stunRounds > 0) {
            stunRounds--;
            return;
        }
        if (direction.equals("_")) {
            return;
        }
        if (direction.equals("L")) {
            heroPosition--;
            return;
        }
        if (direction.equals("R")) {
            heroPosition++;
            return;
        }
        if (direction.equals("U")) {
            heroPosition -= GameInput.getInstance().getUnit();
            return;
        }
        if (direction.equals("D")) {
            heroPosition += GameInput.getInstance().getUnit();
            return;
        }
    }

    /**
     * @param DoTRounds
     * @param DoTDmg
     */
    public void overtimeDmg(final int DoTRounds1, final int DoTDmg1) {
        if (DoTRounds1 == 0) {
            return;
        }
        this.heroHP -= DoTDmg1;
        this.DoTRounds--;
    }

    /**
        @return land amplifier
     */
    public abstract float landAmp();
}
