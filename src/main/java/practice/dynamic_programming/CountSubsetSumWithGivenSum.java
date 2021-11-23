package practice.dynamic_programming;

public class CountSubsetSumWithGivenSum {

	public static void main(String[] args) {
		CountSubsetSumWithGivenSum obj = new CountSubsetSumWithGivenSum();
		int count = obj.subsetSumCount(new int[]{2,3,5,6,8,10},10, 6);
		System.out.println(count);
	}
	
	public int subsetSumCount(int[] arr, int sum, int n){
		int[][] t = new int[n+1][sum+1];
		initializeTable(t, sum+1,n+1);
		for(int i=1;i<n+1;i++){
			for(int j=1;j<sum+1;j++){
				
				if(arr[i-1]<=j){
					t[i][j] = t[i-1][j] + t[i-1][j-arr[i-1]];
				}else{
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[n][sum];
	}
	
	public void initializeTable(int[][] t, int sum, int n){
		
		for(int i=0;i<sum;i++){
			t[0][i] = 0;
		}
		for(int i=0;i<n;i++){
			t[i][0] = 1;
		}
	}
}
