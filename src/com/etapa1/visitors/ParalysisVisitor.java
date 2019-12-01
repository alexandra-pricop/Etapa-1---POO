package com.etapa1.visitors;

import com.etapa1.common.Constants;
import com.etapa1.heroes.KnightHero;
import com.etapa1.heroes.PyromancerHero;
import com.etapa1.heroes.RogueHero;
import com.etapa1.heroes.WizardHero;
import com.etapa1.main.GameInput;

public final class ParalysisVisitor implements AbilityVisitor {

    private final RogueHero hero;

    public ParalysisVisitor(final RogueHero hero) {
        this.hero = hero;
    }
    @Override
    public void visit(final KnightHero knightHero) {
        if (GameInput.getInstance().getGameMap().get(knightHero.heroPosition).equals("W")) {
            knightHero.DoTRounds = Constants.W_DOT_ROUNDS;
            knightHero.stunRounds = Constants.W_DOT_ROUNDS;
        } else {
            knightHero.DoTRounds = Constants.DOT_ROUNDS;
            knightHero.stunRounds = Constants.DOT_ROUNDS;
        }
        int currDmg =  Math.round(hero.paralysisDmg * hero.landAmp()
                - Constants.PAR_KNIGHT * hero.paralysisDmg * hero.landAmp());
        knightHero.heroHP -= currDmg;
        knightHero.DoTDmg = currDmg;
    }

    @Override
    public void visit(final RogueHero rogueHero) {
        if (GameInput.getInstance().getGameMap().get(rogueHero.heroPosition).equals("W")) {
            rogueHero.DoTRounds = Constants.W_DOT_ROUNDS;
            rogueHero.stunRounds = Constants.W_DOT_ROUNDS;
        } else {
            rogueHero.DoTRounds = Constants.DOT_ROUNDS;
            rogueHero.stunRounds = Constants.DOT_ROUNDS;
        }
        int currDmg =  Math.round(hero.paralysisDmg * hero.landAmp()
                - Constants.PAR_ROGUE * hero.paralysisDmg * hero.landAmp());
        rogueHero.heroHP -= currDmg;
        rogueHero.DoTDmg = currDmg;
    }

    @Override
    public void visit(final WizardHero wizardHero) {
        if (GameInput.getInstance().getGameMap().get(wizardHero.heroPosition).equals("W")) {
            wizardHero.DoTRounds = Constants.W_DOT_ROUNDS;
            wizardHero.stunRounds = Constants.W_DOT_ROUNDS;
        } else {
            wizardHero.DoTRounds = Constants.DOT_ROUNDS;
            wizardHero.stunRounds = Constants.DOT_ROUNDS;
        }
        int currDmg =  Math.round(hero.paralysisDmg * hero.landAmp()
                + Constants.PAR_WIZARD * hero.paralysisDmg * hero.landAmp());
        wizardHero.heroHP -= currDmg;
        wizardHero.DoTDmg = currDmg;
    }

    @Override
    public void visit(final PyromancerHero pyromancerHero) {
        if (GameInput.getInstance().getGameMap().get(pyromancerHero.heroPosition).equals("W")) {
            pyromancerHero.DoTRounds = Constants.W_DOT_ROUNDS;
            pyromancerHero.stunRounds = Constants.W_DOT_ROUNDS;
        } else {
            pyromancerHero.DoTRounds = Constants.DOT_ROUNDS;
            pyromancerHero.stunRounds = Constants.DOT_ROUNDS;
        }
        int currDmg =  Math.round(hero.paralysisDmg * hero.landAmp()
                + Constants.PAR_PYRO * hero.paralysisDmg * hero.landAmp());
        pyromancerHero.heroHP -= currDmg;
        pyromancerHero.DoTDmg = currDmg;
    }
}
