package wordtree;

import java.io.File;
import java.io.FileNotFoundException;
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
			
			File file = new File("filename.txt");
			Scanner myReader = new Scanner(file);
			
			while (myReader.hasNextLine()) {
				String word = myReader.nextLine();
				
				if (word.length() == 5) {
					//TODO: Add it to list of 5 letter words.
				}
				
			}
			
			myReader.close();
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Can't read the file for some reason\n");
			e.printStackTrace();
			
		}
	}

}
