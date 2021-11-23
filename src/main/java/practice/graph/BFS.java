package practice.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public static void main(String[] args) {
		Graph theGraph = new Graph();
	    theGraph.addVertex('A');
	    theGraph.addVertex('B');
	    theGraph.addVertex('C');
	    theGraph.addVertex('D');
	    theGraph.addVertex('E');
	    theGraph.addVertex('F');
	    
	    theGraph.addEdge(0, 1, true);
	    theGraph.addEdge(1, 2, true);
	    theGraph.addEdge(0, 3, true);
	    theGraph.addEdge(3, 4, true);
	    theGraph.addEdge(4, 5, true);
	    theGraph.addEdge(1, 3, true);
	    
	    BFS obj = new BFS();
	    obj.bfs(theGraph);
	}
	
	public void bfs(Graph theGraph){
		Queue<Integer> queue = new LinkedList<>();
		int vertex = 0;
		queue.add(vertex);
		int vertex2 = 0;
		while(!queue.isEmpty()){
			vertex = queue.poll();
			theGraph.getVertexList()[vertex].visited = true;
			theGraph.displayVertex(vertex);
			
			while((vertex2 = theGraph.getAdjUnvisitedVertex(vertex))!=-1){
				theGraph.getVertexList()[vertex2].visited = true;
				queue.add(vertex2);
			}
		}
	}

}
