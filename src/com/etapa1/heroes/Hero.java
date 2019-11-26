package com.etapa1.heroes;

import com.etapa1.common.Constants;
import com.etapa1.visitors.AbilityVisitor;

import java.util.Objects;

public abstract class Hero {

    public int heroLevel;
    public int heroXP;
    public int heroHP;
    public int heroPosition;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Hero hero = (Hero) o;
        return heroLevel == hero.heroLevel &&
                heroXP == hero.heroXP &&
                heroHP == hero.heroHP &&
                heroPosition == hero.heroPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(heroLevel, heroXP, heroHP, heroPosition);
    }

    public void setHeroHP(int heroHP) {
        this.heroHP = heroHP;
    }

    public Hero(int heroPosition) {
        heroXP = 0;
        heroLevel = 0;
        this.heroPosition = heroPosition;
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
}
