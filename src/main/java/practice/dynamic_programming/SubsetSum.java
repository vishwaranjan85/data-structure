package practice.dynamic_programming;

public class SubsetSum {

	public static void main(String[] args) {

		SubsetSum obj = new SubsetSum();
		boolean max = obj.subsetSum(new int[]{2,3,7,8,10},11, 5);
		System.out.println(max);
	}
	
	public boolean subsetSum(int[] arr, int sum, int n){
		boolean[][] t = new boolean[n+1][sum+1];
		initializeTable(t, sum+1,n+1);
		for(int i=1;i<n+1;i++){
			for(int j=1;j<sum+1;j++){
				
				if(arr[i-1]<=j){
					t[i][j] = t[i-1][j] || t[i-1][j-arr[i-1]];
				}else{
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[n][sum];
	}
	
	public void initializeTable(boolean[][] t, int sum, int n){
		
		for(int i=0;i<sum;i++){
			t[0][i] = false;
		}
		for(int i=0;i<n;i++){
			t[i][0] = true;
		}
	}
}
