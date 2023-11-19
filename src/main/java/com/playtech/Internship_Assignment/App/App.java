package com.playtech.Internship_Assignment.App;

import java.util.HashMap;

public class App {

	public static void main( String[] args ) {

		HashMap<Integer, MatchData> sessionMatchData = new HashMap<Integer, MatchData>();
		sessionMatchData = DataHandler.readMatchData();

		HashMap<Integer, PlayerData> sessionPlayerData = new HashMap<Integer, PlayerData>();
		sessionPlayerData = DataHandler.readPlayerData();

		GameHandler.letsPlay(sessionMatchData, sessionPlayerData);

	}

}
