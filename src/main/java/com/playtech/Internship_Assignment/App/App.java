package com.playtech.Internship_Assignment.App;

import com.playtech.Internship_Assignment.App.AppService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class App 
{
	public static void main( String[] args )
	{
		HashMap<String, PlayerData> sessionPlayerData = new HashMap<String, PlayerData>();
		sessionPlayerData = AppService.readPlayerData();
		
		System.out.println("Leotud ridu: " + sessionPlayerData.size());
		
		//sessionPlayerData.forEach((key, value) -> System.out.println(value.getUserId()));
		
		//AppService.readMatchData();
		//writeToFile();

	}

	
	

	public static void writeToFile () {

		String[] dataArray = {"Line 1", "Line 2", "Line 3", "Line 4"};

		// TODO: use Stringbuilder to covert the final data into String format
		String inputString = "empty string";

		// Get the current working directory
		String currentDirectory = System.getProperty("user.dir");

		System.out.println("Located directory: " + currentDirectory);

		// Create a Path for the file in the current directory
		Path filePath = Paths.get(currentDirectory, "result.txt");

		// Write data to the file           
		// Files.write(filePath, dataArray);

		System.out.println("Data written to file: " + filePath);
	}
}
