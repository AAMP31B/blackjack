package twentyOne;

public class Resolver {

private Boolean dealerWin;
private Boolean playerWin;
private Player storage;

public Resolver(Dealer deal, Player play){
	decideWinner(deal, play);//This method decides the winner when the class is constructed
}
	
public void decideWinner(Dealer deal, Player play)
//This could be done with a switch statement might change it over later
{
	if ((deal.checkBust())&&(play.checkBust()))
	{
		setDealerWin(false);
		setPlayerWin(false);
	}
	else if ((!deal.checkBust())&&play.checkBust())
	{
		setDealerWin(true);
		setPlayerWin(false);
	}
	else if ((deal.checkBust())&&!play.checkBust())
	{
		setDealerWin(false);
		setPlayerWin(true);
		storage=play;
	}
	else if ((!deal.checkBust())&&!play.checkBust())
		{
			if (deal.getHandCount()>=play.getHandCount())
		
			{
				setDealerWin(true);
				setPlayerWin(false);
			}
			else if (deal.getHandCount()<play.getHandCount())
			{
				setDealerWin(false);
				setPlayerWin(true);
				storage = play;
			}
		}
	}

public String getWinner(){
	String winner = null;
	if (setDealerWin(true))
		winner = "Dealer wins";
	if (setPlayerWin(true))
		winner = "Player wins";
	return winner;
}

public Boolean getDealerWin() {
	return dealerWin;
}

public Boolean setDealerWin(Boolean dealerWin) {
	this.dealerWin = dealerWin;
	return dealerWin;
}

public Boolean getPlayerWin() {
	return playerWin;
}

public Boolean setPlayerWin(Boolean playerWin) {
	this.playerWin = playerWin;
	return playerWin;
}
public Player returnPlayer(){
	return storage;
}
}
