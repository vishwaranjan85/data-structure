package practice.trees;

import java.util.Stack;

public class Preorder {
	
	public static void main(String[] args){
		Preorder po = new Preorder();
		BinaryTree bt = new BinaryTree();
		bt.createSampleTree();
		
		po.preorderNonRecursive(bt.root);
	}
	
	public void preorderRecursive(TreeNode root){
		if(root==null){
			return;
		}
		System.out.println(root.val);
		preorderRecursive(root.left);
		preorderRecursive(root.right);
	}
	
	public void preorderNonRecursive(TreeNode root){
		Stack<TreeNode> stack = new Stack<>();
		
		while(true){
			while(root!=null){
				System.out.println(root.val);
				stack.push(root);
				root = root.left;
			}
			if(stack.isEmpty()){
				break;
			}
			root = stack.pop();
			root = root.right;
		}
	}
}
