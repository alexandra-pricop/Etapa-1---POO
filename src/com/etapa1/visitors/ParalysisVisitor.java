package com.etapa1.visitors;

import com.etapa1.common.Constants;
import com.etapa1.heroes.KnightHero;
import com.etapa1.heroes.PyromancerHero;
import com.etapa1.heroes.RogueHero;
import com.etapa1.heroes.WizardHero;
import com.etapa1.main.GameInput;

public class ParalysisVisitor implements AbilityVisitor {

    private final RogueHero hero;

    public ParalysisVisitor(RogueHero hero) {
        this.hero = hero;
    }
    @Override
    public void visit(KnightHero knightHero) {
        if(GameInput.getInstance().getGameMap().get(knightHero.heroPosition).equals("W")) {
            knightHero.DoTRounds = 6;
            knightHero.stunRounds = 6;
        }
        else {
            knightHero.DoTRounds = 3;
            knightHero.stunRounds = 3;
        }
        int currDmg =  Math.round(hero.paralysisDmg * hero.landAmp() - 0.2f * hero.paralysisDmg * hero.landAmp());
        knightHero.heroHP -= currDmg;
        knightHero.DoTDmg = currDmg;
    }

    @Override
    public void visit(RogueHero rogueHero) {
        if(GameInput.getInstance().getGameMap().get(rogueHero.heroPosition).equals("W")) {
            rogueHero.DoTRounds = 6;
            rogueHero.stunRounds = 6;
        }
        else {
            rogueHero.DoTRounds = 3;
            rogueHero.stunRounds = 3;
        }
        int currDmg =  Math.round(hero.paralysisDmg * hero.landAmp() - 0.1f * hero.paralysisDmg * hero.landAmp());
        rogueHero.heroHP -= currDmg;
        rogueHero.DoTDmg = currDmg;
    }

    @Override
    public void visit(WizardHero wizardHero) {
        if(GameInput.getInstance().getGameMap().get(wizardHero.heroPosition).equals("W")) {
            wizardHero.DoTRounds = 6;
            wizardHero.stunRounds = 6;
        }
        else {
            wizardHero.DoTRounds = 3;
            wizardHero.stunRounds = 3;
        }
        int currDmg =  Math.round(hero.paralysisDmg * hero.landAmp() + 0.25f * hero.paralysisDmg * hero.landAmp());
        wizardHero.heroHP -= currDmg;
        wizardHero.DoTDmg = currDmg;
    }

    @Override
    public void visit(PyromancerHero pyromancerHero) {
        if(GameInput.getInstance().getGameMap().get(pyromancerHero.heroPosition).equals("W")) {
            pyromancerHero.DoTRounds = 6;
            pyromancerHero.stunRounds = 6;
        }
        else {
            pyromancerHero.DoTRounds = 3;
            pyromancerHero.stunRounds = 3;
        }
        int currDmg =  Math.round(hero.paralysisDmg * hero.landAmp() + 0.2f * hero.paralysisDmg * hero.landAmp());
        pyromancerHero.heroHP -= currDmg;
        pyromancerHero.DoTDmg = currDmg;
    }
}
