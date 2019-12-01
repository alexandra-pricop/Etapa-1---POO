package com.etapa1.visitors;

import com.etapa1.heroes.KnightHero;
import com.etapa1.heroes.PyromancerHero;
import com.etapa1.heroes.RogueHero;
import com.etapa1.heroes.WizardHero;

public interface AbilityVisitor {

    void visit(KnightHero knightHero);
    void visit(RogueHero rogueHero);
    void visit(WizardHero wizardHero);
    void visit(PyromancerHero pyromancerHero);

}
