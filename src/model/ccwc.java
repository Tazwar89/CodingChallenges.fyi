package model;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ccwc {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			Scanner reader;
			String filename = "", command = "";
			long fileLength = 0;

			if (args.length == 2) {
				command = args[0];
				filename = args[1];
			}

			else if (args.length == 1) {
				filename = args[0];
			}

			if (filename.length() != 0) {
				File file = new File(filename);
				reader = new Scanner(file);
				fileLength = file.length();
			}

			else {
				reader = new Scanner(System.in);
			}

			if (!command.equals("-c") && !command.equals("-l") && !command.equals("-w") && !command.equals("-m") && !command.equals("")) {
				throw new InvalidArgumentException("Invalid command line options! Must be '-c', '-l', '-w', '-m', or just filename");
			}

			switch (command) {
				case "-c": {
					System.out.printf("%d %s", fileLength, filename);

					break;
				}

				case "-l": {
					int lineCount = 0;

					while (reader.hasNextLine()) {
						reader.nextLine();
						lineCount++;
					}

					reader.close();

					System.out.printf("%d %s", lineCount, filename);

					break;
				}

				case "-w": {
					int wordCount = 0;

					while (reader.hasNext()) {
						reader.next();
						wordCount++;
					}

					reader.close();

					System.out.printf("%d %s", wordCount, filename);

					break;
				}

				case "-m": {
					BufferedReader read = new BufferedReader(new FileReader(filename));
					int charCount = 0;

					while (read.read() != -1) {
						charCount++;
					}

					read.close();

					System.out.printf("%d %s", charCount, filename);

					break;
				}

				case "": {
					int lineCount = 0;

					while (reader.hasNextLine()) {
						reader.nextLine();
						lineCount++;
					}

					reader.close();

					File file2 = new File(filename);
					Scanner reader2 = new Scanner(file2);
					int wordCount = 0;

					while (reader2.hasNext()) {
						reader2.next();
						wordCount++;
					}

					reader2.close();

					System.out.printf("%d %d %d %s", lineCount, wordCount, fileLength, filename);
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