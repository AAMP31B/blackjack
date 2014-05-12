package twentyOne;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		new Game();
		
		//Below was for testing an issue I had with creating ArrayList holding the deck of cards.
		//Apparently even when declared "private ArrayList<Integer> shuffledDeck = new ArrayList<>(52);" the size is still 0 until elements are added.
		//Dealer dealer = new Dealer(17);
		//for (int i=0;i<dealer.getDeck().size();i++)
		//	System.out.println(dealer.DealCard().getFQN());
	}

}
