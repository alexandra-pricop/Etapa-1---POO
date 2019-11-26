package com.etapa1.heroes;

import com.etapa1.common.Constants;
import com.etapa1.visitors.AbilityVisitor;
import com.etapa1.visitors.FireBlastVisitor;
import com.etapa1.visitors.IgniteVisitor;

public class PyromancerHero extends Hero {

    public PyromancerHero(int heroPosition) {
        super(heroPosition);
        this.heroHP = Constants.P_HP;
        System.out.println("I'M A F***ING PYROMANCER");
    }

    @Override
    public String toString() {
        return "PyromancerHero{" +
                "heroLevel = " + heroLevel +
                ", heroXP = " + heroXP +
                ", heroHP = " + heroHP +
                ", heroPosition = " + heroPosition +
                '}' + "\n";
    }

    @Override
    protected void restoreHealth() {
        this.heroHP = Constants.P_HP;
    }

    @Override
    public void accept(AbilityVisitor abilityVisitor) {
        abilityVisitor.visit(this);
    }

    @Override
    public void attack(Hero heroPlayer) {
        AbilityVisitor fireBlastVisitor = new FireBlastVisitor(this);
        AbilityVisitor igniteVisitor = new IgniteVisitor(this);
        heroPlayer.accept(fireBlastVisitor);
        heroPlayer.accept(igniteVisitor);
    }

    @Override
    protected void powerUp() {

    }
}
