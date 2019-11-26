package com.etapa1.main;

import java.util.LinkedList;
import java.util.Map;

public class GameInput {

    private Map<Integer, String> mGameMap;
    private LinkedList<String> mPlayersType;
    private LinkedList<Integer> mPlayersPosition;
    private LinkedList<String> mPlayersMoves;
    private int mRounds;
    private int mUnit;

    public GameInput(Map<Integer, String> gameMap, LinkedList<String> playersType, LinkedList<Integer> playersPosition, LinkedList<String> playersMoves, int noRounds, int gameUnit) {
        mGameMap = gameMap;
        mPlayersType = playersType;
        mPlayersPosition = playersPosition;
        mPlayersMoves = playersMoves;
        mRounds = noRounds;
        mUnit = gameUnit;
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

    public int getUnit() { return mUnit; }
}
