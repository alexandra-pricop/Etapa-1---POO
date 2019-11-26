package com.etapa1.visitors;

import com.etapa1.heroes.KnightHero;
import com.etapa1.heroes.PyromancerHero;
import com.etapa1.heroes.RogueHero;
import com.etapa1.heroes.WizardHero;

public class ExecuteVisitor implements AbilityVisitor {

    private final KnightHero hero;

    public ExecuteVisitor(KnightHero hero) {
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

    }

    @Override
    public void visit(PyromancerHero pyromancerHero) {

    }
}
