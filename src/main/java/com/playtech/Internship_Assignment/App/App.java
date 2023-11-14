package com.playtech.Internship_Assignment.App;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		System.out.println( "Program started..." );

		readInputData();
	}

	public static void readInputData () {

		String playerDataFile = "resources/player_data.txt";

		System.out.println("Reading player data...");

		try (BufferedReader reader = new BufferedReader(new FileReader(playerDataFile))) {
			String line;
			// Read each line from the file until the end is reached
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			// Handle exceptions, such as file not found or unable to read
			e.printStackTrace();
		}
		
		String matchDataFile = "resources/player_data.txt";

		System.out.println("Reading match data...");

		try (BufferedReader reader = new BufferedReader(new FileReader(matchDataFile))) {
			String line;
			// Read each line from the file until the end is reached
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			// Handle exceptions, such as file not found or unable to read
			e.printStackTrace();
		}



	}
}
