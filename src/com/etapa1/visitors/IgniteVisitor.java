package com.etapa1.visitors;

import com.etapa1.common.Constants;
import com.etapa1.heroes.KnightHero;
import com.etapa1.heroes.PyromancerHero;
import com.etapa1.heroes.RogueHero;
import com.etapa1.heroes.WizardHero;

public final class IgniteVisitor implements AbilityVisitor {

    private final PyromancerHero hero;

    public IgniteVisitor(final PyromancerHero hero) {
        this.hero = hero;
    }

    @Override
    public void visit(final KnightHero knightHero) {
        knightHero.DoTRounds = 2;
        knightHero.DoTDmg = Math.round(hero.igniteDoT * hero.landAmp() * Constants.IGN_KNIGHT);
        int amp = Math.round(hero.igniteBaseDmg * hero.landAmp() * Constants.IGN_KNIGHT);
        knightHero.heroHP -= amp;
    }

    @Override
    public void visit(final RogueHero rogueHero) {
        rogueHero.DoTRounds = 2;
        rogueHero.DoTDmg = Math.round(hero.igniteDoT * hero.landAmp() * Constants.IGN_ROGUE);
        int amp = Math.round(hero.igniteBaseDmg * hero.landAmp() * Constants.IGN_ROGUE);
        rogueHero.heroHP -= amp;
    }

    @Override
    public void visit(final WizardHero wizardHero) {
        wizardHero.DoTRounds = 2;
        wizardHero.DoTDmg = Math.round(hero.igniteDoT * hero.landAmp() * Constants.IGN_WIZARD);
        int amp = Math.round(hero.igniteBaseDmg * hero.landAmp() * Constants.IGN_WIZARD);
        wizardHero.heroHP -= amp;
    }

    @Override
    public void visit(final PyromancerHero pyromancerHero) {
        pyromancerHero.DoTRounds = 2;
        pyromancerHero.DoTDmg = Math.round(hero.igniteDoT * hero.landAmp() * Constants.IGN_PYRO);
        int amp = Math.round(hero.igniteBaseDmg * hero.landAmp() * Constants.IGN_PYRO);
        pyromancerHero.heroHP -= amp;
    }
}
