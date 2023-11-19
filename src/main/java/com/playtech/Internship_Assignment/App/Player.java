package com.playtech.Internship_Assignment.App;

import java.math.BigDecimal;

public class Player {

	//class for handling player data in game session
	private String playerID;
	private boolean playerIsLegitimate;
	private String illegalMoveLog;
	private long playerBalance;
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
	public String getIllegalMoveLog() {
		return illegalMoveLog;
	}
	public void setIllegalMoveLog(String illegalMoveLog) {
		this.illegalMoveLog = illegalMoveLog;
	}
	public long getPlayerBalance() {
		return playerBalance;
	}	
	public void setPlayerBalance(long playerBalance) {
		this.playerBalance = playerBalance;
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
	public BigDecimal getPlayerWinRate() {
		return playerWinRate;
	}
	public void setPlayerWinRate(BigDecimal playerWinRate) {
		this.playerWinRate = playerWinRate;
	}

	
	public static Player initiateNewPlayer() {
		Player newPlayer = new Player();
		newPlayer.setPlayerID("no user id");
		newPlayer.setPlayerIsLegitimate(true);
		newPlayer.setIllegalMoveLog("");
		newPlayer.setPlayerBalance(0);
		newPlayer.setWonGames(0);
		newPlayer.setPlacedBets(0);
		BigDecimal bd = BigDecimal.ZERO;
		newPlayer.setPlayerWinRate(bd);
		return newPlayer;
	}

}
