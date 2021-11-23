package practice.dynamic_programming;

public class EqualSumPartition {
	
	public static void main(String[] args){
		EqualSumPartition obj = new EqualSumPartition();
		boolean flag = obj.equalSumPartition(new int[] {1,5,11,5});
		System.out.println(flag);
	}
	
	public boolean equalSumPartition(int[] arr){
		int sum = 0;
		for(int i=0; i<arr.length;i++){
			sum += arr[i];
		}
		if(sum%2==1){
			return false;
		}
		
		int partitionSum = sum/2;
		SubsetSum obj = new SubsetSum();
		return obj.subsetSum(arr, partitionSum, arr.length);
	}
}
