package com.etapa1.main;

import java.util.LinkedList;
import java.util.Map;

public class GameInput {

    private static GameInput instance = null;

    private GameInput() {}

    public static GameInput getInstance() {
        if(instance == null) {
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

    public void setGameMap(Map<Integer, String> mGameMap) {
        this.mGameMap = mGameMap;
    }

    public void setPlayersType(LinkedList<String> mPlayersType) {
        this.mPlayersType = mPlayersType;
    }

    public void setPlayersPosition(LinkedList<Integer> mPlayersPosition) {
        this.mPlayersPosition = mPlayersPosition;
    }

    public void setPlayersMoves(LinkedList<String> mPlayersMoves) {
        this.mPlayersMoves = mPlayersMoves;
    }

    public void setRounds(int mRounds) {
        this.mRounds = mRounds;
    }

    public void setUnit(int mUnit) {
        this.mUnit = mUnit;
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
