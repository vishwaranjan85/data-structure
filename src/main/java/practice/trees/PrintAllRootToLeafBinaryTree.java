package practice.trees;

import java.util.ArrayList;
import java.util.List;

public class PrintAllRootToLeafBinaryTree {

	public static void main(String[] args) {
		PrintAllRootToLeafBinaryTree search = new PrintAllRootToLeafBinaryTree();
		BinaryTree bt = new BinaryTree();
		bt.createSampleTree();
		
		search.printAllRootToLeaf(bt.root,new ArrayList<Integer>(),0);
	}
	
	public void printAllRootToLeaf(TreeNode root, List<Integer> path,int pathLength){
		
		if(root==null){
			return;
		}
		path.add(0);
		path.set(pathLength,root.val);
		pathLength++;
		
		if(root.left==null && root.right==null){
			printPath(path, pathLength);
		}else{
			printAllRootToLeaf(root.left, path, pathLength);
			printAllRootToLeaf(root.right, path, pathLength);
		}
		
	}
	
	private void printPath(List<Integer> path,int pathLength){
		for(int i=0;i<pathLength;i++){
			System.out.println(path.get(i));
		}
		System.out.println("=============================");
	}

}
