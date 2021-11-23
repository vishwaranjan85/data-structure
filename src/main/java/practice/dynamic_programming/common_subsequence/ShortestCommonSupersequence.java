package practice.dynamic_programming.common_subsequence;

public class ShortestCommonSupersequence {

	public static void main(String[] args) {
		LongestCommonSubsequence obj = new LongestCommonSubsequence();
		StringBuilder output = new StringBuilder();
		int length1 = obj.longestCommonSubsequenceTopDown("abedfgh", "abcdhr","abedfgh".length(),"abcdhr".length(),output);
		System.out.println(length1);
		System.out.println(output);
		System.out.println(("abedfgh"+"abcdhr").length()-length1);
		
		
		ShortestCommonSupersequence ob = new ShortestCommonSupersequence();
		
		StringBuilder output1 = new StringBuilder();
		System.out.println(ob.printSCS("abedfgh", "abcdhr", output1));
	}
	
	public String printSCS(String str1, String str2, StringBuilder output){
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
				if(str1.charAt(i-1) == str2.charAt(j-1)){
					table[i][j] = 1 + table[i-1][j-1];
				}else{
					table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
				}
			}
		}
		
		int i=n; int j=m;
		while(i>0 && j>0){
			if(str1.charAt(i-1)==str2.charAt(j-1)){
				output.append(str1.charAt(i-1));
				i--;
				j--;
			}else{
				if(table[i][j-1] > table[i-1][j]){
					output.append(str2.charAt(j-1));
					j--;
				}else{
					output.append(str1.charAt(i-1));
					i--;
				}
			}
		}
		while(i>0){
			output.append(str1.charAt(i-1));
			i--;
		}
		while(j>0){
			output.append(str2.charAt(j-1));
			j--;
		}
		
		return output.reverse().toString();
	}

}
