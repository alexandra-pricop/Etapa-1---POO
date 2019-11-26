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

    }

    @Override
    public void visit(RogueHero rogueHero) {
        int baseHP = (int) Math.min(0.3f * Constants.R_HP, rogueHero.heroHP);
        float dmg = hero.drainDmg - 0.2f * hero.drainDmg;
        int rogueDmg = Math.round(dmg * baseHP);
        rogueHero.heroHP -= rogueDmg;
    }

    @Override
    public void visit(WizardHero wizardHero) {

    }

    @Override
    public void visit(PyromancerHero pyromancerHero) {

    }
}
