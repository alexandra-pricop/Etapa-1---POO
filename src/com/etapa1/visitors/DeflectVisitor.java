package com.etapa1.visitors;

import com.etapa1.common.Constants;
import com.etapa1.heroes.KnightHero;
import com.etapa1.heroes.PyromancerHero;
import com.etapa1.heroes.RogueHero;
import com.etapa1.heroes.WizardHero;

public class DeflectVisitor implements AbilityVisitor {

    private final WizardHero hero;

    public DeflectVisitor(WizardHero hero) {
        this.hero = hero;
    }

    @Override
    public void visit(KnightHero knightHero) {
    }

    @Override
    public void visit(RogueHero rogueHero) {
        int bDmg = rogueHero.backStabDmg;
        int pDmg = rogueHero.paralysisDmg;
        float dmg = hero.deflectDmg + 0.2f * hero.deflectDmg;
        rogueHero.heroHP -= Math.round((bDmg + pDmg) * dmg);
    }

    @Override
    public void visit(WizardHero wizardHero) {
        System.out.println("wizard");
    }

    @Override
    public void visit(PyromancerHero pyromancerHero) {
        System.out.println("pyromancer");
    }
}
