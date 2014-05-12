package twentyOne;

import java.util.*;

/*
 * extends Player since the Dealer is also a player, only with more methods.
 */
public class Dealer extends Player{

	private ArrayList<Integer> shuffledDeck = ShuffleDeck();
	private int dealCounter=setDealCounter(52);
	public Dealer(int staylvl) {
		super(staylvl);
		
		//setHold(17);//This could bypass the inherited constructor from player and just sets the dealer to stay on 17.
		//Though this can also be ignored/removed if the dealer is always constructed with 17 from calling method.
	}
	
	public ArrayList<Integer> ShuffleDeck(){
		
		ArrayList<Integer> temp = new ArrayList<>(52);
		
		for (int i=0;i<temp.size();i++)
			temp.set(i, i);//populates arraylist with 0-51
		temp = Shuffle(temp);	//calls another shuffling method
		
		return temp;
	}
	
	public ArrayList<Integer> Shuffle(ArrayList<Integer> x){
		Random rng = new Random();
		for (int i=x.size()-1;i>0;i--)
		{	//Fisher-Yates Shuffle implementation
			int index = rng.nextInt(i+1);//picks random number from 0 to i+1 (or i since last num isn't included)
			int temp = x.get(index); // stores the item at the index location in temp variable.
			x.set(index, x.get(i)); //sets item at the random index as the item from the i index
			x.set(i, temp); //sets the randomly chosen variable outside the range of the loop so that it isn't reused.
		}
		return x;
		
	}
	public int setDealCounter(int x){
		dealCounter=x;
		return dealCounter;
	}
	private void decremDealCounter(){
		dealCounter--;
	}
	public int getDealCounter(){
		return dealCounter;
	}
	public Card DealCard(){
	Card newcard = new Card(shuffledDeck.get(dealCounter));
	decremDealCounter();
	return newcard;
			
	}
	
		
	
}
