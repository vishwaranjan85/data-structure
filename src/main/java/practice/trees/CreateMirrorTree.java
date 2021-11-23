package practice.trees;

public class CreateMirrorTree {
	
	public static void main(String[] args) {
		CreateMirrorTree search = new CreateMirrorTree();
		BinaryTree bt = new BinaryTree();
		bt.createSampleTree();
		
		TreeNode mirror = search.createMirrorTree(bt.root);
		System.out.println(mirror.val);
		System.out.println(mirror.left.val);
		System.out.println(mirror.left.left.val);
		System.out.println(mirror.left.right.val);
		
		System.out.println(mirror.right.val);
		System.out.println(mirror.right.left.val);
		System.out.println(mirror.right.right.val);
	}
	
	public TreeNode createMirrorTree(TreeNode root){
		TreeNode temp = null;
		if(root!=null){
			createMirrorTree(root.left);
			createMirrorTree(root.right);
			
			temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
		return root;
	}
}
