package com.etapa1.main;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class GameInputLoader {
    private fileio.FileSystem fs = null;

    GameInputLoader(final fileio.FileSystem fs) {
        this.fs = fs;
    }

    public void load() {
        LinkedList<Integer> playersPosition = new LinkedList<Integer>();
        LinkedList<String> playersType = new LinkedList<String>();
        Map<Integer, String> gameMap = new HashMap<Integer, String>();
        LinkedList<String> playersMoves = new LinkedList<String>();
        int noRows = 0;
        int noColumns = 0;
        int noPlayers = 0;
        int noRounds = 0;

        try {
            noRows = fs.nextInt();
            noColumns = fs.nextInt();

            for (int i = 0; i < noRows; i++) {
                String line = fs.nextWord();
                for (int j = 0; j < noColumns; j++) {
                    gameMap.put(i * noColumns + j, Character.toString(line.charAt(j)));
                }
            }

            noPlayers = fs.nextInt();

            for (int i = 0; i < noPlayers; i++) {
                playersType.add(fs.nextWord());
                int playerRow = fs.nextInt();
                int playerColumn = fs.nextInt();
                int position = playerRow * noColumns + playerColumn;
                playersPosition.add(position);
            }

            noRounds = fs.nextInt();

            for (int i = 0; i < noRounds; i++) {
                String line = fs.nextWord();
                for (int j = 0; j < noPlayers; j++) {
                    playersMoves.add(Character.toString(line.charAt(j)));
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        GameInput gameInput = GameInput.getInstance();
        gameInput.setGameMap(gameMap);
        gameInput.setRounds(noRounds);
        gameInput.setPlayersMoves(playersMoves);
        gameInput.setPlayersPosition(playersPosition);
        gameInput.setUnit(noColumns);
        gameInput.setPlayersType(playersType);
    }

}
