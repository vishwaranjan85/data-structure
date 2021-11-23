package practice.trees;

import java.util.LinkedList;
import java.util.Queue;

public class CountLeafNodes {

	public static void main(String[] args) {
		CountLeafNodes search = new CountLeafNodes();
		BinaryTree bt = new BinaryTree();
		bt.createSampleTree();
		
		int count = search.countLeafNodes(bt.root);
		System.out.println(count);
	}
	
	public int countLeafNodes(TreeNode root){
		Queue<TreeNode> queue = new LinkedList<>();
		int count = 0;
		queue.add(root);
		while(!queue.isEmpty()){
			root = queue.poll();
			if(root.left==null && root.right==null){
				count++;
			}else{
				if(root.left!=null){
					queue.add(root.left);
				}
				if(root.right!=null){
					queue.add(root.right);
				}
			}
		}
		return count;
	}

}
