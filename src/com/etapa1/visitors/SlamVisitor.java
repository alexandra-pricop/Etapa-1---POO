package com.etapa1.visitors;

import com.etapa1.common.Constants;
import com.etapa1.heroes.KnightHero;
import com.etapa1.heroes.PyromancerHero;
import com.etapa1.heroes.RogueHero;
import com.etapa1.heroes.WizardHero;

public final class SlamVisitor implements AbilityVisitor {

    private final KnightHero hero;

    public SlamVisitor(final KnightHero hero) {
        this.hero = hero;
    }

    @Override
    public void visit(final KnightHero knightHero) {
        knightHero.stunRounds = 1;
        int dmg = Math.round(hero.slamDmg * hero.landAmp() * Constants.SL_KNIGHT);
        knightHero.heroHP -= dmg;
    }

    @Override
    public void visit(final RogueHero rogueHero) {
        rogueHero.stunRounds = 1;
        int dmg = Math.round(hero.slamDmg * hero.landAmp() * Constants.SL_ROGUE);
        rogueHero.heroHP -= dmg;
    }

    @Override
    public void visit(final WizardHero wizardHero) {
        wizardHero.stunRounds = 1;
        int dmg = Math.round(hero.slamDmg * hero.landAmp() * Constants.SL_WIZARD);
        wizardHero.heroHP -= dmg;
    }

    @Override
    public void visit(final PyromancerHero pyromancerHero) {
        pyromancerHero.stunRounds = 1;
        int dmg = Math.round(hero.slamDmg * hero.landAmp() * Constants.SL_PYRO);
        pyromancerHero.heroHP -= dmg;
    }
}
