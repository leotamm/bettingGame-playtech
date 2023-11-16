package com.playtech.Internship_Assignment.App;

import java.math.BigDecimal;

public class Player {

	private String playerID;
	private boolean playerIsLegitimate;
	private int playerBalance;
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
