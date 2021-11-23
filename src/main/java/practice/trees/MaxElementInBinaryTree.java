package practice.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxElementInBinaryTree {

	public static void main(String[] args) {
		MaxElementInBinaryTree maxElement = new MaxElementInBinaryTree();
		BinaryTree bt = new BinaryTree();
		bt.createSampleTree();
		
		int max = maxElement.findMaxElementRecursive(bt.root);
		System.out.println(max);

	}
	
	public int findMaxElement(TreeNode root){
		
		Queue<TreeNode> queue = new LinkedList<>();
		int max = Integer.MIN_VALUE;
		queue.add(root);
		while(!queue.isEmpty()){
			root = queue.poll();
			max = Math.max(max, root.val);
			if(root.left!=null){
				queue.add(root.left);
			}
			if(root.right!=null){
				queue.add(root.right);
			}
		}
		return max;
	}
	
	public int findMaxElementRecursive(TreeNode root){
		int max = Integer.MIN_VALUE;
		if(root!=null){
			int root_val = root.val;
			int left=0;
			int right=0;
			left = findMaxElementRecursive(root.left);
			right = findMaxElementRecursive(root.right);
			max = Math.max(left,right);
			max = Math.max(max, root_val);
		}
		return max;
	}

}
