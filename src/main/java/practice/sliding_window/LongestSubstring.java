package practice.sliding_window;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

	public static void main(String[] args) {
		LongestSubstring obj = new LongestSubstring();
		//obj.longestSubstring("abababbdabcabc", 2);
		obj.longestSubstring("bbaaacbd", 3);
	}
	
	public int longestSubstring(String s, int k) {
        Set<Character> uniqueChars = new HashSet<>();
        for(int i=0;i<s.length();i++){
            uniqueChars.add(s.charAt(i));
        }
        int maxUnique = uniqueChars.size();
        int[] countMap = new int[26];
        int result = 0;
        for(int currUnique=1;currUnique<=maxUnique;currUnique++){
            Arrays.fill(countMap,0);
            int start = 0;
            int end = 0;
            int unique=0;
            int index=0;
            int countAtLeastK=0 ;
            while(end < s.length()){
                if(unique<=currUnique){
                    index = s.charAt(end)-'a';
                    if(countMap[index]==0){
                        unique++;
                    }
                    countMap[index]++;
                    if(countMap[index]==k){
                        countAtLeastK++;
                    }
                    end++;
                }else{
                    index = s.charAt(start)-'a';
                    if(countMap[index]==k){
                        countAtLeastK--;
                    }
                    countMap[index]--;
                    if(countMap[index]==0){
                        unique--;
                    }
                    start++;
                }
                if(unique==currUnique && unique==countAtLeastK){
                    result =Math.max(result, end-start);
                }
            }
        }
        return result;
    }

}
