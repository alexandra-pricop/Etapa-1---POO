package com.etapa1.visitors;

import com.etapa1.heroes.KnightHero;
import com.etapa1.heroes.PyromancerHero;
import com.etapa1.heroes.RogueHero;
import com.etapa1.heroes.WizardHero;

public interface AbilityVisitor {

    public void visit(KnightHero knightHero);
    public void visit(RogueHero rogueHero);
    public void visit(WizardHero wizardHero);
    public void visit(PyromancerHero pyromancerHero);

}
