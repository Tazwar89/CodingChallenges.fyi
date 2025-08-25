package model;

import java.io.File;

public class ccwc {
	public static void main(String[] args) {
		try {
			if (!args[0].equals("-c")) {
				throw new InvalidArgumentException("Invalid command line argument! Must be '-c'.");
			}

			String filename = args[1];
			File file = new File(filename);

			System.out.printf("%d %s", file.length(), filename);
		}

		catch (InvalidArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}
}