package game;

import javax.swing.JButton;

import game.BoardPanel;

public class Room {
	private BoardPanel boardPanel;
	
	String roomName;
	int rowStart;
	int rowEnd;
	int columnStart;
	int columnEnd;
	

	public Room(int rowStart, int columnStart )
	{
		
		this.rowStart = rowStart ;
		this.columnStart = columnStart ;
		
	}
//	public boolean roomOccupied()
//	{
//		return true;
//	}
	public int getRowStart()
	{
		return rowStart;
		
	}
	
	public int getColumnStart()
	{
		return columnStart;
		
	}
	
	public void setRowStart(int rowStart)
	{
		this.rowStart = rowStart;
	
	}
	public void setColumnStart(int columnStart)
	{
		this.columnStart = columnStart;
		
	}
	
	public String getRoomName()
	{
		    String roomName;

		    switch (rowStart) {
		        case 0:
		            switch (columnStart) {
		                case 0:
		                    roomName = "KITCHEN";
		                    break;
		                case 6:
		                    roomName = "BALLROOM";
		                    break;
		                case 12:
		                    roomName = "CONSERVATORY";
		                    break;
		                default:
		                    roomName = "Room Name not found";
		                    break;
		            }
		            break;

		        case 6:
		            switch (columnStart) {
		                case 0:
		                    roomName = "DINING ROOM";
		                    break;
		                case 6:
		                    roomName = "ROOM NAME HERE"; // Replace with the actual room name
		                    break;
		                case 12:
		                    roomName = "BILLARD ROOM";
		                    break;
		                default:
		                    roomName = "Room Name not found";
		                    break;
		            }
		            break;

		        case 12:
		            switch (columnStart) {
		                case 0:
		                    roomName = "LOUNGE";
		                    break;
		                case 6:
		                    roomName = "HALL";
		                    break;
		                case 12:
		                    roomName = "STUDY";
		                    break;
		                default:
		                    roomName = "Room Name not found";
		                    break;
		            }
		            break;

		        default:
		            roomName = "Room Name not found";
		            break;
		    }

		    return roomName;
		}
	
	

}
