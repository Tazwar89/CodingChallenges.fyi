package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;

public class WCTool {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String filename = "", command = "";

		// Argument parsing
		if (args.length > 0 && args[0].startsWith("-")) {
			command = args[0];

			if (args.length > 1)
				filename = args[1];
		}

		else if (args.length > 0)
			filename = args[0];

		try {
			// Decide if source is file or standard input
			InputStream is = filename.isEmpty() ? System.in : new FileInputStream(filename);

			long byteCount, lineCount, wordCount, charCount;
			byteCount = lineCount = wordCount = charCount = 0;

			// Read everything at once to support all flags, since System.in cannot be read twice
			byte[] allBytes = is.readAllBytes();
			byteCount = allBytes.length;

			String content = new String(allBytes);
			charCount = content.length();

			if (byteCount > 0)
				lineCount = content.split("\r\n|\r\n", -1).length - 1;

			StringTokenizer st = new StringTokenizer(content);
			wordCount = st.countTokens();
			
			switch (command) {
				case "-c": {
					System.out.printf("%d %s\n", byteCount, filename);
					break;
				}

				case "-l": {
					System.out.printf("%d %s\n", lineCount, filename);
					break;
				}

				case "-w": {
					System.out.printf("%d %s\n", wordCount, filename);
					break;
				}

				case "-m": {
					System.out.printf("%d %s\n", charCount, filename);
					break;
				}

				case "": {
					System.out.printf("%d %d %d %s\n", lineCount, wordCount, byteCount, filename);
					break;
				}
			}

			if (is != System.in)
				is.close();
		}

		catch (FileNotFoundException fnfe) {
			System.out.println("File not found!");
		}

		catch (IOException ioe) {
			System.out.println("File could not be read!");
		}
	}
}