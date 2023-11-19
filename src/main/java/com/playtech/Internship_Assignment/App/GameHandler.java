package com.playtech.Internship_Assignment.App;

import java.util.HashMap;
import java.util.ArrayList;

public class GameHandler {

	public static void letsPlay (HashMap<Integer, MatchData> incomingMatchData, HashMap<Integer, PlayerData> incomingPlayerData) {

		// get match and game data log
		HashMap<Integer, MatchData> matchData = new HashMap<Integer, MatchData>();
		matchData = incomingMatchData;
		HashMap<Integer, PlayerData> playerData = new HashMap<Integer, PlayerData>();
		playerData = incomingPlayerData;

		// calculate user count and get the unique id-s from player data object
		int playerCounter = 0;
		ArrayList<String> playerIdList = new ArrayList<String>();
		String previousId = "";
		for(Integer i : playerData.keySet()) {
			PlayerData thisPlayer = playerData.get(i);
			String thisUserId = thisPlayer.getUserId();
			if(!previousId.equals(thisUserId)) {
				playerCounter++;
				playerIdList.add(thisUserId);
				previousId = thisUserId;
			}
		}

		// initiate casino balance
		long casinoBalance = 0;

		// create player map populate it once a player id changes or at the last loop iteration
		HashMap<Integer, Player> sessionPlayers = new HashMap<Integer, Player>();

		int playerCounterForMapKey = 0;
		String previousUserId = playerIdList.get(playerCounterForMapKey);
		Player currentPlayer = new Player();
		currentPlayer = Player.initiateNewPlayer();

		int loopCounter = 0;
		for(PlayerData i : playerData.values()) {

			String thePlayerIdFromData = i.getUserId();
			String theOperationFromData = i.getOperation();
			String theMatchIdFromData = i.getMatchId();
			int theCoinNumberFromData = i.getCoinNumber();
			String theBetFromData = i.getBet();

			System.out.println("Log: " + thePlayerIdFromData + " and action " + theOperationFromData + 
					" " + theCoinNumberFromData + " coins");

			if(thePlayerIdFromData.equals(previousUserId)) {

				// ACTIONS
				if(theOperationFromData.equals("DEPOSIT")) {
					currentPlayer.setPlayerBalance(currentPlayer.getPlayerBalance()+theCoinNumberFromData);
					System.out.println("Action: Deposit for " + thePlayerIdFromData + " and the new balance " + 
							currentPlayer.getPlayerBalance());				
				}
				
				if(theOperationFromData.equals("BET")) {
					String currentMacthId = "";
					String currentResult = "";
					float currentRateA = 0L;
					float currentRateB = 0L;
					float win = 0L;
					for(MatchData j : matchData.values()) {
						String theMatchId = j.getMatchId();
						if(theMatchIdFromData.equals(theMatchId)) {
							currentMacthId = j.getMatchId();
							currentRateA = j.getReturnRateA();
							currentRateB = j.getReturnRateB();
							currentResult = j.getResult();
						}
					}
					// check if legal move
					if(theCoinNumberFromData <= currentPlayer.getPlayerBalance()) {
						// handle winning condition
						if(theBetFromData.equals(currentResult)) {
							if (currentResult.equals("A")) {
								win = theCoinNumberFromData * currentRateA;
								System.out.println("WIN: " + win);
								int newBalance = (int) (currentPlayer.getPlayerBalance()+win);
								currentPlayer.setPlayerBalance(newBalance);
								currentPlayer.setWonGames(currentPlayer.getWonGames()+1);
							}
							if(currentResult.equals("B")) {
								win = theCoinNumberFromData * currentRateB;
								System.out.println("WIN: " + win);
								int newBalance = (int) (currentPlayer.getPlayerBalance()+win);
								currentPlayer.setPlayerBalance(newBalance);
								currentPlayer.setWonGames(currentPlayer.getWonGames()+1);
							}
						} 
						// handle loosing condition
						else {
							System.out.println("LOOSE: " + theCoinNumberFromData);
							currentPlayer.setPlayerBalance(currentPlayer.getPlayerBalance()-theCoinNumberFromData);
							casinoBalance += theCoinNumberFromData;
							System.out.println("Casino balance: " + casinoBalance);
						}
						currentPlayer.setPlacedBets(currentPlayer.getPlacedBets()+1);

					} else {
						currentPlayer.setPlayerIsLegitimate(false);
						if(currentPlayer.getIllegalMoveLog().length() == 0) {				// TODO - get the right values in!
							String log = currentPlayer.getPlayerID() + " " + theOperationFromData + " " + currentMacthId + 
									" " +  theCoinNumberFromData + " " + currentResult;
							currentPlayer.setIllegalMoveLog(log);
						}
						System.out.println("Illegal action - too large bet");
					}

				}

				if(theOperationFromData.equals("WITHDRAW")) {
					// check if legal move
					if(currentPlayer.getPlayerBalance() - theCoinNumberFromData > 0) {
						currentPlayer.setPlayerBalance(currentPlayer.getPlayerBalance()-theCoinNumberFromData);
						System.out.println("Action: Withdrawal for " + thePlayerIdFromData + " and the new balance " + 
								currentPlayer.getPlayerBalance());
					} else {
						currentPlayer.setPlayerIsLegitimate(false);
						if(currentPlayer.getIllegalMoveLog().length() == 0) {
							String log = currentPlayer.getPlayerID() + " " + theOperationFromData + " null " + " " +  
									theCoinNumberFromData + " null ";
							currentPlayer.setIllegalMoveLog(log);
						}
						System.out.println("Illegal action - too large withdrawal");
					}
				}
				if(loopCounter == playerData.size()-1) {
					sessionPlayers.put(playerCounterForMapKey, currentPlayer);
				}
				System.out.println("Info: Player balance is now " + currentPlayer.getPlayerBalance());

			} else {
				// SAVE and change current player
				sessionPlayers.put(playerCounterForMapKey, currentPlayer);
				playerCounterForMapKey++;
				previousUserId = playerIdList.get(playerCounterForMapKey);
				currentPlayer = new Player();
				currentPlayer = Player.initiateNewPlayer();

				if(theOperationFromData.equals("DEPOSIT")) {
					currentPlayer.setPlayerBalance(currentPlayer.getPlayerBalance()+theCoinNumberFromData);
					System.out.println("Action: Deposit for " + thePlayerIdFromData + " and the new balance " + 
							currentPlayer.getPlayerBalance());				
				}
				
				if(theOperationFromData.equals("WITHDRAW")) {
					if(currentPlayer.getPlayerBalance() - theCoinNumberFromData > 0) {
						currentPlayer.setPlayerBalance(currentPlayer.getPlayerBalance()-theCoinNumberFromData);
						System.out.println("Action: Withdrawal for " + thePlayerIdFromData + " and the new balance " + 
								currentPlayer.getPlayerBalance());
					} else {
						currentPlayer.setPlayerIsLegitimate(false);
						if(currentPlayer.getIllegalMoveLog().length() == 0) {
							String log = currentPlayer.getPlayerID() + " " + theOperationFromData + " null " +  
									theCoinNumberFromData + " null";
							currentPlayer.setIllegalMoveLog(log);
						}
						System.out.println("Illegal action - too large withdrawal");
					}
				}
				System.out.println("Info: Player balance is now " + currentPlayer.getPlayerBalance());

			}
			loopCounter++;

		}

	}

}

