package practice.dynamic_programming.mcm;

public class PalindromePartitioningRecursive {

	
	public static void main(String[] args) {
		PalindromePartitioningRecursive obj = new PalindromePartitioningRecursive();
		//int[] arr = new int[]{40, 20, 30, 10, 30};
		String input = "ababbbabbababa";
		int min = obj.solve(input, 0, input.length()-1);
		System.out.println(min);
	}
	
	private int solve(String str, int i, int j){
		
		if(i>=j){
			return 0;
		}
		if(isPalindrome(str, i , j)){
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for(int k =i; k<=j-1;k++){
			int tempAns = solve(str, i,k)+solve(str,k+1,j)+1;
			min = Math.min(min, tempAns);
		}
		
		return min;
	}
	
	private boolean isPalindrome(String str, int i, int j){
		String substring = str.substring(i, j+1);
		int left = 0;
		int right = substring.length()-1;
		while(left < right){
			if(substring.charAt(left)!=substring.charAt(right)){
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

}
