package twentyOne;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	private int numberOfPlayers;
	private boolean exit=false;
	ArrayList<Player> gamePlayers;
	String winner;
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
		ArrayList<Player> players = new ArrayList<>(x);
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
		checkForWin(players,dealer,numPlayers);
		while (winner.equals(null)){
			moreDeals(players, dealer, numPlayers);
		}
		PlayAgain();
		
	}
	private void moreDeals(ArrayList<Player> players, Dealer dealer, int numPlayers) {
		for (int i=0;i<numPlayers;i++)
		{
			if (players.get(i).hitMe())
			{
				players.get(i).addCardtoHand(dealer.DealCard());
				
				
			}
			if (dealer.hitMe())
				dealer.addCardtoHand(dealer.DealCard());
			updatePlayers(players, dealer, numPlayers);
			checkForWin(players, dealer, numPlayers);
		}
		
	}

	private void checkForWin(ArrayList<Player> players, Dealer dealer,
			int numPlayers) {
		for (int i=0;i<numPlayers;i++){
			if ((players.get(i).getHandCount()>=players.get(i).getHold())&&(dealer.getHandCount()>=dealer.getHold()))
			{
				for (int j=0;j<numPlayers;j++)
				{
					Resolver resolve = new Resolver(dealer, players.get(j));
					winner=resolve.getWinner();
					announceWinner(resolve.returnPlayer(), dealer, numPlayers);
				}
			}
			else
				break;
		}
	}
private void announceWinner(Player player, Dealer dealer, int numPlayers){
	System.out.println(winner);
	System.out.println("The dealer had: "+ dealer.getHandCount()+" consisting of: ");
	dealer.showHand();
	System.out.println();
	System.out.println("The player had: "+ player.getHandCount()+" consisting of: ");
	player.showHand();
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
		for (int i=0;i<numPlayers;i++)
		{
			players.get(i).runLogic();
		}
		dealer.runLogic();
	}
	public void PlayAgain(){
		System.out.print("Do you wish to play again? Y or N");
		Scanner input = new Scanner(System.in);
		String answer = input.next();
		if (answer.equalsIgnoreCase("n"))
			exit=true;
		
	}
}