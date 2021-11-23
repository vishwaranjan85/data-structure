package practice.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumSumLevel {

	public static void main(String[] args) {
		MaximumSumLevel search = new MaximumSumLevel();
		BinaryTree bt = new BinaryTree();
		bt.createSampleTree();
		
		int maxlevel = search.findMaximumSumLevel(bt.root);
		System.out.println(maxlevel);

	}
	
	public int findMaximumSumLevel(TreeNode root){
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		int level = 0;
		int sum = 0;
		int maxLevel = 0;
		int maxSum = 0;
		while(!queue.isEmpty()){
			root = queue.poll();
			if(root==null){
				
				if(!queue.isEmpty()){
					queue.add(null);
				}
				if(maxSum < sum){
					maxSum = sum;
					maxLevel = level;
				}
				sum = 0;
				level++;
			}else{
				sum += root.val;
				if(root.left!=null){
					queue.add(root.left);
				}
				if(root.right!=null){
					queue.add(root.right);
				}
			}
		}
		return maxLevel;
	}

}
