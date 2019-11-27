package com.etapa1.visitors;

import com.etapa1.heroes.KnightHero;
import com.etapa1.heroes.PyromancerHero;
import com.etapa1.heroes.RogueHero;
import com.etapa1.heroes.WizardHero;

public class SlamVisitor implements AbilityVisitor {

    private final KnightHero hero;

    public SlamVisitor(KnightHero hero) {
        this.hero = hero;
    }

    @Override
    public void visit(KnightHero knightHero) {
        knightHero.stunRounds = 1;
        int dmg = Math.round(hero.slamDmg * hero.landAmp() * 1.2f);
        knightHero.heroHP -= dmg;
    }

    @Override
    public void visit(RogueHero rogueHero) {
        rogueHero.stunRounds = 1;
        int dmg = Math.round(hero.slamDmg * hero.landAmp() * 0.8f);
        rogueHero.heroHP -= dmg;
    }

    @Override
    public void visit(WizardHero wizardHero) {
        wizardHero.stunRounds = 1;
        int dmg = Math.round(hero.slamDmg * hero.landAmp() * 1.05f);
        wizardHero.heroHP -= dmg;
    }

    @Override
    public void visit(PyromancerHero pyromancerHero) {
        pyromancerHero.stunRounds = 1;
        int dmg = Math.round(hero.slamDmg * hero.landAmp() * 0.9f);
        pyromancerHero.heroHP -= dmg;
    }
}
