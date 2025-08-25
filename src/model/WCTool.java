package model;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WCTool {
	public static void main(String[] args) {
		File file = new File("test.txt");

		try {
			Scanner reader = new Scanner(file);

			while (reader.hasNextLine()) {
				System.out.println(reader.nextLine());
			}

			reader.close();
		}

		catch(FileNotFoundException fnfe) {
			System.out.println("File not found!");
		}
	}
}