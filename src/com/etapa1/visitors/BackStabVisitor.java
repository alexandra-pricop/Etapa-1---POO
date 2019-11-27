package com.etapa1.visitors;

import com.etapa1.heroes.KnightHero;
import com.etapa1.heroes.PyromancerHero;
import com.etapa1.heroes.RogueHero;
import com.etapa1.heroes.WizardHero;
import com.etapa1.main.GameInput;
import com.etapa1.map.BattleGround;

public class BackStabVisitor implements AbilityVisitor {

    public final RogueHero hero;

    public BackStabVisitor (RogueHero hero) {
        this.hero = hero;
    }

    @Override
    public void visit(KnightHero knightHero) {
        int amp = Math.round(hero.backStabDmg * hero.landAmp());
        if (hero.criticalHits % 3 == 0 && GameInput.getInstance().getGameMap().get(hero.heroPosition).equals("W")){
            amp = Math.round(amp * 1.5f);
        }
        int dmg = (int) Math.round(amp - 0.1f * amp);
        knightHero.heroHP -= dmg;
        //hero.criticalHits++;
    }

    @Override
    public void visit(RogueHero rogueHero) {
        int amp = Math.round(hero.backStabDmg * hero.landAmp());
        if (hero.criticalHits % 3 == 0 && GameInput.getInstance().getGameMap().get(hero.heroPosition).equals("W")){
            amp = Math.round(amp * 1.5f);
        }
        int dmg = (int) Math.round(amp + 0.2f * amp);
        rogueHero.heroHP -= dmg;
        //hero.criticalHits++;
    }

    @Override
    public void visit(WizardHero wizardHero) {
        int amp = Math.round(hero.backStabDmg * hero.landAmp());
        if (hero.criticalHits % 3 == 0 && GameInput.getInstance().getGameMap().get(hero.heroPosition).equals("W")){
            amp = Math.round(amp * 1.5f);
        }
        int dmg = (int) Math.round(amp + 0.25f * amp);
        wizardHero.heroHP -= dmg;
        //hero.criticalHits++;
    }

    @Override
    public void visit(PyromancerHero pyromancerHero) {
        int amp = Math.round(hero.backStabDmg * hero.landAmp());
        if (hero.criticalHits % 3 == 0 && GameInput.getInstance().getGameMap().get(hero.heroPosition).equals("W")){
            amp = Math.round(amp * 1.5f);
        }
        int dmg = (int) Math.round(amp + 0.25f * amp);
        pyromancerHero.heroHP -= dmg;
        //hero.criticalHits++;
    }
}
