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
