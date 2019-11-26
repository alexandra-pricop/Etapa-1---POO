package com.etapa1.main;

import fileio.FileSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;

    GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }

    public GameInput load() {
        LinkedList<Integer> playersPosition = new LinkedList<Integer>();
        LinkedList<String> playersType = new LinkedList<String>();
        Map<Integer, String> gameMap = new HashMap<Integer, String>();
        LinkedList<String> playersMoves = new LinkedList<String>();
        int noRows = 0;
        int noColumns = 0;
        int noPlayers = 0;
        int noRounds = 0;

        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);

            noRows = fs.nextInt();
            noColumns = fs.nextInt();

            for(int i = 0; i < noRows; i++) {
                String line = fs.nextWord();
                for(int j = 0; j < noColumns; j++) {
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

            for(int i = 0; i < noRounds; i++) {
                String line = fs.nextWord();
                for (int j = 0; j < noPlayers; j++) {
                    playersMoves.add(Character.toString(line.charAt(j)));
                }
            }

            fs.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new GameInput(gameMap, playersType, playersPosition, playersMoves, noRounds, noColumns);
    }

}
