package server;

import java.io.Serializable;

public class DataNeededForClient implements Serializable {
    private int playersNeededToStart;
    private int playersReady;
    private boolean isStarting = false;

//    public DataNeededForClient() {
//        this.playersNeededToStart = playersNeededToStart;
//        this.playersReady = playersReady;
//    }

    public int getPlayersNeededToStart() {
        return playersNeededToStart;
    }

    public int getPlayersReady() {
        return playersReady;
    }

    public void setPlayersReady(int playersReady) {
        this.playersReady = playersReady;
    }

    public void setPlayersNeededToStart(int playersNeededToStart) {
        this.playersNeededToStart = playersNeededToStart;
    }

    public void setStarting(boolean starting) {
        isStarting = starting;
    }
}