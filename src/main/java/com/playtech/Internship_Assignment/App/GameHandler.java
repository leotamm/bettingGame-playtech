package com.playtech.Internship_Assignment.App;

import java.util.HashMap;

public class GameHandler {

	public static void letsPlay (HashMap<Integer, MatchData> incomingMatchData, HashMap<Integer, PlayerData> incomingPlayerData) {

		Game game = new Game();
		game.setCasinoBalance(0);
		
		HashMap<Integer, MatchData> matchData = new HashMap<Integer, MatchData>();
		matchData = incomingMatchData;

		// loeb kenasti õiges järjekorras!
		System.out.println("Saved match data:");
		for(MatchData i : matchData.values()) {
			String theMatchId = i.getMatchId();
			System.out.println(theMatchId);
		}
		
		HashMap<Integer, PlayerData> playerData = new HashMap<Integer, PlayerData>();
		playerData = incomingPlayerData;
		
		System.out.println("Saved player data:");
		for(PlayerData i : playerData.values()) {
			String thePlayerId = i.getUserId();
			System.out.println(thePlayerId);
		}
		
		System.out.println("Well played!");
		
	}

}
