package com.etapa1.visitors;

import com.etapa1.heroes.KnightHero;
import com.etapa1.heroes.PyromancerHero;
import com.etapa1.heroes.RogueHero;
import com.etapa1.heroes.WizardHero;

public class FireBlastVisitor implements AbilityVisitor {

    private final PyromancerHero hero;

    public FireBlastVisitor(PyromancerHero hero) {
        this.hero = hero;
    }

    @Override
    public void visit(KnightHero knightHero) {
        int amp = Math.round(hero.fireBlastDmg * hero.landAmp());
        knightHero.heroHP -= Math.round(amp * 1.2f);
    }

    @Override
    public void visit(RogueHero rogueHero) {
        int amp = Math.round(hero.fireBlastDmg * hero.landAmp());
        rogueHero.heroHP -= Math.round(amp * 0.8f);
    }

    @Override
    public void visit(WizardHero wizardHero) {

    }

    @Override
    public void visit(PyromancerHero pyromancerHero) {
        int amp = Math.round(hero.fireBlastDmg * hero.landAmp());
        pyromancerHero.heroHP -= Math.round(amp * 0.9f);
    }
}
