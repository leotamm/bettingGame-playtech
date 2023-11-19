package com.playtech.Internship_Assignment.App;

import java.math.BigDecimal;

public class Player {

	//class for handling player data in game session
	private String playerID;
	private boolean playerIsLegitimate;
	private int playerBalance;
	private int wonGames;
	private int placedBets;
	private BigDecimal playerWinRate;

	public String getPlayerID() {
		return playerID;
	}
	public void setPlayerID(String playerID) {
		this.playerID = playerID;
	}
	public boolean isPlayerIsLegitimate() {
		return playerIsLegitimate;
	}
	public void setPlayerIsLegitimate(boolean playerIsLegitimate) {
		this.playerIsLegitimate = playerIsLegitimate;
	}
	public int getPlayerBalance() {
		return playerBalance;
	}	
	public int getWonGames() {
		return wonGames;
	}
	public void setWonGames(int wonGames) {
		this.wonGames = wonGames;
	}
	public int getPlacedBets() {
		return placedBets;
	}
	public void setPlacedBets(int placedBets) {
		this.placedBets = placedBets;
	}
	public void setPlayerBalance(int playerBalance) {
		this.playerBalance = playerBalance;
	}
	public BigDecimal getPlayerWinRate() {
		return playerWinRate;
	}
	public void setPlayerWinRate(BigDecimal playerWinRate) {
		this.playerWinRate = playerWinRate;
	}

}
