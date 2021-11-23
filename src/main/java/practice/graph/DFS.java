package practice.graph;

import java.util.Stack;

public class DFS {

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
	    
	    DFS obj = new DFS();
	    obj.dfs(theGraph);

	}
	
	private void dfs(Graph theGraph){
		Stack<Integer> stack = new Stack<>();
		
		theGraph.getVertexList()[0].visited = true;
		theGraph.displayVertex(0);
		stack.push(0);
		
		while(!stack.isEmpty()){
			int vertex = theGraph.getAdjUnvisitedVertex(stack.peek());
			if(vertex==-1){
				stack.pop();
			}else{
				theGraph.getVertexList()[vertex].visited = true;
				theGraph.displayVertex(vertex);
				stack.push(vertex);
			}
		}
		
	}

}
