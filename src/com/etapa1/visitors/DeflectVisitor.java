package com.etapa1.visitors;

import com.etapa1.common.Constants;
import com.etapa1.heroes.KnightHero;
import com.etapa1.heroes.PyromancerHero;
import com.etapa1.heroes.RogueHero;
import com.etapa1.heroes.WizardHero;
import com.etapa1.main.GameInput;

public class DeflectVisitor implements AbilityVisitor {

    private final WizardHero hero;

    public DeflectVisitor(WizardHero hero) {
        this.hero = hero;
    }

    @Override
    public void visit(KnightHero knightHero) {
        int bDmg = Math.round(knightHero.executeDmg * knightHero.landAmp());
        int pDmg = Math.round(knightHero.slamDmg * knightHero.landAmp());
        float dmg = 1.4f * hero.deflectDmg * hero.landAmp();
//        if(hero.heroHP < bDmg + pDmg) {
//            dmg =  1.2f * hero.heroHP * hero.landAmp();
//        }
        knightHero.heroHP -= Math.round((bDmg + pDmg) * dmg);
    }

    @Override
    public void visit(RogueHero rogueHero) {
        int bDmg;
        if((rogueHero.criticalHits % 3 == 0 || rogueHero.criticalHits % 3 == 1)  && GameInput.getInstance().getGameMap().get(rogueHero.heroPosition).equals("W")) {
            bDmg = Math.round(rogueHero.backStabDmg * rogueHero.landAmp() * 1.5f);
            //System.out.println("critical");
        }
        else {
            bDmg = Math.round(rogueHero.backStabDmg * rogueHero.landAmp());
        }
        int pDmg = Math.round(rogueHero.paralysisDmg * rogueHero.landAmp());
        float dmg = 1.2f * hero.deflectDmg * hero.landAmp();
//        if(hero.heroHP < bDmg + pDmg) {
//            dmg =  1.2f * hero.heroHP * hero.landAmp();
//        }
        rogueHero.heroHP -= Math.round((bDmg + pDmg) * dmg);
    }

    @Override
    public void visit(WizardHero wizardHero) {
    }

    @Override
    public void visit(PyromancerHero pyromancerHero) {
        int bDmg = Math.round(pyromancerHero.fireBlastDmg * pyromancerHero.landAmp());
        int pDmg = Math.round(pyromancerHero.igniteBaseDmg * pyromancerHero.landAmp());
        float dmg = 1.3f * hero.deflectDmg * hero.landAmp();
//        if(hero.heroHP < bDmg + pDmg) {
//            dmg =  1.2f * hero.heroHP * hero.landAmp();
//        }
        pyromancerHero.heroHP -= Math.round((bDmg + pDmg) * dmg);
    }
}
