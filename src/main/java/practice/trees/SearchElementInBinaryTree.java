package practice.trees;

import java.util.LinkedList;
import java.util.Queue;

public class SearchElementInBinaryTree {

	public static void main(String[] args) {
		SearchElementInBinaryTree search = new SearchElementInBinaryTree();
		BinaryTree bt = new BinaryTree();
		bt.createSampleTree();
		
		boolean found = search.searchElement(bt.root, 6);
		System.out.println(found);
	}
	
	public boolean searchElement(TreeNode root, int element){
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			root = queue.poll();
			if(root.val==element){
				return true;
			}
			if(root.left!=null){
				queue.add(root.left);
			}
			if(root.right!=null){
				queue.add(root.right);
			}
		}
		return false;
	}
	
	public boolean searchElementRecursively(TreeNode root, int element){
		boolean temp = false;
		if(root==null){
			return false;
		}else if(root.val == element){
			return true;
		}else{
			temp = searchElementRecursively(root.left,element);
			if(temp){
				return true;
			}else{
				return searchElementRecursively(root.right,element);
			}
		}
	}
}
