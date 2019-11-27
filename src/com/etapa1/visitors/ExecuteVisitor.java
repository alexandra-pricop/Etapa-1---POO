package com.etapa1.visitors;

import com.etapa1.heroes.KnightHero;
import com.etapa1.heroes.PyromancerHero;
import com.etapa1.heroes.RogueHero;
import com.etapa1.heroes.WizardHero;

public class ExecuteVisitor implements AbilityVisitor {

    private final KnightHero hero;

    public ExecuteVisitor(KnightHero hero) {
        this.hero = hero;
    }

    @Override
    public void visit(KnightHero knightHero) {
        if(knightHero.heroHP < hero.enemyXPLimit * knightHero.maxLvlHp) {
            knightHero.heroHP = 0;
            return;
        }
        int dmg = Math.round(hero.executeDmg * hero.landAmp() * 1.0f);
        knightHero.heroHP -= dmg;
    }

    @Override
    public void visit(RogueHero rogueHero) {
        if(rogueHero.heroHP < hero.enemyXPLimit * rogueHero.maxLvlHp) {
            rogueHero.heroHP = 0;
            return;
        }
        int dmg = Math.round(hero.executeDmg * hero.landAmp() * 1.15f);
        rogueHero.heroHP -= dmg;
    }

    @Override
    public void visit(WizardHero wizardHero) {
        if(wizardHero.heroHP < hero.enemyXPLimit * wizardHero.maxLvlHp) {
            wizardHero.heroHP = 0;
            return;
        }
        int dmg = Math.round(hero.executeDmg * hero.landAmp() * 0.8f);
        wizardHero.heroHP -= dmg;
    }

    @Override
    public void visit(PyromancerHero pyromancerHero) {
        if(pyromancerHero.heroHP < hero.enemyXPLimit * pyromancerHero.maxLvlHp) {
            pyromancerHero.heroHP = 0;
            return;
        }
        int dmg = Math.round(hero.executeDmg * hero.landAmp() * 1.1f);
        pyromancerHero.heroHP -= dmg;
    }
}
