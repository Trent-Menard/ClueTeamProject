package game;

public class Card {
	
	private String category;
	private String cardName;

	public Card(String cardName, String category) 
	{
		this.category = category;
		this.cardName = cardName;
		
	}
	
	public String getCategory()
	{
		return category;
	}
	public String getCardName()
	{
		return cardName;
	}
	
}
