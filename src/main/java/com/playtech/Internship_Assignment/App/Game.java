package com.playtech.Internship_Assignment.App;

import java.util.ArrayList;

public class Game {

	private int casinoBalance;
	private ArrayList<Player> players;
	private ArrayList<Player> legitimatePlayers;
	private ArrayList<Player> illegitimatePlayers;
	
	public int getCasinoBalance() {
		return casinoBalance;
	}
	public void setCasinoBalance(int casinoBalance) {
		this.casinoBalance = casinoBalance;
	}
	public ArrayList<Player> getPlayers() {
		return players;
	}
	public void setPlayers(ArrayList<Player> emptyPlayerList) {
		this.players = emptyPlayerList;
	}
	public ArrayList<Player> getLegitimatePlayers() {
		return legitimatePlayers;
	}
	public void setLegitimatePlayers(ArrayList<Player> emptyPlayerList) {
		this.legitimatePlayers = emptyPlayerList;
	}
	public ArrayList<Player> getIllegitimatePlayers() {
		return illegitimatePlayers;
	}
	public void setIllegitimatePlayers(ArrayList<Player> emptyPlayerList) {
		this.illegitimatePlayers = emptyPlayerList;
	}
	
}
