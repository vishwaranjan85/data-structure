package practice.trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

	public static void main(String[] args) {
		LevelOrder lo = new LevelOrder();
		BinaryTree bt = new BinaryTree();
		bt.createSampleTree();
		
		lo.levelOrder(bt.root);
	}
	
	public void levelOrder(TreeNode root){
		Queue<TreeNode> queue = new LinkedList<>();
		
		queue.add(root);
		while(!queue.isEmpty()){
			root = queue.poll();
			System.out.println(root.val);
			if(root.left!=null){
				queue.add(root.left);
			}
			if(root.right!=null){
				queue.add(root.right);
			}
		}
	}
}
