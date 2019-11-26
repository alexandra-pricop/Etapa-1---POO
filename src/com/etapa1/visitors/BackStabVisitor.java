package com.etapa1.visitors;

import com.etapa1.heroes.KnightHero;
import com.etapa1.heroes.PyromancerHero;
import com.etapa1.heroes.RogueHero;
import com.etapa1.heroes.WizardHero;
import com.etapa1.map.BattleGround;

public class BackStabVisitor implements AbilityVisitor {

    public final RogueHero hero;

    public BackStabVisitor (RogueHero hero) {
        this.hero = hero;
    }

    @Override
    public void visit(KnightHero knightHero) {

    }

    @Override
    public void visit(RogueHero rogueHero) {

    }

    @Override
    public void visit(WizardHero wizardHero) {
        int dmg = (int) Math.round(hero.backStabDmg + 0.25 * hero.backStabDmg);
        wizardHero.heroHP -= dmg;
    }

    @Override
    public void visit(PyromancerHero pyromancerHero) {

    }
}
