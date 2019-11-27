package com.etapa1.heroes;

import com.etapa1.common.Constants;
import com.etapa1.main.GameInput;
import com.etapa1.visitors.AbilityVisitor;
import com.etapa1.visitors.ExecuteVisitor;
import com.etapa1.visitors.SlamVisitor;

public class KnightHero extends Hero {

    public int executeDmg = 200;
    public int slamDmg = 100;
    public float enemyXPLimit = 0.2f;

    public KnightHero(int heroPosition) {
        super(heroPosition);
        this.heroHP = Constants.K_HP;
        this.maxLvlHp = heroHP;
        //System.out.println("I'M A F***ING KNIGHT");
    }

    @Override
    public String toString() {
        if(this.heroHP > 0) {
            return "K " + heroLevel + " " + heroXP +
                    " " + heroHP +
                    " " + heroPosition / GameInput.getInstance().getUnit() +
                    " " + heroPosition % GameInput.getInstance().getUnit();
        }
        return "K dead";
    }

    @Override
    public void accept(AbilityVisitor abilityVisitor) {
        abilityVisitor.visit(this);
    }


    @Override
    public void attack(Hero heroPlayer) {
        AbilityVisitor executeVisitor = new ExecuteVisitor(this);
        AbilityVisitor slamVisitor = new SlamVisitor(this);
        //this.overtimeDmg(DoTRounds, DoTDmg);
        heroPlayer.accept(executeVisitor);
        heroPlayer.accept(slamVisitor);
//        if(heroPlayer.heroHP <= 0) {
//            this.XPCalculator(this, heroPlayer);
//            this.levelUp();
//        }
    }

    @Override
    protected void powerUp() {
        executeDmg += 30;
        slamDmg += 40;
        if(enemyXPLimit + 0.01f <=  0.4f) {
            enemyXPLimit += 0.01f;
        }
    }

    @Override
    protected void restoreHealth() {
        if (this.heroHP > 0) {
            this.heroHP = maxLvlHp + this.heroLevel * 80;
            maxLvlHp = heroHP;
        }
    }

    @Override
    public float landAmp() {
        if(GameInput.getInstance().getGameMap().get(heroPosition).equals("L")) {
            return Constants.K_AMP;
        }
        return Constants.BASE_AMP;
    }
}
