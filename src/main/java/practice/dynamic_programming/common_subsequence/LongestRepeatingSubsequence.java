package practice.dynamic_programming.common_subsequence;

public class LongestRepeatingSubsequence {

	public static void main(String[] args) {
		LongestRepeatingSubsequence obj = new LongestRepeatingSubsequence();
		int length = obj.longestRepeatingSubsequence("AABEBCDD", "AABEBCDD");
		System.out.println(length);
	}
	
	private int longestRepeatingSubsequence(String str1, String str2){
		int n = str1.length();
		int m = str2.length();
		
		int[][] table = new int[n+1][m+1];
		for(int i=0; i<=n;i++){
			table[i][0]=0;
		}
		for(int i=0; i<=m;i++){
			table[0][m]=0;
		}
		for(int i=1; i<=n;i++){
			for(int j=1;j<=m;j++){
				if(str1.charAt(i-1) == str2.charAt(j-1) && i!=j){
					table[i][j] = 1 + table[i-1][j-1];
				}else{
					table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
				}
			}
		}
		
		return table[n][m];
	}

}
