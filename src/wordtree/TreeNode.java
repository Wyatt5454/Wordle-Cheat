/**
 * 
 */
package wordtree;

import java.util.ArrayList;

/**
 * Holds a letter which represents a branch traversal, and the 
 * list of nodes.
 * 
 * @author wyatt
 *
 */
public class TreeNode {
	
	private char letter;
	private ArrayList<TreeNode> nodes = new ArrayList<>();
	
	private boolean isRoot = false;
	private boolean isLeaf = false;
	
	public TreeNode() {
		this.isRoot = true;
	}
	
	public TreeNode(char letter, boolean isLeaf) {
		this.setLetter(letter);
		this.isLeaf = isLeaf;
	}
	
	/**
	 * Used to build additional TreeNodes if they are
	 * necessary to build.  Calls itself until we've 
	 * built the TreeNode for the 5th letter.
	 * @param word
	 * @param position
	 */
	public void buildExtendedTreeNodes(String word, int position) {
		
		// Quit the loop when we get to the 5th letter
		if (position > 4) {
			return;
		}
		
		// Check the next letter we need to make a node for
		char nextLetter = word.charAt(position);
		
		// Check to see if the letter already exists here.
		for ( TreeNode node : nodes ) {
			// No need to build a TreeNode if one already exists
			if (nextLetter == node.getLetter() ) {
				node.buildExtendedTreeNodes(word, ++position);
				return;
			}
		}
		
		// Here we know the next letter needs a new TreeNode
		TreeNode nextNode = new TreeNode(nextLetter, false);
		nodes.add(nextNode);
		nextNode.buildExtendedTreeNodes(word, ++position);
		
		
		return;
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public ArrayList<TreeNode> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<TreeNode> nodes) {
		this.nodes = nodes;
	}

	public boolean isRoot() {
		return isRoot;
	}

	public boolean isLeaf() {
		return isLeaf;
	}
}
