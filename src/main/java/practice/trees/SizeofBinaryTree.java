package practice.trees;

import java.util.HashMap;
import java.util.Map;

public class SizeofBinaryTree {

	public static void main(String[] args) {
		SizeofBinaryTree search = new SizeofBinaryTree();
		BinaryTree bt = new BinaryTree();
		bt.createSampleTree();
		Map<Integer,Integer> map = new HashMap<>();
		Map<Integer, Integer> map1 = new HashMap<>(map);
		int size = search.findSize(bt.root);
		System.out.println(size);
	}
	
	public int findSize(TreeNode root){
		if(root==null){
			return 0;
		}
		return findSize(root.left)+1 + findSize(root.right);
	}
}
