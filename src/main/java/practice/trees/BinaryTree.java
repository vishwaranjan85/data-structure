package practice.trees;

public class BinaryTree {
	public TreeNode root;
	
	public BinaryTree(){
		
	}
	
	public void createSampleTree(){
		root = new TreeNode(1);
		root.left = new TreeNode(2, new TreeNode(4),new TreeNode(5));
		root.right = new TreeNode(3, new TreeNode(6),new TreeNode(7));
	}
	
	public void createSampleTree1(){
		root = new TreeNode(2);
		root.left = new TreeNode(1, null,null);
		root.right = new TreeNode(4, new TreeNode(3),null);
	}
}
