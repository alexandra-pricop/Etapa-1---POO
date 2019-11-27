package com.etapa1.heroes;

import com.etapa1.common.Constants;
import com.etapa1.main.GameInput;
import com.etapa1.visitors.AbilityVisitor;

import java.util.Objects;

public abstract class Hero {

    public int heroLevel;
    public int heroXP;
    public int heroHP;
    public int heroPosition;
    public int DoTRounds;
    public int DoTDmg;
    public int maxLvlHp;

    public void setHeroHP(int heroHP) {
        this.heroHP = heroHP;
    }

    public Hero(int heroPosition) {
        heroXP = 0;
        heroLevel = 0;
        heroPosition = heroPosition;
        DoTRounds = 0;
        DoTDmg = 0;
    }

    @Override
    public String toString() {
        return "heroLevel=" + heroLevel +
                ", heroXP=" + heroXP +
                ", heroHP=" + heroHP +
                ", heroPosition=" + heroPosition +
                '}';
    }

    public abstract void accept(AbilityVisitor abilityVisitor);

    public abstract void attack(Hero heroPlayer);

    public void XPCalculator(Hero winner, Hero loser) {
        winner.heroXP += Math.max(0, 200 - (winner.heroLevel - loser.heroLevel) * 40);
    }

    public void levelUp() {
        boolean flag = false;
        if (this.heroXP >= Constants.LEVEL_1_MIN) {
            this.heroLevel++;
            flag = true;
        }
        if (this.heroXP >= Constants.LEVEL_2_MIN) {
            this.heroLevel++;
            flag = true;
        }
        if (this.heroLevel >= Constants.LEVEL_3_MIN) {
            this.heroLevel++;
            flag = true;
        }
        if (this.heroLevel >= Constants.LEVEL_4_MIN) {
            this.heroLevel++;
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
        DoTRounds--;
    }

    public abstract float landAmp();
}
