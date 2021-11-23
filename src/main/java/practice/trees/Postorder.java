package practice.trees;

import java.util.Stack;

public class Postorder {

	public static void main(String[] args) {
		Postorder po = new Postorder();
		BinaryTree bt = new BinaryTree();
		bt.createSampleTree();
		
		po.postorderNonRecursive(bt.root);
	}
	
	public void postorderRecursive(TreeNode root){
		if(root==null){
			return;
		}
		postorderRecursive(root.left);
		postorderRecursive(root.right);
		System.out.println(root.val);
	}
	
	public void postorderNonRecursive(TreeNode root){
		Stack<TreeNode> stack = new Stack<>();
		TreeNode previous = null;
		do{
			while(root!=null){
				stack.push(root);
				root = root.left;
			}
			while(root==null && !stack.isEmpty()){
				root = stack.peek();
				if(root.right==null || root.right==previous){
					System.out.println(root.val);
					root = stack.pop();
					previous = root;
					root = null;
				}else{
					root = root.right;
				}
			}
		}while(!stack.isEmpty());
	}
}
