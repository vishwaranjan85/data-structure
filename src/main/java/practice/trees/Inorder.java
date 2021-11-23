package practice.trees;

import java.util.Stack;

public class Inorder {

	public static void main(String[] args) {
		Inorder io = new Inorder();
		BinaryTree bt = new BinaryTree();
		bt.createSampleTree();
		
		io.inorderNonRecursive(bt.root);

	}
	
	public void inorderRecursive(TreeNode root){
		
		if(root==null){
			return;
		}
		inorderRecursive(root.left);
		System.out.println(root.val);
		inorderRecursive(root.right);
	}
	
	public void inorderNonRecursive(TreeNode root){
		Stack<TreeNode> stack = new Stack<>(); 
		while(true){
			while(root!=null){
				stack.push(root);
				root = root.left;
			}
			if(stack.isEmpty()){
				break;
			}
			root = stack.pop();
			System.out.println(root.val);
			root = root.right;
		}
	}
}
