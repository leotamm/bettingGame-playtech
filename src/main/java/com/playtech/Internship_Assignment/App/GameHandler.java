package com.playtech.Internship_Assignment.App;

import java.util.HashMap;
import java.util.ArrayList;

public class GameHandler {

	public static void letsPlay (HashMap<Integer, MatchData> incomingMatchData, HashMap<Integer, PlayerData> incomingPlayerData) {

		Game game = new Game();
		game.setCasinoBalance(0);
		ArrayList<Player> emptyPlayerList = new ArrayList<Player>();
		Player singleEmptyPlayer = new Player();
		emptyPlayerList.add(singleEmptyPlayer);
		game.setPlayers(emptyPlayerList);
		game.setLegitimatePlayers(emptyPlayerList);
		game.setIllegitimatePlayers(emptyPlayerList);

		HashMap<Integer, MatchData> matchData = new HashMap<Integer, MatchData>();
		matchData = incomingMatchData;

		// loeb kenasti õiges järjekorras!
//		System.out.println("Saved match data:");
//		for(MatchData i : matchData.values()) {
//
//			String theMatchId = i.getMatchId();
//			System.out.println(theMatchId);
//		}

		HashMap<Integer, PlayerData> playerData = new HashMap<Integer, PlayerData>();
		playerData = incomingPlayerData;

		System.out.println("Saved player data:");
		for(PlayerData i : playerData.values()) {


//			Player[] thePlayers = game.getPlayers();
//
//			if(thePlayers.length == 0) {
//				thePlayers.add(null);

				String thePlayerId = i.getUserId();
				String theOperation = i.getOperation();
				String theMatchId = i.getMatchId();
				int theCoinNumber = i.getCoinNumber();
				String theBet = i.getBet();
				
//				System.out.println("User: " + thePlayerId + " Operation: " + theOperation + 
//						" Match: " + theMatchId + " Coins: " + theCoinNumber + " Bet: " + theBet);
				
				System.out.println("Comparing user " + thePlayerId + " and length of active player list: " + game.getPlayers().size());
			}

			System.out.println("Well played!");

		}

	}
