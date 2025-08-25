package model;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ccwc {
	public static void main(String[] args) {
		try {
			if (!args[0].equals("-c") && !args[0].equals("-l")) {
				throw new InvalidArgumentException("Invalid command line argument! Must be '-c' or '-l'.");
			}

			File file = new File(args[1]);
			Scanner reader = new Scanner(file);

			switch (args[0]) {
				case "-c": {
					System.out.printf("%d %s", file.length(), args[1]);

					break;
				}

				case "-l": {
					int lineCount = 0;

					while (reader.hasNextLine()) {
						reader.nextLine();
						lineCount++;
					}

					reader.close();

					System.out.printf("%d %s", lineCount, args[1]);

					break;
				}

				default: {
					break;
				}
			}
		}

		catch (InvalidArgumentException iae) {
			System.out.println(iae.getMessage());
		}

		catch (FileNotFoundException fnfe) {
			System.out.println("File not found!");
		}
	}
}