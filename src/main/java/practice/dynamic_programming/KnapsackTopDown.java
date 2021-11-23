package practice.dynamic_programming;

public class KnapsackTopDown {

	public static void main(String[] args) {
		KnapsackTopDown obj = new KnapsackTopDown();
		int max = obj.knapsackTopDown(new int[]{1,3,4,5}, new int[]{1,4,5,7}, 9, 4);
		System.out.println(max);

	}
	
	public int knapsackTopDown(int[] weights, int[] values, int weight, int n){
		int[][] t = new int[n+1][weight+1];
		initializeTable(t, n+1, weight+1);
		
		for(int i=1;i<=n;i++){
			for(int j=1;j<=weight;j++){
				
				/*if(i==0 || j==0){
					t[i][j] = 0;
				}*/
				
				if(weights[i-1] <= j){
					t[i][j] = Math.max(values[i-1]+t[i-1][j-weights[i-1]],t[i-1][j]);
				}else{
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[n][weight];
	}
	
	public void initializeTable(int[][] t, int n, int w){
		for(int i=0;i<n;i++){
			t[i][0] = 0; 
		}
		for(int i=0;i<w;i++){
			t[0][i] = 0; 
		}
	}

}
