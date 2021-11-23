package practice.trees;

import java.util.ArrayList;
import java.util.List;

public class IncreasingBST {

	public static void main(String[] args) {
		IncreasingBST search = new IncreasingBST();
		BinaryTree bt = new BinaryTree();
		bt.createSampleTree1();
		
		search.increasingBST(bt.root);

	}

	public TreeNode increasingBST(TreeNode root) {
		List<TreeNode> output = new ArrayList<>();
		inOrder(root, output);
		for (int i = 0; i < output.size() - 1; i++) {
			output.get(i).left = null;
			output.get(i + 1).left = null;
			output.get(i + 1).right = null;
			output.get(i).right = output.get(i + 1);
		}

		return output.get(0);
	}

	private void inOrder(TreeNode root, List<TreeNode> output) {
		if (root == null) {
			return;
		}
		inOrder(root.left, output);
		output.add(root);
		inOrder(root.right, output);
	}

}
