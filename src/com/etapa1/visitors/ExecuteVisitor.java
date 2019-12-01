package com.etapa1.visitors;

import com.etapa1.common.Constants;
import com.etapa1.heroes.KnightHero;
import com.etapa1.heroes.PyromancerHero;
import com.etapa1.heroes.RogueHero;
import com.etapa1.heroes.WizardHero;

public final class ExecuteVisitor implements AbilityVisitor {

    private final KnightHero hero;

    public ExecuteVisitor(final KnightHero hero) {
        this.hero = hero;
    }

    @Override
    public void visit(final KnightHero knightHero) {
        if (knightHero.heroHP < hero.enemyXPLimit * knightHero.maxLvlHp) {
            knightHero.heroHP = 0;
            return;
        }
        int dmg = Math.round(hero.executeDmg * hero.landAmp() * Constants.EX_KNIGHT);
        knightHero.heroHP -= dmg;
    }

    @Override
    public void visit(final RogueHero rogueHero) {
        if (rogueHero.heroHP < hero.enemyXPLimit * rogueHero.maxLvlHp) {
            rogueHero.heroHP = 0;
            return;
        }
        int dmg = Math.round(hero.executeDmg * hero.landAmp() * Constants.EX_ROGUE);
        rogueHero.heroHP -= dmg;
    }

    @Override
    public void visit(final WizardHero wizardHero) {
        if (wizardHero.heroHP < hero.enemyXPLimit * wizardHero.maxLvlHp) {
            wizardHero.heroHP = 0;
            return;
        }
        int dmg = Math.round(hero.executeDmg * hero.landAmp() * Constants.EX_WIZARD);
        wizardHero.heroHP -= dmg;
    }

    @Override
    public void visit(final PyromancerHero pyromancerHero) {
        if (pyromancerHero.heroHP < hero.enemyXPLimit * pyromancerHero.maxLvlHp) {
            pyromancerHero.heroHP = 0;
            return;
        }
        int dmg = Math.round(hero.executeDmg * hero.landAmp() * Constants.EX_PYRO);
        pyromancerHero.heroHP -= dmg;
    }
}
