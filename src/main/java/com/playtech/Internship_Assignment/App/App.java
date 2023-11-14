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
		
		System.out.println( "Program executed" );
	}

	public static void readInputData () {

		String playerDataFilePath = "resources/player_data.txt";

		System.out.println("Reading player data...");

		try (BufferedReader reader = new BufferedReader(new FileReader(playerDataFilePath))) {
			String line;
			// Read each line from the file until the end is reached
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			// Handle exceptions, such as file not found or unable to read
			e.printStackTrace();
		}
		
		String matchDataFilePath = "resources/player_data.txt";

		System.out.println("Reading match data...");

		try (BufferedReader reader = new BufferedReader(new FileReader(matchDataFilePath))) {
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
