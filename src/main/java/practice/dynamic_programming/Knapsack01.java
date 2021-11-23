package practice.dynamic_programming;

public class Knapsack01 {
	private int[][] t;
	public static void main(String[] args) {
		Knapsack01 obj = new Knapsack01();
		obj.t = new int[4+1][9+1];
		obj.initializeTable(5,10);
		int max = obj.knapsackRecursive(new int[]{1,3,4,5}, new int[]{1,4,5,7}, 9, 4);
		System.out.println(max);
		
		int max1 = obj.knapsackMemoization(new int[]{1,3,4,5}, new int[]{1,4,5,7}, 9, 4);
		System.out.println(max1);
	}
	
	public int knapsackRecursive(int[] weights, int[] values, int weight, int n){
		
		if(n==0 || weight==0){
			return 0;
		}
		if(weights[n-1]<= weight){
			return Math.max(values[n-1]+knapsackRecursive(weights,values,weight-weights[n-1],n-1),
					knapsackRecursive(weights,values,weight,n-1));
		}else{
			return knapsackRecursive(weights,values,weight,n-1);
		}
	}
	
	public int knapsackMemoization(int[] weights, int[] values, int weight, int n){
		if(n==0 || weight==0){
			return 0;
		}
		if(t[n][weight]!=-1){
			return t[n][weight];
		}
		if(weights[n-1]<= weight){
			t[n][weight] =Math.max(values[n-1]+knapsackMemoization(weights,values,weight-weights[n-1],n-1),
					knapsackMemoization(weights,values,weight,n-1));
		}else{
			t[n][weight]=knapsackMemoization(weights,values,weight,n-1);
		}
		return t[n][weight];
	}
	
	public void initializeTable(int n, int w){
		for(int i=0;i<n;i++){
			for(int j=0;j<w;j++){
				t[i][j] = -1;
			}
		}
	}

}
