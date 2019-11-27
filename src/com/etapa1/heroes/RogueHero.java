package com.etapa1.heroes;

import com.etapa1.common.Constants;
import com.etapa1.main.GameInput;
import com.etapa1.visitors.AbilityVisitor;
import com.etapa1.visitors.BackStabVisitor;
import com.etapa1.visitors.ParalysisVisitor;

public class RogueHero extends Hero {

    public int backStabDmg = 200;
    public int paralysisDmg = 40;
    public int criticalHits = 0;

    public int getBackStabDmg() {
        return backStabDmg;
    }

    public int getParalysisDmg() {
        return paralysisDmg;
    }

    public RogueHero(int heroPosition) {
        super(heroPosition);
        this.heroHP = Constants.R_HP;
        this.maxLvlHp = heroHP;
        //System.out.println("I'M A F***ING ROGUE");
    }

    @Override
    public String toString() {
        if(this.heroHP > 0) {
            return "R " + heroLevel + " " + heroXP +
                    " " + heroHP +
                    " " + heroPosition / GameInput.getInstance().getUnit() +
                    " " + heroPosition % GameInput.getInstance().getUnit();
        }
        return "R dead";
    }

    @Override
    public void restoreHealth() {
        if (this.heroHP > 0) {
            this.heroHP = maxLvlHp + this.heroLevel * 40;
            maxLvlHp = heroHP;
        }
    }

    public float landAmp() {
        if(GameInput.getInstance().getGameMap().get(heroPosition).equals("W")) {
            return Constants.R_AMP;
        }
        return Constants.BASE_AMP;
    }

    @Override
    public void accept(AbilityVisitor abilityVisitor) {
        abilityVisitor.visit(this);
    }

    @Override
    public void attack(Hero heroPlayer) {
        //this.overtimeDmg(DoTRounds, DoTDmg);
//        if (this.heroHP <= 0) {
//            System.out.println("rogue mort in cada");
//            return;
//        }
        AbilityVisitor backStabVisitor = new BackStabVisitor(this);
        AbilityVisitor paralysisVisitor = new ParalysisVisitor(this);
//        if (this.heroHP <= 0) {
//            System.out.println("rogue mort in cada");
//            return;
//        }
        heroPlayer.accept(backStabVisitor);
        heroPlayer.accept(paralysisVisitor);
//        if(heroPlayer.heroHP <= 0) {
//            this.XPCalculator(this, heroPlayer);
//            this.levelUp();
//        }
        this.criticalHits++;
    }

    @Override
    public void powerUp() {
        backStabDmg += 20;
        paralysisDmg += 10;
    }

}
