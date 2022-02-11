package wordtree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * The purpose of this class is to take the list of all English words and pare
 * it down to 5 letter words. Will keep around in case additional mods are
 * necessary
 * 
 * @author wyatt
 *
 */
public class ListModifier {

	public static void main(String[] args) {

		pareDownList();

	}

	private static void pareDownList() {
		try {
			
			File file = new File("C:\\Users\\wyatt\\eclipse-workspace\\Wordle Cheat\\WordLists\\words_alpha.txt");
			Scanner myReader = new Scanner(file);
			
			FileWriter myWriter = null;
			try {
				myWriter = new FileWriter("C:\\Users\\wyatt\\eclipse-workspace\\Wordle Cheat\\WordLists\\5letterwords.txt");
			} catch (IOException e) {
				e.printStackTrace();
				myReader.close();
				return;
			}

			
			while (myReader.hasNextLine()) {
				String word = myReader.nextLine();
				word = word.toLowerCase();
				
				if (isWordLegit(word)) {
					
					try {
						myWriter.write(word + "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			}
			
			myReader.close();
			try {
				myWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Can't read the file for some reason\n");
			e.printStackTrace();
		}
	}
	
	/*
	 * Matches when the length of the word is 5,
	 * and each character is a letter from a-z.
	 */
	private static boolean isWordLegit(String word) {
		return word.length() == 5 && !word.matches("[^a-z]");
	}

}
