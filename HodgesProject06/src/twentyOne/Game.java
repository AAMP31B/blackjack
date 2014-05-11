package twentyOne;

import java.util.ArrayList;

public class Game {

	private int numberOfPlayers;
	private boolean exit=false;
	ArrayList<Player> gamePlayers= new ArrayList<>();
public Game(){
	startGame();
}
	
	public void startGame(){
		do{
		gamePlayers = multiPlayer(getPlayers());	
		Dealer gamedealer = cDealer();	
		playGame(gamePlayers, gamedealer, numberOfPlayers);
		}while(!exit);
	}
	public void endGame(){
		exit=true;
	}
	public int getPlayers(){
		numberOfPlayers=1; // can set this up to ask for user input.
		//Scanner input = new Scanner(System.in);
		//System.out.prinln("How many players?: ");
		//numberOfPlayers =input.nextInt();
		return numberOfPlayers;
	}
	public Player cPlayer(){
		Player player = new Player();
		return player;
	}
	public ArrayList<Player> multiPlayer(int x){
		ArrayList<Player> players = new ArrayList<>();
		for (int i=0;i<x;i++)
		{
			players.add(cPlayer());
		}
		return players;
	}
	public Dealer cDealer(){
		Dealer bob = new Dealer(17);
		return bob;
		}
	public void playGame(ArrayList<Player> players, Dealer dealer, int numPlayers){
		initialDeal(players, dealer, numPlayers);
		updatePlayers(players, dealer, numPlayers);
	
		
	}
	public void initialDeal(ArrayList<Player> players, Dealer dealer, int numPlayers){
		for (int i=0;i<numPlayers;i++)
		{//This loop goes through an array and deals initial cards to each player in the array
			for (int j=0;j<2;j++)//this interior loop makes sure that 2 cards are dealt since this is initial hand
			players.get(i).addCardtoHand(dealer.DealCard());
		}
		for (int i=0;i<2;i++)
			dealer.addCardtoHand(dealer.DealCard());//loops through twice to give the dealer 2 cards
		
	}
	public void updatePlayers(ArrayList<Player> players, Dealer dealer, int numPlayers){
		
	}
	public void PlayAgain(){
		//ask if wants to play again and sets answer to exit boolean
	}
}