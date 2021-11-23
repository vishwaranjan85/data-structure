package practice.graph;

import java.util.Arrays;

public class KruskalAlgo {

	public static void main(String[] args) {
		int[][] edges = {{1,2,1},{1,3,7},{3,4,2},{2,4,5},{2,5,6},{5,6,3},{5,7,9},{6,8,8},{7,8,4}};
		KruskalAlgo obj = new KruskalAlgo();
		
		obj.minimumCost(8, edges);
	}
	
	public int minimumCost(int N, int[][] connections) {
        int[] parents = new int[N+1];
        for(int i=0; i<N+1;i++){
            parents[i] = -1;
        }
        
        Arrays.sort(connections, (a,b) -> a[2] -b[2]);
        
        int total = 0;
        int cost = 0;
        for(int i=0; i< connections.length;i++){
            
            int city1 = connections[i][0];
            int city2 = connections[i][1];
            
            if(isSameGroup(city1, city2, parents)){
                continue;
            }
            
            union(city1, city2, parents);
            cost += connections[i][2];
            
            total++;
        }
        
        if(total==N-1){
            return cost;
        }else{
            return -1;
        }
        
        
    }
    
    private void union(int city1, int city2, int[] parents){
        int rootCity1 = findRoot(city1, parents);
        int rootCity2 = findRoot(city2, parents);
        
        if(rootCity1 == rootCity2){
            return;
        }
        
        parents[rootCity2] = rootCity1; 
    }
    
    private int findRoot(int city, int[] parents){
        
        while(parents[city] > 0){
            city = parents[city];
        }
        return city;
    }
    
    private boolean isSameGroup(int city1, int city2, int[] parents){
        return findRoot(city1, parents) == findRoot(city2, parents);
    }
}

