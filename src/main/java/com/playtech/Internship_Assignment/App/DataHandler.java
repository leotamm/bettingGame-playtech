package com.playtech.Internship_Assignment.App;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class DataHandler {

	public static HashMap<Integer, PlayerData> readPlayerData () {
		HashMap<Integer, PlayerData> fullSessionPlayerData = new HashMap<Integer, PlayerData>();
		try (BufferedReader reader = new BufferedReader(new FileReader("resources/player_data.txt"))) {
			String line;
			String tempPlayerId = "";
			int i = 0;
			while ((line = reader.readLine()) != null) {
				String[] segments = line.split(",");
				PlayerData tempPlayerData = new PlayerData();
				tempPlayerData.setUserId(segments[0]);
				tempPlayerData.setOperation(segments[1]);
				tempPlayerData.setMatchId(segments[2]);
				tempPlayerData.setCoinNumber(Integer.parseInt(segments[3]));
				if(segments.length == 5) {
					tempPlayerData.setBet(segments[4]);
				}
				if(!segments[0].equals(tempPlayerId)) {
					tempPlayerId = segments[0];
				}
				fullSessionPlayerData.put(i, tempPlayerData);
				i++;
			}		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fullSessionPlayerData;
	}

	public static HashMap<Integer, MatchData> readMatchData () {
		HashMap<Integer, MatchData> fullSessionMatchData = new HashMap<Integer, MatchData>();
		try (BufferedReader reader = new BufferedReader(new FileReader("resources/match_data.txt"))) {
			String line;
			int i = 0;
			while ((line = reader.readLine()) != null) {
				String[] segments = line.split(",");
				MatchData tempMatchData = new MatchData();
				tempMatchData.setMatchId(segments[0]);
				tempMatchData.setReturnRateA(Float.parseFloat(segments[1]));
				tempMatchData.setReturnRateB(Float.parseFloat(segments[2]));
				tempMatchData.setResult(segments[3]);
				fullSessionMatchData.put(i, tempMatchData);
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fullSessionMatchData;
	}

}
