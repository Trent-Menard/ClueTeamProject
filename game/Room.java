package game;

public class Room extends Card {
    private int rowStart;
    private int rowEnd;
    private int columnStart;
    private int columnEnd;

    public Room(String name, int rowStart, int rowEnd, int columnStart, int columnEnd) {
        super(name);
        this.rowStart = rowStart;
        this.rowEnd = rowEnd;
        this.columnStart = columnStart;
        this.columnEnd = columnEnd;
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

    public String getRoomName() {

        switch (rowStart) {

            case 0, 1, 2 -> {
                switch (columnStart) {
                    case 0, 1, 2 -> { return "KITCHEN"; }
                    case 6, 7, 8 -> { return "BALLROOM"; }
                    case 12, 13, 14 -> { return "CONSERVATORY"; }
                }
            }

            case 6, 7, 8 -> {
                switch (columnStart) {
                    case 0, 1, 2 -> { return "DINING ROOM"; }
                    case 6, 7, 8 -> { return "?"; }
                    case 12, 13, 14 -> { return "BILLIARD ROOM"; }
                }
            }

            case 12, 13, 14 -> {
                switch (columnStart) {
                    case 0, 1, 2 -> { return "LOUNGE"; }
                    case 6, 7, 8 -> { return "HALL"; }
                    case 12, 13, 14 -> { return "STUDY"; }
                }
            }
        }

        return "Room does not exist.";
    }
}