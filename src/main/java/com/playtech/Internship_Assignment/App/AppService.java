package com.playtech.Internship_Assignment.App;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class AppService {

	public static HashMap<String, PlayerData> readPlayerData () {
		String playerDataFilePath = "resources/player_data.txt";
		HashMap<String, PlayerData> fullSessionPlayerData = new HashMap<String, PlayerData>();
		try (BufferedReader reader = new BufferedReader(new FileReader(playerDataFilePath))) {
			String line;
			int i = 0;
			while ((line = reader.readLine()) != null) {
				String[] segments = line.split(",");
				PlayerData tempPlayerData = new PlayerData();
				tempPlayerData.setUserId(segments[0]);
				tempPlayerData.setOperation(segments[1]);
				tempPlayerData.setMatchId(segments[2]);
				tempPlayerData.setCoinNumber(Integer.valueOf(segments[3]));
				if(segments.length == 5) {
					tempPlayerData.setBet(segments[4]);
				}
				fullSessionPlayerData.put("line" + i, tempPlayerData);
				i++;
			}		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fullSessionPlayerData;
	}

	public static HashMap<String, MatchData> readMatchData () {
		String matchDataFilePath = "resources/match_data.txt";
		HashMap<String, MatchData> fullSessionMatchData = new HashMap<String, MatchData>();
		try (BufferedReader reader = new BufferedReader(new FileReader(matchDataFilePath))) {
			String line;
			int i = 0;
			while ((line = reader.readLine()) != null) {
				String[] segments = line.split(",");
				MatchData tempMatchData = new MatchData();
				tempMatchData.setMatchId(segments[0]);
				tempMatchData.setReturnRateA(Float.parseFloat(segments[1]));
				tempMatchData.setReturnRateB(Float.parseFloat(segments[2]));
				tempMatchData.setResult(segments[3]);
				fullSessionMatchData.put("line" + i, tempMatchData);
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fullSessionMatchData;
	}

}
