package model;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ccwc {
	public static void main(String[] args) {
		try {
			if (!args[0].equals("-c") && !args[0].equals("-l") && !args[0].equals("-w") && !args[0].equals("-m")) {
				throw new InvalidArgumentException("Invalid command line argument! Must be '-c', '-l', '-w', or '-m.");
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

				case "-w": {
					int wordCount = 0;

					while (reader.hasNext()) {
						reader.next();
						wordCount++;
					}

					reader.close();

					System.out.printf("%d %s", wordCount, args[1]);

					break;
				}

				case "-m": {
					BufferedReader read = new BufferedReader(new FileReader(args[1]));
					int charCount = 0;

					while (read.read() != -1) {
						charCount++;
					}

					read.close();

					System.out.printf("%d %s", charCount, args[1]);

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

		catch (IOException ioe) {
			System.out.println("File could not be read!");
		}
	}
}