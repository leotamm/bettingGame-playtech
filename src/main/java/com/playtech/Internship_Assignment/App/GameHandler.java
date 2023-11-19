package com.playtech.Internship_Assignment.App;

import java.util.HashMap;
import java.math.BigDecimal;
import java.util.ArrayList;

public class GameHandler {

	public static void letsPlay (HashMap<Integer, MatchData> incomingMatchData, HashMap<Integer, PlayerData> incomingPlayerData) {

		// tsükkel loeb andmed õiges järjekorras sisse: for(MatchData i : matchData.values())
		HashMap<Integer, MatchData> matchData = new HashMap<Integer, MatchData>();
		matchData = incomingMatchData;

		HashMap<Integer, PlayerData> playerData = new HashMap<Integer, PlayerData>();
		playerData = incomingPlayerData;

		long casinoBalance = 0;
		ArrayList<Player> sessionPlayers = new ArrayList<Player>();
		Player singleEmptyPlayer = Player.initiateNewPlayer();
		sessionPlayers.add(singleEmptyPlayer);

		System.out.println("Start array length:" + sessionPlayers.size());

		String previousUser = "";

		for(PlayerData i : playerData.values()) {

			String thePlayerIdFromData = i.getUserId();
			String theOperationFromData = i.getOperation();
			String theMatchIdFromData = i.getMatchId();
			int theCoinNumberFromData = i.getCoinNumber();
			String theBetFromData = i.getBet();

			Player storedPlayer = sessionPlayers.get(sessionPlayers.size()-1);
			String storedPlayerId = storedPlayer.getPlayerID();
			System.out.println("Fetched id: " + previousUser + " and action " + theOperationFromData + 
					" " + theCoinNumberFromData + " coins");

			Player currentUser = Player.initiateNewPlayer();
			currentUser.setPlayerID(thePlayerIdFromData);
			
			// check if new player in player data log
			// assume and handle only DEPOSIT
			if(!previousUser.equals(thePlayerIdFromData)){

				if(theOperationFromData.equals("DEPOSIT")) {
					currentUser.setPlayerBalance(currentUser.getPlayerBalance()+theCoinNumberFromData);
					System.out.println("New player " + thePlayerIdFromData + " and new balance " + currentUser.getPlayerBalance());				
				}
				sessionPlayers.add(currentUser);				

				//			System.out.println("User: " + thePlayerId + " Operation: " + theOperation + 
				//					" Match: " + theMatchId + " Coins: " + theCoinNumber + " Bet: " + theBet + " counter:" +playerCounter);
			
			}
			
			// handle same player other actions after DEPOSIT
			if(previousUser.equals(thePlayerIdFromData)) {
				
				if(theOperationFromData.equals("DEPOSIT")) {
					int initialBalance = (int) currentUser.getPlayerBalance();
					long newBalance = initialBalance + theCoinNumberFromData;
					currentUser.setPlayerBalance(newBalance);
					System.out.println("Same player, initial balance " + initialBalance + " new DEPOSIT " + theCoinNumberFromData + " new BALANCE" + currentUser.getPlayerBalance());
				}
				System.out.println("Same player, different action");
			}
			
			
			previousUser = thePlayerIdFromData;
			
		}


		System.out.println("End array length:" + sessionPlayers.size());
		
		for(int i = 1; i < sessionPlayers.size(); i++) {
			Player player = sessionPlayers.get(i);
			long balance = player.getPlayerBalance();
			System.out.println("Balance: " + balance);
		}
		
		System.out.println("Gamehandler closed");

	}

}
