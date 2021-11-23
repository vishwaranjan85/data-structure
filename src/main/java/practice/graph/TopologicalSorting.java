package practice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopologicalSorting {

	public static void main(String[] args) {
		int[][] input = {{0,1},{0,2},{1,3},{1,4},{2,4},{3,5},{4,5}};
		int nodes = input.length;
		List<List<Integer>> graph = new ArrayList<>();
		Map<Integer, Integer> incomingDegree = new HashMap<>();
		
		for(int i=0;i<nodes;i++){
			graph.add(i,new ArrayList<>());
			incomingDegree.put(i, 0);
		}
		
		TopologicalSorting obj = new TopologicalSorting();
		
		for(int i=0; i<nodes;i++){
			int[] relation = input[i];
			obj.addEdge(relation[0], relation[1], graph, incomingDegree);
		}
		
		List<Integer> result = obj.topologicalSort(graph, incomingDegree, nodes);
		System.out.println(result);

	}
	
	private void addEdge(int a, int b, List<List<Integer>> graph, Map<Integer, Integer> incomingDegree){
		graph.get(a).add(b);
		incomingDegree.put(b, incomingDegree.getOrDefault(b, 0)+1);
	}
	
	private List<Integer> topologicalSort(List<List<Integer>> graph, Map<Integer, Integer> incomingDegree, int nodes){
		Queue<Integer> sourceQueue = new LinkedList<>();
		for(Map.Entry<Integer, Integer> entry: incomingDegree.entrySet()){
			if(entry.getValue()==0){
				sourceQueue.add(entry.getKey());
			}
		}
		
		List<Integer> result = new ArrayList<>();
		
		while(!sourceQueue.isEmpty()){
			int source = sourceQueue.poll();
			result.add(source);
			
			List<Integer> neighbours = graph.get(source);
			for(Integer child: neighbours){
				incomingDegree.put(child, incomingDegree.get(child)-1);
				
				if(incomingDegree.get(child)==0){
					sourceQueue.add(child);
				}
			}
		}
		
		if(result.size()!=nodes){
			System.out.println("There is cycle in the graph");
			return new ArrayList<>();
		}
		return result;
	}

}
