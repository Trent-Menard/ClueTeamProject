package game;

import java.util.ArrayList;
import java.util.List;

public class BoardData {
    private Player player;
    private List<Player> players = new ArrayList<>();

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}