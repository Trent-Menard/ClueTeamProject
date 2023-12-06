package game;

import java.util.ArrayList;
import java.util.List;

public class Room extends Card {
    private int rowStart;
    private int rowEnd;
    private int columnStart;
    private int columnEnd;
    private List<Integer> xCoordinates = new ArrayList<>();
    private List<Integer> yCoordinates = new ArrayList<>();

    public Room(String name, int rowStart, int rowEnd, int columnStart, int columnEnd) {
        super(name);
        this.rowStart = rowStart;
        this.rowEnd = rowEnd;
        this.columnStart = columnStart;
        this.columnEnd = columnEnd;
    }

    public void addXCoordinate(int x){
        this.xCoordinates.add(x);
    }

    public void addYCoordinate(int y){
        this.yCoordinates.add(y);
    }

    public Room(String name) {
        super(name);
    }

    public int getRowStart() {
        return rowStart;
    }

    public int getRowEnd() {
        return rowEnd;
    }

    public int getColumnStart() {
        return columnStart;
    }

    public int getColumnEnd() {
        return columnEnd;
    }



//    public int getCenterX() {
//        switch (getCardName()) {
//            case "Kitchen":

    public List<Integer> getxCoordinates() {
        return xCoordinates;
    }

    public List<Integer> getyCoordinates() {
        return yCoordinates;
    }
//                return 1;
//                break;
//            case "Ballroom":
//                // 1,7
//                break;
//            case "Conservatory":
//                // 1,13
//                break;
//            case "Dining Room":
//                // 7, 1
//                break;
//            case "?":
//                // 7, 7
//                break;
//            case "Billard ROom":
//                // 7, 13
//                break;
//            case "Lounge":
//                // 13, 1
//                break;
//            case "Hall":
//                // 13, 7
//                break;
//            case "Study":
//                // 13, 13
//                break;
//        }
//    }
//
//    public int getCenterY() {
//        switch (getCardName()) {
//            case "Kitchen":
//                // 1, 1
//                break;
//            case "Ballroom":
//                // 1,7
//                break;
//            case "Conservatory":
//                // 1,13
//                break;
//            case "Dining Room":
//                // 7, 1
//                break;
//            case "?":
//                // 7, 7
//                break;
//            case "Billard ROom":
//                // 7, 13
//                break;
//            case "Lounge":
//                // 13, 1
//                break;
//            case "Hall":
//                // 13, 7
//                break;
//            case "Study":
//                // 13, 13
//                break;
//        }
//    }

//    public String getRoomName() {
//
//        switch (rowStart) {
//
//            case 0, 1, 2 -> {
//                switch (columnStart) {
//                    case 0, 1, 2 -> { return "KITCHEN"; }
//                    case 6, 7, 8 -> { return "BALLROOM"; }
//                    case 12, 13, 14 -> { return "CONSERVATORY"; }
//                }
//            }
//
//            case 6, 7, 8 -> {
//                switch (columnStart) {
//                    case 0, 1, 2 -> { return "DINING ROOM"; }
//                    case 6, 7, 8 -> { return "?"; }
//                    case 12, 13, 14 -> { return "BILLIARD ROOM"; }
//                }
//            }
//
//            case 12, 13, 14 -> {
//                switch (columnStart) {
//                    case 0, 1, 2 -> { return "LOUNGE"; }
//                    case 6, 7, 8 -> { return "HALL"; }
//                    case 12, 13, 14 -> { return "STUDY"; }
//                }
//            }
//        }
//
//        return "Room does not exist.";
//    }
}