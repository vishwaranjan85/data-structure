package practice.dynamic_programming.common_subsequence;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		LongestCommonSubsequence obj = new LongestCommonSubsequence();
		int length = obj.longestCommonSubsequence("abedfghr", "abcdhr");
		System.out.println(length);
		StringBuilder output = new StringBuilder();
		int length1 = obj.longestCommonSubsequenceTopDown("abedfgh", "abcdhr","abedfgh".length(),"abcdhr".length(),output);
		System.out.println(length1);
		System.out.println(output);
		
	}
	
	private int longestCommonSubsequence(String str1, String str2){
		return longestCommonSubsequenceRecursive(str1, str2, str1.length(), str2.length());
	}
	
	private int longestCommonSubsequenceRecursive(String str1, String str2, int n, int m){
		if(n==0 || m==0){
			return 0;
		}
		if(str1.charAt(n-1)==str2.charAt(m-1)){
			return 1+longestCommonSubsequenceRecursive(str1, str2, n-1,m-1);
		}
		else{
			return Math.max(longestCommonSubsequenceRecursive(str1, str2, n-1,m), longestCommonSubsequenceRecursive(str1, str2, n,m-1));
		}
	}
	
	public int longestCommonSubsequenceTopDown(String str1, String str2, int n, int m, StringBuilder output){
		int[][] t = new int[n+1][m+1];
		
		for(int i=0;i<=n;i++){
			t[i][0] = 0;
		}
		for(int j=0;j<=m;j++){
			t[0][j] = 0;
		}
		
		for(int i=1; i<=n;i++){
			for(int j=1;j<=m;j++){
				
				if(str1.charAt(i-1)== str2.charAt(j-1)){
					t[i][j] = 1 + t[i-1][j-1];
					output.append(str1.charAt(i-1));
				}else{
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
				}
			}
		}
		return t[n][m];
	}

}
