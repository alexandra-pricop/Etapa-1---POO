package com.etapa1.visitors;

import com.etapa1.heros.KnightHero;
import com.etapa1.heros.PyromancerHero;
import com.etapa1.heros.RogueHero;
import com.etapa1.heros.WizardHero;

public interface HeroVisitor {

    public void visit(KnightHero knightHero);
    public void visit(RogueHero rogueHero);
    public void visit(WizardHero wizardHero);
    public void visit(PyromancerHero pyromancerHero);

}
