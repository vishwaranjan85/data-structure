package practice.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumDistanceBTWTwoNodes {

	
	public static void main(String[] args) {
		int nodes = 6;
	    
	    Graph_Adjacency_List a = new Graph_Adjacency_List(nodes);
	    
	    a.addEdge(0, 1, true);
	    a.addEdge(0, 3, true);
	    a.addEdge(1, 2, true);
	    a.addEdge(3, 4, true);
	    a.addEdge(2, 4, true);
	    a.addEdge(4, 5, true);
	    
	    MinimumDistanceBTWTwoNodes obj = new MinimumDistanceBTWTwoNodes();
	    int distance = obj.minimumDistanceBetweenTwoNodes(0, 5, a);
	    System.out.println(distance);
	}
	
	private int minimumDistanceBetweenTwoNodes(int start, int destination, Graph_Adjacency_List a){
		if(start==destination){
			return 0;
		}
		Queue<Integer> queue = new LinkedList<>();
		int minDistance = 0;
		
		queue.add(start);
		
		while(!queue.isEmpty()){
			int size = queue.size();
			while(size > 0){
				int node = queue.poll();
				
				List<Integer> neighbours = a.graph.get(node);
				for(int neighbour : neighbours){
					if(neighbour == destination){
						return ++minDistance;
					}
					if(!a.visited[neighbour]){
						queue.add(neighbour);
						a.visited[neighbour] = true;
					}
				}
				size--;
			}
			minDistance++;
		}
		return -1;
	}

}
