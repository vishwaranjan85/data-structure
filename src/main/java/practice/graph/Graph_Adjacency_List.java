package practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph_Adjacency_List {
	
	public List<List<Integer>> graph;
	public boolean[] visited;
	
	public static void main(String[] args){
		int nodes = 7;
	    
		Graph_Adjacency_List a = new Graph_Adjacency_List(nodes);
	    
	    a.addEdge(0, 1, true);
	    a.addEdge(0, 2, true);
	    a.addEdge(1, 3, true);
	    a.addEdge(2, 4, true);
	    a.addEdge(3, 5, true);
	    a.addEdge(4, 5, true);
	    a.addEdge(4, 6, true);
	    
	    a.bfs(0);
	}
	
	public Graph_Adjacency_List(int nodes){
		graph = new ArrayList<>();
		visited = new boolean[nodes];
		
		for(int i=0; i<nodes;i++){
			graph.add(i,new ArrayList<>());
		}
	}
	
	public void addEdge(int a, int b, boolean bidirectional){
		graph.get(a).add(b);
		if(bidirectional){
			graph.get(b).add(a);
		}
	}
	
	public void dfs(int start){
		Stack<Integer> stack = new Stack<>();
		stack.push(start);
		visited[start] = true;
		
		while(!stack.isEmpty()){
			Integer node = stack.pop();
			System.out.println(node + " ");
			
			List<Integer> neighbours = graph.get(node);
			for(int neighbour: neighbours){
				if(!visited[neighbour]){
					stack.push(neighbour);
					visited[neighbour] = true;
				}
			}
		}
	}
	
	public void bfs(int start){
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(start);
		//visited[start] = true;
		while(!queue.isEmpty()){
			int node = queue.poll();
			System.out.println(node + " ");
			visited[node] = true;
			
			List<Integer> neighbours = graph.get(node);
			for(int neighbour: neighbours){
				if(!visited[neighbour]){
					queue.add(neighbour);
				}
			}
		}
	}
}
