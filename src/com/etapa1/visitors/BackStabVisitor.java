package com.etapa1.visitors;

import com.etapa1.common.Constants;
import com.etapa1.heroes.KnightHero;
import com.etapa1.heroes.PyromancerHero;
import com.etapa1.heroes.RogueHero;
import com.etapa1.heroes.WizardHero;
import com.etapa1.main.GameInput;

public final class BackStabVisitor implements AbilityVisitor {

    private final RogueHero hero;

    public BackStabVisitor(final RogueHero hero) {
        this.hero = hero;
    }

    @Override
    public void visit(final KnightHero knightHero) {
        int amp = Math.round(hero.backStabDmg * hero.landAmp());
        if (hero.criticalHits % Constants.CRITICAL == 0
                && GameInput.getInstance().getGameMap().get(hero.heroPosition).equals("W")) {
            amp = Math.round(amp * Constants.C_AMP);
        }
        int dmg = (int) Math.round(amp - Constants.B_KNIGHT * amp);
        knightHero.heroHP -= dmg;
    }

    @Override
    public void visit(final RogueHero rogueHero) {
        int amp = Math.round(hero.backStabDmg * hero.landAmp());
        if (hero.criticalHits % Constants.CRITICAL == 0
                && GameInput.getInstance().getGameMap().get(hero.heroPosition).equals("W")) {
            amp = Math.round(amp * Constants.C_AMP);
        }
        int dmg = (int) Math.round(amp + Constants.B_ROGUE * amp);
        rogueHero.heroHP -= dmg;
    }

    @Override
    public void visit(final WizardHero wizardHero) {
        int amp = Math.round(hero.backStabDmg * hero.landAmp());
        if (hero.criticalHits % Constants.CRITICAL == 0
                && GameInput.getInstance().getGameMap().get(hero.heroPosition).equals("W")) {
            amp = Math.round(amp * Constants.C_AMP);
        }
        int dmg = (int) Math.round(amp + Constants.B_WIZARD * amp);
        wizardHero.heroHP -= dmg;
    }

    @Override
    public void visit(final PyromancerHero pyromancerHero) {
        int amp = Math.round(hero.backStabDmg * hero.landAmp());
        if (hero.criticalHits % Constants.CRITICAL == 0
                && GameInput.getInstance().getGameMap().get(hero.heroPosition).equals("W")) {
            amp = Math.round(amp * Constants.C_AMP);
        }
        int dmg = (int) Math.round(amp + Constants.B_PYRO * amp);
        pyromancerHero.heroHP -= dmg;
    }
}
