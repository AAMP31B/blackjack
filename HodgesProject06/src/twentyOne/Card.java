package twentyOne;

public class Card {

	private int cardID;
	final int maxSuit = 13;
	private String suit;
	private String rank;
	private int cardValue=0;
	private String cardFullName;
	
	
	public Card(int x){
		cardID=x;
		getFQN();
	}
	
	public String getRank(){ //gets String rank and sets int cardValue
		int rankMod = cardID % maxSuit;
		String tempRank = null;
		switch (rankMod)
		{
		case 0:		tempRank = "Ace";	cardValue=11;	break;
		case 1:		tempRank = "Two";	cardValue=2;	break;
		case 2:		tempRank = "Three";	cardValue=3;	break;
		case 3:		tempRank = "Four";	cardValue=4;	break;
		case 4:		tempRank = "Five";	cardValue=5;	break;
		case 5:		tempRank = "Six";	cardValue=6;	break;
		case 6:		tempRank = "Seven";	cardValue=7;	break;
		case 7:		tempRank = "Eight";	cardValue=8;	break;
		case 8:		tempRank = "Nine";	cardValue=9;	break;
		case 9:		tempRank = "Ten";	cardValue=10;	break;
		case 10:	tempRank = "Jack";	cardValue=10;	break;
		case 11:	tempRank = "Queen";	cardValue=10;	break;
		case 12:	tempRank = "King";	cardValue=10;	break;
		}
		return tempRank;
	}
	public String getSuit(){
		String tempSuit = null;
		if ((cardID>=0)&&(cardID<=12))
			tempSuit = "Clubs";
		else if ((cardID>=13)&&(cardID<=25))
			tempSuit = "Diamonds";
		else if ((cardID>=26)&&(cardID<=38))
			tempSuit = "Hearts";
		else if ((cardID>=39)&&(cardID<=51))
			tempSuit = "Spades";
		return tempSuit;
	}
	public int getValue21(){
		if (cardValue>0)
			return cardValue;
		else if (cardValue==0)
			getRank();
			return cardValue;
	}
	public int changeAce(){
		if ((cardValue==11)&&(rank.equalsIgnoreCase("Ace")))
			cardValue=1;
		return cardValue;
	}
	public String getFQN(){
		rank = getRank();
		suit = getSuit();
		cardFullName = rank+" of "+suit;
		return cardFullName;
	}
}

