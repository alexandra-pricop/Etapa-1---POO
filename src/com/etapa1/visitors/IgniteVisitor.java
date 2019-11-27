package com.etapa1.visitors;

import com.etapa1.heroes.KnightHero;
import com.etapa1.heroes.PyromancerHero;
import com.etapa1.heroes.RogueHero;
import com.etapa1.heroes.WizardHero;

public class IgniteVisitor implements AbilityVisitor {

    private final PyromancerHero hero;

    public IgniteVisitor(PyromancerHero hero) {
        this.hero = hero;
    }

    @Override
    public void visit(KnightHero knightHero) {
        knightHero.DoTRounds = 2;
        knightHero.DoTDmg = Math.round(hero.igniteDoT * hero.landAmp() * 1.2f);
        int amp = Math.round(hero.igniteBaseDmg * hero.landAmp() * 1.2f);
        knightHero.heroHP -= amp;
    }

    @Override
    public void visit(RogueHero rogueHero) {
        rogueHero.DoTRounds = 2;
        rogueHero.DoTDmg = Math.round(hero.igniteDoT * hero.landAmp() * 0.8f);
        int amp = Math.round(hero.igniteBaseDmg * hero.landAmp() * 0.8f);
        rogueHero.heroHP -= amp;
    }

    @Override
    public void visit(WizardHero wizardHero) {

    }

    @Override
    public void visit(PyromancerHero pyromancerHero) {
        pyromancerHero.DoTRounds = 2;
        pyromancerHero.DoTDmg = Math.round(hero.igniteDoT * hero.landAmp() * 0.9f);
        int amp = Math.round(hero.igniteBaseDmg * hero.landAmp() * 0.9f);
        pyromancerHero.heroHP -= amp;
    }
}
