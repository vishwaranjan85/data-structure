package practice.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DjkstraMinDistance {

	public static void main(String[] args) {
		//int[][][] input = { { { 0, 1, 1 } }, { { 0, 2, 7 } }, { { 1, 2, 5 } }, { { 1, 4, 4 } }, { { 4, 3, 2 } },
			//	{ { 2, 3, 6 } } };
		int nodes = 6;
		List<List<Edge>> graph = new ArrayList<>();

		for (int i = 0; i < nodes; i++) {
			graph.add(i, new ArrayList<>());
		}

		DjkstraMinDistance obj = new DjkstraMinDistance();
		obj.addEdge(0, 1, 1, graph);
		obj.addEdge(0, 2, 7, graph);
		obj.addEdge(1, 2, 5, graph);
		obj.addEdge(1, 4, 4, graph);
		obj.addEdge(4, 3, 2, graph);
		obj.addEdge(2, 3, 6, graph);
		
		int dist = obj.minimumDistanceBetweenTwoNodes(0, 3, graph);
		System.out.println(dist);

	}

	public void addEdge(int sourceNode, int targetNode, int distance, List<List<Edge>> graph) {
		graph.get(sourceNode).add(new Edge(targetNode, distance));
	}

	public int minimumDistanceBetweenTwoNodes(int source, int destination, List<List<Edge>> graph) {
		if(source == destination){
			return 0;
		}
		
		int distance[] = new int[6];
		for(int j=0;j<distance.length;j++){
			distance[j] = Integer.MAX_VALUE;
		}
		
		boolean[] visited = new boolean[6];
		PriorityQueue<Edge> minHeap = new PriorityQueue<>((e1,e2)->e1.distanceFromNode - e2.distanceFromNode);
		minHeap.add(new Edge(0,0));
		distance[source] = 0;
		
		while(!minHeap.isEmpty()){
			int v = minHeap.poll().targetNode;
			if(visited[v]){
				continue;
			}
			visited[v] = true;
			List<Edge> neighbours = graph.get(v);
			
			for(Edge child: neighbours){
				int dist = child.distanceFromNode;
				int childNode = child.targetNode;
				
				if(!visited[childNode] && distance[v]+dist < distance[childNode] ){
					distance[childNode] = distance[v]+dist;
					child.distanceFromNode = distance[v]+dist;
					minHeap.add(child);
				}
			}
		}
		return distance[destination];
	}
}
