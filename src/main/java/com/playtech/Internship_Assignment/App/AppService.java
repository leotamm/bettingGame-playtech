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
				//System.out.print("Line " + i + " ja segmente: " + segments.length + " ");
				PlayerData tempPlayerData = new PlayerData();
				tempPlayerData.setUserId(segments[0]);
				//System.out.print("1:" + segments[0] + " ");
				tempPlayerData.setOperation(segments[1]);
				//System.out.print("2:" + segments[1] + " ");
				tempPlayerData.setMatchId(segments[2]);
				//System.out.print("3:" + segments[2] + " ");
				tempPlayerData.setCoinNumber(Integer.valueOf(segments[3]));
				//System.out.print("4:" + segments[3] + " ");
				if(segments.length == 5) {
					tempPlayerData.setBet(segments[4]);
					//System.out.print("5:" + segments[4] + " ");
				}
				fullSessionPlayerData.put("line " + i, tempPlayerData);
				i++;
				//System.out.println();
			}		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fullSessionPlayerData;
	}


	public static void readMatchData () {

		String matchDataFilePath = "resources/match_data.txt";

		System.out.println("Reading match data...");

		try (BufferedReader reader = new BufferedReader(new FileReader(matchDataFilePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
