package com.etapa1.main;

import java.util.LinkedList;
import java.util.Map;

public final class GameInput {

    private static GameInput instance = null;

    private GameInput() { }

    public static GameInput getInstance() {
        if (instance == null) {
            instance = new GameInput();
        }
        return instance;
    }

    private Map<Integer, String> mGameMap;
    private LinkedList<String> mPlayersType;
    private LinkedList<Integer> mPlayersPosition;
    private LinkedList<String> mPlayersMoves;
    private int mRounds;
    private int mUnit;

    public void setGameMap(final Map<Integer, String> gameMap) {
        this.mGameMap = gameMap;
    }

    public void setPlayersType(final LinkedList<String> playersType) {
        this.mPlayersType = playersType;
    }

    public void setPlayersPosition(final LinkedList<Integer> playersPosition) {
        this.mPlayersPosition = playersPosition;
    }

    public void setPlayersMoves(final LinkedList<String> playersMoves) {
        this.mPlayersMoves = playersMoves;
    }

    public void setRounds(final int rounds) {
        this.mRounds = rounds;
    }

    public void setUnit(final int unit) {
        this.mUnit = unit;
    }

    public Map<Integer, String> getGameMap() {
        return mGameMap;
    }

    public LinkedList<String> getPlayersType() {
        return mPlayersType;
    }

    public LinkedList<Integer> getPlayersPosition() {
        return mPlayersPosition;
    }

    public LinkedList<String> getPlayersMoves() {
        return mPlayersMoves;
    }

    public int getRounds() {
        return mRounds;
    }

    public int getUnit() {
        return mUnit;
    }

}
