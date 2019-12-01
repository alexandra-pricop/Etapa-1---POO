package com.etapa1.main;

import com.etapa1.heroes.Hero;
import com.etapa1.heroes.HeroFactory;
import com.etapa1.heroes.HeroTypes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public final class Main {
    private Main() {
    }

    public static void main(final String[] args) throws IOException {
        fileio.FileSystem fs = new fileio.FileSystem(args[0], args[1]);
        GameInputLoader gameInputLoader = new GameInputLoader(fs);
        gameInputLoader.load();
        ArrayList<Hero> heroes = new ArrayList<Hero>();
        for (int i = 0; i < GameInput.getInstance().getPlayersType().size(); i++) {
            if (GameInput.getInstance().getPlayersType().get(i).equals("P")) {
                heroes.add(HeroFactory.createHero(HeroTypes.P,
                        GameInput.getInstance().getPlayersPosition().get(i)));
            }
            if (GameInput.getInstance().getPlayersType().get(i).equals("W")) {
                heroes.add(HeroFactory.createHero(HeroTypes.W,
                        GameInput.getInstance().getPlayersPosition().get(i)));
            }
            if (GameInput.getInstance().getPlayersType().get(i).equals("R")) {
                heroes.add(HeroFactory.createHero(HeroTypes.R,
                        GameInput.getInstance().getPlayersPosition().get(i)));
            }
            if (GameInput.getInstance().getPlayersType().get(i).equals("K")) {
                heroes.add(HeroFactory.createHero(HeroTypes.K,
                        GameInput.getInstance().getPlayersPosition().get(i)));
            }
        }
        int noPlayers = heroes.size();
        LinkedList<String> heroesMoves =
                new LinkedList<>(GameInput.getInstance().getPlayersMoves());
        for (int i = 0; i < heroes.size(); i++) {
            for (int j = i; j < heroesMoves.size(); j += noPlayers) {
                heroes.get(i).heroMoves.add(heroesMoves.get(j));
            }
        }
        ArrayList<Hero> fighters = new ArrayList<Hero>();
        for (int i = 0; i < GameInput.getInstance().getRounds(); i++) {
            for (var hero : heroes) {
                hero.move(hero.heroMoves.get(i));
            }
            for (HashMap.Entry<Integer, String> pair
                    : GameInput.getInstance().getGameMap().entrySet()) {
                for (var hero : heroes) {
                    if (hero.heroPosition == pair.getKey()) {
                        hero.overtimeDmg(hero.DoTRounds, hero.DoTDmg);
                        if (hero.heroHP > 0) {
                            fighters.add(hero);
                        }
                    }
                }

                if (fighters.size() == 2) {
                    if (fighters.get(0).heroHP <= 0 || fighters.get(1).heroHP <= 0) {
                        fighters.clear();
                        continue;
                    }
                    fighters.get(0).attack(fighters.get(1));
                    fighters.get(1).attack(fighters.get(0));
                    if (fighters.get(0).heroHP <= 0) {
                        fighters.get(1).XPCalculator(fighters.get(1), fighters.get(0));
                        fighters.get(1).levelUp();
                    }
                    if (fighters.get(1).heroHP <= 0) {
                        fighters.get(0).XPCalculator(fighters.get(0), fighters.get(1));
                        fighters.get(0).levelUp();
                    }
                }
                fighters.clear();
            }
        }
          for (int i = 0; i < heroes.size(); i++) {
              fs.writeWord(heroes.get(i).toString());
              fs.writeWord("\n");
          }
          fs.close();
    }
}
