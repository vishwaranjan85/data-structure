package practice.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class MinSubsetSumDiff {
	public static void main(String[] args){
		MinSubsetSumDiff obj = new MinSubsetSumDiff();
		int count = obj.minSubsetSumDiff(new int[]{1,6,1,1,5}, 5);
		System.out.println(count);
	}
	
	public List<Integer> subsetPoss(int[] arr, int sum, int n){
		boolean[][] t = new boolean[n+1][sum+1];
		initialize(t, n+1,sum+1);
		
		for(int i=1;i<=n;i++){
			for (int j=1;j<=sum;j++){
				
				if(arr[i-1]<=j){
					t[i][j] = t[i-1][j] || t[i-1][j-arr[i-1]];
				}else{
					t[i][j] = t[i-1][j];
				}
			}
		}
		List<Integer> poss = new ArrayList<>();
		for(int i=0;i<=sum;i++){
			if(t[n][i]){
				poss.add(i);
			}
		}
		
		return poss;
	}
	
	public int minSubsetSumDiff(int arr[], int n){
		
		int range = 0;
		for(int i=0; i<n;i++){
			range += arr[i];
		}
		
		List<Integer> poss = subsetPoss(arr, range,n);
		
		int min = Integer.MAX_VALUE;
		for(int i=0;i<poss.size();i++){
			min = Math.min(min, Math.abs(range - 2*poss.get(i)));
		}
		return min;
	}
	
	public void initialize(boolean[][] t, int n,int m){
		
		for(int i=0;i<m;i++){
			t[0][i] = false;
		}
		for(int j=0;j<n;j++){
			t[j][0] = true;
		}
	}
}
