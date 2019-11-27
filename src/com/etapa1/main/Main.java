package com.etapa1.main;

import com.etapa1.heroes.Hero;
import com.etapa1.heroes.HeroFactory;
import com.etapa1.heroes.HeroTypes;
import fileio.FileSystem;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private Main() {
    }

    public static void main(final String[] args) throws IOException {
        fileio.FileSystem fs = new fileio.FileSystem(args[0], args[1]);
        GameInputLoader gameInputLoader = new GameInputLoader(fs);
        gameInputLoader.load();
        //LinkedList<String> players = new LinkedList<String>(gameInput.getPlayersType());
        ArrayList<Hero> heroes = new ArrayList<Hero>();
        for (int i = 0; i < GameInput.getInstance().getPlayersType().size(); i++) {
            if (GameInput.getInstance().getPlayersType().get(i).equals("P")) {
                heroes.add(HeroFactory.createHero(HeroTypes.P, GameInput.getInstance().getPlayersPosition().get(i)));
            }
            if (GameInput.getInstance().getPlayersType().get(i).equals("W")) {
                heroes.add(HeroFactory.createHero(HeroTypes.W, GameInput.getInstance().getPlayersPosition().get(i)));
            }
            if (GameInput.getInstance().getPlayersType().get(i).equals("R")) {
                heroes.add(HeroFactory.createHero(HeroTypes.R, GameInput.getInstance().getPlayersPosition().get(i)));
            }
            if (GameInput.getInstance().getPlayersType().get(i).equals("K")) {
                heroes.add(HeroFactory.createHero(HeroTypes.K, GameInput.getInstance().getPlayersPosition().get(i)));
            }
        }
        for (int i = 0 ; i < GameInput.getInstance().getRounds(); i++) {
            if(heroes.get(0).heroHP <= 0 || heroes.get(1).heroHP <= 0) {
                //System.out.println(heroes);
                //System.out.println("mort AICI");
                break;
            }
            heroes.get(0).overtimeDmg(heroes.get(0).DoTRounds, heroes.get(0).DoTDmg);
            //System.out.println(heroes.get(0).heroHP);
            heroes.get(1).overtimeDmg(heroes.get(1).DoTRounds, heroes.get(1).DoTDmg);
            //System.out.println(heroes.get(1).heroHP);
            if(heroes.get(0).heroHP <= 0 || heroes.get(1).heroHP <= 0) {
                System.out.println(heroes);
                System.out.println("mort AICI");
                break;
            }
            heroes.get(0).attack(heroes.get(1));
//            if(heroes.get(1).heroHP <= 0) {
//                System.out.println(heroes);
//                break;
//            }
            heroes.get(1).attack(heroes.get(0));
            //System.out.println(heroes);

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
              fs.writeWord(hero.toString());
              fs.writeWord("\n");
          }
          fs.close();
    }
}
