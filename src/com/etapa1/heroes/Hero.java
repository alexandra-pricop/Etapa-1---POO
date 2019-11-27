package com.etapa1.heroes;

import com.etapa1.common.Constants;
import com.etapa1.main.GameInput;
import com.etapa1.visitors.AbilityVisitor;

import java.util.ArrayList;
import java.util.Objects;

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

    public void setHeroHP(int heroHP) {
        this.heroHP = heroHP;
    }

    public Hero(int heroPosition) {
        heroXP = 0;
        heroLevel = 0;
        this.heroPosition = heroPosition;
        DoTRounds = 0;
        DoTDmg = 0;
        stunRounds = 0;
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

    public abstract void accept(AbilityVisitor abilityVisitor);

    public abstract void attack(Hero heroPlayer);

    public void XPCalculator(Hero winner, Hero loser) {
        winner.heroXP += Math.max(0, 200 - (winner.heroLevel - loser.heroLevel) * 40);
    }

    public void levelUp() {
        boolean flag = false;
        if (this.heroXP >= Constants.LEVEL_1_MIN) {
            this.heroLevel = 1;
            flag = true;
        }
        if (this.heroXP >= Constants.LEVEL_2_MIN) {
            this.heroLevel = 2;
            flag = true;
        }
        if (this.heroXP >= Constants.LEVEL_3_MIN) {
            this.heroLevel = 3;
            flag = true;
        }
        if (this.heroXP >= Constants.LEVEL_4_MIN) {
            this.heroLevel = 4;
            flag = true;
        }
        if(flag) {
            this.restoreHealth();
            this.powerUp();
        }
    }

    protected abstract void powerUp();

    protected abstract void restoreHealth();

    public void move(String direction) {
        if (stunRounds > 0) {
            stunRounds--;
            return;
        }
        if(direction.equals("_")) {
            return;
        }
        if(direction.equals("L")) {
            heroPosition--;
            return;
        }
        if(direction.equals("R")) {
            heroPosition++;
            return;
        }
        if(direction.equals("U")) {
            heroPosition -= GameInput.getInstance().getUnit();
            return;
        }
        if(direction.equals("D")) {
            heroPosition += GameInput.getInstance().getUnit();
            return;
        }
    }

    public void overtimeDmg(int DoTRounds, int DoTDmg){
        if (DoTRounds == 0) return;
        this.heroHP -= DoTDmg;
        this.DoTRounds--;
    }

    public abstract float landAmp();
}
