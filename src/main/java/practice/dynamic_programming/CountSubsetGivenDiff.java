package practice.dynamic_programming;

public class CountSubsetGivenDiff {

	public static void main(String[] args) {
		CountSubsetGivenDiff ob = new CountSubsetGivenDiff();
		int count = ob.countSubsetGiveDiff(new int[]{1,1,2,3},2);
		
		System.out.println(count);
	}
	
	public int countSubsetGiveDiff(int[] arr, int diff){
		int range = 0;
		for(int i=0; i<arr.length;i++){
			range += arr[i];
		}
		if((diff+range)%2==1){
			return 0;
		}
		
		int sum1 = (diff+range)/2;
		
		CountSubsetSumWithGivenSum obj = new CountSubsetSumWithGivenSum();
		int count = obj.subsetSumCount(arr, sum1, arr.length);
		
		return count;
	}

}
