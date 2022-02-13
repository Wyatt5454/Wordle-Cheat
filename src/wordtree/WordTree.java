package wordtree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author wyatt
 *
 */
public class WordTree {
	
	private TreeNode root = new TreeNode();
	
	public WordTree(String filename) throws FileNotFoundException {
		
		File readFile = new File(filename);
		
		if(readFile.exists()) {
			buildTree(readFile);
		}
		else {
			System.out.println("File chosen to build WordTree does not exist.");
		}
		
		
		
	}

	private void buildTree(File file) throws FileNotFoundException {
		
		Scanner myReader = new Scanner(file);
		
		while(myReader.hasNext()) {
			root.buildExtendedTreeNodes(myReader.next(), 0);
		}
		
		
		
		myReader.close();
		
	}
}
