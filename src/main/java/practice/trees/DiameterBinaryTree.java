package practice.trees;

public class DiameterBinaryTree {

	public static void main(String[] args) {
		DiameterBinaryTree search = new DiameterBinaryTree();
		BinaryTree bt = new BinaryTree();
		bt.createSampleTree();
		
		int count = search.diameter(bt.root,0);
		System.out.println(count);

	}
	
	public int diameter(TreeNode root, int ptr){
		int left, right=0;
		if(root==null){
			return 0;
		}
		
		left = diameter(root.left,ptr);
		right = diameter(root.right,ptr);
		
		if(left+right > ptr){
			ptr = left+right;
		}
		return Math.max(left,right)+1;
	}

}
