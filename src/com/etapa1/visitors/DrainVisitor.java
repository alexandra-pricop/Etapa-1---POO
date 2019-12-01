package com.etapa1.visitors;

import com.etapa1.common.Constants;
import com.etapa1.heroes.KnightHero;
import com.etapa1.heroes.PyromancerHero;
import com.etapa1.heroes.RogueHero;
import com.etapa1.heroes.WizardHero;

public final class DrainVisitor implements AbilityVisitor {

    private final WizardHero hero;

    public DrainVisitor(final WizardHero hero) {
        this.hero = hero;
    }

    @Override
    public void visit(final KnightHero knightHero) {
        int baseHP = (int) Math.min(Constants.BASE_HP * knightHero.maxLvlHp, knightHero.heroHP);
        float dmg = Constants.DR_KNIGHT * hero.drainDmg * hero.landAmp();
        knightHero.heroHP -= Math.round(dmg * baseHP);
    }

    @Override
    public void visit(final RogueHero rogueHero) {
        int baseHP = (int) Math.min(Constants.BASE_HP * rogueHero.maxLvlHp, rogueHero.heroHP);
        float dmg = Constants.DR_ROGUE * hero.drainDmg * hero.landAmp();
        rogueHero.heroHP -= Math.round(dmg * baseHP);
    }

    @Override
    public void visit(final WizardHero wizardHero) {
        int baseHP = (int) Math.min(Constants.BASE_HP * wizardHero.maxLvlHp, wizardHero.heroHP);
        float dmg = Constants.DR_WIZARD * hero.drainDmg * hero.landAmp();
        wizardHero.heroHP -= Math.round(dmg * baseHP);
    }

    @Override
    public void visit(final PyromancerHero pyromancerHero) {
        int baseHP = (int) Math.min(Constants.BASE_HP * pyromancerHero.maxLvlHp,
                pyromancerHero.heroHP);
        float dmg = Constants.DR_PYRO * hero.drainDmg * hero.landAmp();
        pyromancerHero.heroHP -= Math.round(dmg * baseHP);
    }
}
