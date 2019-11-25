package com.etapa1.main;

public class Main {
    private Main() {
    }

    public static void main(final String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();
        System.out.println("NUMAR RUNDE " + gameInput.getRounds());
        System.out.println("HARTA " + gameInput.getGameMap());
        System.out.println("TIPURI DE PLAYERS " + gameInput.getPlayersType());
        System.out.println("POZITII PLAYERS " + gameInput.getPlayersPosition());
        System.out.println("MISCARI " + gameInput.getPlayersMoves());
        System.out.println("NUMAR DE JUCATORI " + gameInput.getPlayersType().size());
    }
}
