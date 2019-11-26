package com.etapa1.main;

import com.etapa1.heroes.Hero;
import com.etapa1.heroes.HeroFactory;
import com.etapa1.heroes.HeroTypes;

import java.util.ArrayList;

public class Main {
    private Main() {
    }

    public static void main(final String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();
        //LinkedList<String> players = new LinkedList<String>(gameInput.getPlayersType());
        ArrayList<Hero> heroes = new ArrayList<Hero>();
        for (int i = 0; i < gameInput.getPlayersType().size(); i++) {
            if (gameInput.getPlayersType().get(i).equals("P")) {
                heroes.add(HeroFactory.createHero(HeroTypes.P, gameInput.getPlayersPosition().get(i)));
            }
            if (gameInput.getPlayersType().get(i).equals("W")) {
                heroes.add(HeroFactory.createHero(HeroTypes.W, gameInput.getPlayersPosition().get(i)));
            }
            if (gameInput.getPlayersType().get(i).equals("R")) {
                heroes.add(HeroFactory.createHero(HeroTypes.R, gameInput.getPlayersPosition().get(i)));
            }
            if (gameInput.getPlayersType().get(i).equals("K")) {
                heroes.add(HeroFactory.createHero(HeroTypes.K, gameInput.getPlayersPosition().get(i)));
            }
        }
        for (int i = 0 ; i < gameInput.getRounds(); i++) {
            heroes.get(0).attack(heroes.get(1));
            heroes.get(1).attack(heroes.get(0));
            System.out.println(heroes);

        }
//        System.out.println(heroes.get(0).equals(heroes.get(1)));
//        System.out.println("HEROES " + heroes);
//        System.out.println("NUMAR RUNDE " + gameInput.getRounds());
//        System.out.println("HARTA " + gameInput.getGameMap());
//        System.out.println("TIPURI DE PLAYERS " + gameInput.getPlayersType());
//        System.out.println("POZITII PLAYERS " + gameInput.getPlayersPosition());
//        System.out.println("MISCARI " + gameInput.getPlayersMoves());
//        System.out.println("NUMAR DE JUCATORI " + gameInput.getPlayersType().size());
          for(var hero : heroes) {
              if(hero.heroHP <= 0) {
                  System.out.println("DEAD");
              }
              else {
                  System.out.println(hero);
              }
          }
    }
}
