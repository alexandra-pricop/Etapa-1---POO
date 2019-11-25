package com.etapa1.main;

import com.etapa1.heros.Hero;
import com.etapa1.heros.HeroFactory;
import com.etapa1.heros.HeroTypes;

import java.util.ArrayList;
import java.util.LinkedList;

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
        System.out.println("NUMAR RUNDE " + gameInput.getRounds());
        System.out.println("HARTA " + gameInput.getGameMap());
        System.out.println("TIPURI DE PLAYERS " + gameInput.getPlayersType());
        System.out.println("POZITII PLAYERS " + gameInput.getPlayersPosition());
        System.out.println("MISCARI " + gameInput.getPlayersMoves());
        System.out.println("NUMAR DE JUCATORI " + gameInput.getPlayersType().size());
    }
}
