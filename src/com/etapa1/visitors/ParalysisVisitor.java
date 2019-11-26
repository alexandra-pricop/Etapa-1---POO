package com.etapa1.visitors;

import com.etapa1.heroes.KnightHero;
import com.etapa1.heroes.PyromancerHero;
import com.etapa1.heroes.RogueHero;
import com.etapa1.heroes.WizardHero;

public class ParalysisVisitor implements AbilityVisitor {

    private final RogueHero hero;

    public ParalysisVisitor(RogueHero hero) {
        this.hero = hero;
    }
    @Override
    public void visit(KnightHero knightHero) {

    }

    @Override
    public void visit(RogueHero rogueHero) {

    }

    @Override
    public void visit(WizardHero wizardHero) {
        wizardHero.heroHP -= Math.round(hero.paralysisDmg + 0.25f * hero.paralysisDmg);
    }

    @Override
    public void visit(PyromancerHero pyromancerHero) {

    }
}
