package com.etapa1.visitors;

import com.etapa1.heroes.KnightHero;
import com.etapa1.heroes.PyromancerHero;
import com.etapa1.heroes.RogueHero;
import com.etapa1.heroes.WizardHero;

public class SlamVisitor implements AbilityVisitor {

    private final KnightHero hero;

    public SlamVisitor(KnightHero hero) {
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