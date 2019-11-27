package com.etapa1.visitors;

import com.etapa1.common.Constants;
import com.etapa1.heroes.KnightHero;
import com.etapa1.heroes.PyromancerHero;
import com.etapa1.heroes.RogueHero;
import com.etapa1.heroes.WizardHero;

public class DrainVisitor implements AbilityVisitor {

    private final WizardHero hero;

    public DrainVisitor(WizardHero hero) {
        this.hero = hero;
    }

    @Override
    public void visit(KnightHero knightHero) {
        int baseHP = (int) Math.min(0.3f * knightHero.maxLvlHp, knightHero.heroHP);
        float dmg = 1.2f * hero.drainDmg * hero.landAmp();
        //int rogueDmg = Math.round(dmg * baseHP);
        knightHero.heroHP -= Math.round(dmg * baseHP);
    }

    @Override
    public void visit(RogueHero rogueHero) {
        int baseHP = (int) Math.min(0.3f * rogueHero.maxLvlHp, rogueHero.heroHP);
        float dmg = 0.8f * hero.drainDmg * hero.landAmp();
        //int rogueDmg = Math.round(dmg * baseHP);
        rogueHero.heroHP -= Math.round(dmg * baseHP);
    }

    @Override
    public void visit(WizardHero wizardHero) {
        int baseHP = (int) Math.min(0.3f * wizardHero.maxLvlHp, wizardHero.heroHP);
        float dmg = 1.05f * hero.drainDmg * hero.landAmp();
        //int rogueDmg = Math.round(dmg * baseHP);
        wizardHero.heroHP -= Math.round(dmg * baseHP);
    }

    @Override
    public void visit(PyromancerHero pyromancerHero) {
        int baseHP = (int) Math.min(0.3f * pyromancerHero.maxLvlHp, pyromancerHero.heroHP);
        float dmg = 0.9f * hero.drainDmg * hero.landAmp();
        //int rogueDmg = Math.round(dmg * baseHP);
        pyromancerHero.heroHP -= Math.round(dmg * baseHP);
    }
}
