package practice.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrder {

	public static void main(String[] args) {
		char[] str = "oath".toCharArray();
		System.out.println("index=="+String.valueOf(str));
		//System.out.println("index=="+str.indexOf('o'));
		ReverseLevelOrder reverse = new ReverseLevelOrder();
		BinaryTree bt = new BinaryTree();
		bt.createSampleTree();
		
		reverse.reverseLevelOrder(bt.root);
	}
	
	public void reverseLevelOrder(TreeNode root){
		Queue<TreeNode> queue = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		int temp = 0;
		queue.add(root);
		while(!queue.isEmpty()){
			root = queue.poll();
			temp = root.val;
			if(root.right!=null){
				queue.add(root.right);
			}
			if(root.left!=null){
				queue.add(root.left);
			}
			stack.push(temp);
		}
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
 	}
}
