package com.etapa1.heroes;

import com.etapa1.common.Constants;
import com.etapa1.main.GameInput;
import com.etapa1.visitors.AbilityVisitor;
import com.etapa1.visitors.FireBlastVisitor;
import com.etapa1.visitors.IgniteVisitor;

public class PyromancerHero extends Hero {

    public int fireBlastDmg = 350;
    public int igniteBaseDmg = 150;
    public int igniteDoT = 50;

    public PyromancerHero(int heroPosition) {
        super(heroPosition);
        this.heroHP = Constants.P_HP;
        this.maxLvlHp = heroHP;
        //System.out.println("I'M A F***ING PYROMANCER");
    }

    @Override
    public String toString() {
        if(this.heroHP > 0) {
            return "P " + heroLevel + " " + heroXP +
                    " " + heroHP +
                    " " + heroPosition / GameInput.getInstance().getUnit() +
                    " " + heroPosition % GameInput.getInstance().getUnit();
        }
        return "P dead";
    }

    @Override
    protected void restoreHealth() {
        if (this.heroHP > 0) {
            this.heroHP = maxLvlHp + this.heroLevel * 50;
            maxLvlHp = heroHP;
        }
    }

    @Override
    public float landAmp() {
        if(GameInput.getInstance().getGameMap().get(heroPosition).equals("V")) {
            return Constants.P_AMP;
        }
        return Constants.BASE_AMP;
    }

    @Override
    public void accept(AbilityVisitor abilityVisitor) {
        abilityVisitor.visit(this);
    }

    @Override
    public void attack(Hero heroPlayer) {
//        if (this.heroHP <= 0) {
//            System.out.println("pyro mort in cada");
//            return;
//        }
        AbilityVisitor fireBlastVisitor = new FireBlastVisitor(this);
        AbilityVisitor igniteVisitor = new IgniteVisitor(this);
//        this.overtimeDmg(DoTRounds, DoTDmg);
//        if (this.heroHP <= 0) {
//            System.out.println("pyro mort in cada");
//            return;
//        }
        heroPlayer.accept(fireBlastVisitor);
        heroPlayer.accept(igniteVisitor);
//        if(heroPlayer.heroHP <= 0) {
//            this.XPCalculator(this, heroPlayer);
//            this.levelUp();
//        }
    }

    @Override
    protected void powerUp() {
        fireBlastDmg += 50;
        igniteBaseDmg += 20;
        igniteDoT += 30;
    }

}
