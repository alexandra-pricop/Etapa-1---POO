package com.etapa1.visitors;

import com.etapa1.common.Constants;
import com.etapa1.heroes.KnightHero;
import com.etapa1.heroes.PyromancerHero;
import com.etapa1.heroes.RogueHero;
import com.etapa1.heroes.WizardHero;

public final class FireBlastVisitor implements AbilityVisitor {

    private final PyromancerHero hero;

    public FireBlastVisitor(final PyromancerHero hero) {
        this.hero = hero;
    }

    @Override
    public void visit(final KnightHero knightHero) {
        int amp = Math.round(hero.fireBlastDmg * hero.landAmp());
        knightHero.heroHP -= Math.round(amp * Constants.FB_KNIGHT);
    }

    @Override
    public void visit(final RogueHero rogueHero) {
        int amp = Math.round(hero.fireBlastDmg * hero.landAmp());
        rogueHero.heroHP -= Math.round(amp * Constants.FB_ROGUE);
    }

    @Override
    public void visit(final WizardHero wizardHero) {
        int amp = Math.round(hero.fireBlastDmg * hero.landAmp());
        wizardHero.heroHP -= Math.round(amp * Constants.FB_WIZARD);
    }

    @Override
    public void visit(final PyromancerHero pyromancerHero) {
        int amp = Math.round(hero.fireBlastDmg * hero.landAmp());
        pyromancerHero.heroHP -= Math.round(amp * Constants.FB_PYRO);
    }
}
