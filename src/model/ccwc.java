package model;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ccwc {
	public static void main(String[] args) {
		try {
			if (!args[0].equals("-c")) {
				throw new InvalidArgumentException("Invalid command line argument! Must be '-c'.");
			}

			File file = new File("test.txt");
			Scanner reader = new Scanner(file);

			while (reader.hasNextLine()) {
				System.out.println(reader.nextLine());
			}

			reader.close();
		}

		catch (InvalidArgumentException iae) {
			System.out.println(iae.getMessage());
		}

		catch (FileNotFoundException fnfe) {
			System.out.println("File not found!");
		}
	}
}