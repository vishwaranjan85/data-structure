package practice.dynamic_programming.common_subsequence;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		LongestCommonSubstring obj = new LongestCommonSubstring();
		
		int length1 = obj.longestCommonSubstr("abcde", "ababcde","abcde".length(),"ababcde".length());
		System.out.println(length1);
		
		obj.longestPalindrome("aacabdkacaa");

	}
	
	private int longestCommonSubstr(String str1, String str2, int m, int n){
		int table[][] = new int[m+1][n+1];
		initialize(table, m+1,n+1);
		int max = 0;
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				
				if(str1.charAt(i-1) == str2.charAt(j-1)){
					table[i][j] = 1 + table[i-1][j-1];
					max = Math.max(max, table[i][j]);
				}else{
					table[i][j] = 0;
				}
			}
		}
		return max;
	}
	
	private void initialize(int[][] table, int m, int n){
		for(int i=0; i<m;i++){
			table[i][0] = 0;
		}
		
		for(int i=0;i<n;i++){
			table[0][i] = 0;
		}
	}
	
	
	public String longestPalindrome(String s) {
	       String str1 = s;
	       String str2 = new StringBuilder().append(s).reverse().toString();
	       StringBuilder output = new StringBuilder();
	       
	       return longestPalindromicSubstring(str1, str2,output);
	    }
	    
	    private String longestPalindromicSubstring(String str1, String str2,StringBuilder output){
	        int n = str1.length();
	        int m = str2.length();
	        int max = 0;
	        int maxi = 0;
	        int maxj = 0;
	        int[][] table = new int[n+1][m+1];
	        for(int i=0; i<=n;i++){
	            table[i][0] = 0;
	        }
	        
	        for(int i=0; i<=m;i++){
	            table[0][i] = 0;
	        }
	        
	        for(int i=1; i<=n;i++){
	            for(int j=1;j<=m;j++){
	                if(str1.charAt(i-1)==str2.charAt(j-1)){
	                    table[i][j] = 1 + table[i-1][j-1];
	                    if(table[i][j] > max){
	                        max = table[i][j];
	                        maxi= i;
	                        maxj = j;
	                    }
	                }else{
	                    table[i][j] = 0;
	                }
	            }
	        }
	        
	        int i=maxi; int j=maxj;
	        
	        while(i>0 && j>0){
	            if(str1.charAt(i-1) == str2.charAt(j-1)){
	                output.append(str1.charAt(i-1));
	                i--;
	                j--;
	            }else{
	                if(table[i][j-1] > table[i-1][j]){
	                    j--;
	                }else{
	                    i--;
	                }
	            }
	        }
	        
	        return output.substring(0,max);
	    }

}
