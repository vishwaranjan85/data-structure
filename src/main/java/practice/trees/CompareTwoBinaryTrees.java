package practice.trees;

public class CompareTwoBinaryTrees {

	public static void main(String[] args) {
		CompareTwoBinaryTrees search = new CompareTwoBinaryTrees();
		BinaryTree bt1 = new BinaryTree();
		bt1.createSampleTree();
		
		BinaryTree bt2 = new BinaryTree();
		bt2.createSampleTree();
		
		boolean result = search.compareTrees(bt1.root,bt2.root);
		System.out.println(result);
	}
	
	public boolean compareTrees(TreeNode root1, TreeNode root2){
		if(root1==null && root2==null){
			return true;
		}
		if(root1==null || root2==null){
			return false;
		}
		return root1.val==root2.val && compareTrees(root1.left, root2.left)
				&& compareTrees(root1.right, root2.right);
	}

}
