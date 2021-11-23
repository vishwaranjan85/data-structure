package practice.trees;

import java.util.LinkedList;
import java.util.Queue;

public class HeightBinaryTree {

	public static void main(String[] args) {
		HeightBinaryTree search = new HeightBinaryTree();
		BinaryTree bt = new BinaryTree();
		bt.createSampleTree();
		
		int height = search.calculateHeightNonRecursive(bt.root);
		System.out.println(height);
		
		TreeNode deepestNode = search.findDeepestNode(bt.root);
		System.out.println(deepestNode.val);
	}
	
	public int calculateHeight(TreeNode root){
		int leftHeight,rightHeight=0;
		if(root==null){
			return 0;
		}
		leftHeight = calculateHeight(root.left);
		rightHeight = calculateHeight(root.right);
		
		if(leftHeight<rightHeight){
			return rightHeight+1;
		}
		return leftHeight+1;
	}
	
	public int calculateHeightNonRecursive(TreeNode root){
		Queue<TreeNode> queue = new LinkedList<>();
		int level=0;
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()){
			root = queue.poll();
			if(root==null){
				if(!queue.isEmpty()){
					queue.add(null);
				}
				level++;
			}else{
				if(root.left!=null){
					queue.add(root.left);
				}
				if(root.right != null){
					queue.add(root.right);
				}
			}
		}
		return level;
	}
	
	public TreeNode findDeepestNode(TreeNode root){
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		TreeNode node = null;
		while(!queue.isEmpty()){
			node = queue.poll();
			if(node.left!=null){
				queue.add(node.left);
			}
			if(node.right!=null){
				queue.add(node.right);
			}
		}
		return node;
	}
}
