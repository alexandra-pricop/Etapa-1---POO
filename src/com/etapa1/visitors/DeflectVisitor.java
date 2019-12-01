package com.etapa1.visitors;

import com.etapa1.common.Constants;
import com.etapa1.heroes.KnightHero;
import com.etapa1.heroes.PyromancerHero;
import com.etapa1.heroes.RogueHero;
import com.etapa1.heroes.WizardHero;
import com.etapa1.main.GameInput;

public final class DeflectVisitor implements AbilityVisitor {

    private final WizardHero hero;

    public DeflectVisitor(final WizardHero hero) {
        this.hero = hero;
    }

    @Override
    public void visit(final KnightHero knightHero) {
        int bDmg = Math.round(knightHero.executeDmg * knightHero.landAmp());
        int pDmg = Math.round(knightHero.slamDmg * knightHero.landAmp());
        float dmg = Constants.DEF_KNIGHT * hero.deflectDmg * hero.landAmp();
        knightHero.heroHP -= Math.round((bDmg + pDmg) * dmg);
    }

    @Override
    public void visit(final RogueHero rogueHero) {
        int bDmg;
        if ((rogueHero.criticalHits % Constants.CRITICAL == 0
                || rogueHero.criticalHits % Constants.CRITICAL == 1)
                && GameInput.getInstance().getGameMap().get(rogueHero.heroPosition).equals("W")) {
            bDmg = Math.round(rogueHero.backStabDmg * rogueHero.landAmp() * Constants.C_AMP);
            //System.out.println("critical");
        } else {
            bDmg = Math.round(rogueHero.backStabDmg * rogueHero.landAmp());
        }
        int pDmg = Math.round(rogueHero.paralysisDmg * rogueHero.landAmp());
        float dmg = Constants.DEF_ROGUE * hero.deflectDmg * hero.landAmp();
        rogueHero.heroHP -= Math.round((bDmg + pDmg) * dmg);
    }

    @Override
    public void visit(final WizardHero wizardHero) {
    }

    @Override
    public void visit(final PyromancerHero pyromancerHero) {
        int bDmg = Math.round(pyromancerHero.fireBlastDmg * pyromancerHero.landAmp());
        int pDmg = Math.round(pyromancerHero.igniteBaseDmg * pyromancerHero.landAmp());
        float dmg = Constants.DEF_PYRO * hero.deflectDmg * hero.landAmp();
        pyromancerHero.heroHP -= Math.round((bDmg + pDmg) * dmg);
    }
}
