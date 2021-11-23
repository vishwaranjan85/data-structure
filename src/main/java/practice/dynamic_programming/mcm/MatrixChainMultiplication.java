package practice.dynamic_programming.mcm;

public class MatrixChainMultiplication {

	//int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		MatrixChainMultiplication obj = new MatrixChainMultiplication();
		//int[] arr = new int[]{40, 20, 30, 10, 30};
		int[] arr = new int[]{10, 30, 5, 60};
		int min = obj.solve(arr, 1, arr.length-1);
		System.out.println(min);
	}
	
	private int solve(int[] arr, int i, int j){
		
		if(i>=j){
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for(int k =i; k<=j-1;k++){
			int tempAns = solve(arr, i,k)+solve(arr,k+1,j)+arr[i-1]*arr[k]*arr[j];
			min = Math.min(min, tempAns);
		}
		
		return min;
	}

}
