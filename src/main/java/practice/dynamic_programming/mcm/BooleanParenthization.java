package practice.dynamic_programming.mcm;

import java.util.HashMap;
import java.util.Map;

public class BooleanParenthization {
	
	Map<String, Integer> map = new HashMap<>();
	public static void main(String[] args) {
		BooleanParenthization obj = new BooleanParenthization();
		int ans = obj.solve("T|T&F^T", 0, 6, true,0);
		System.out.println(ans);

	}
	
	private int solve(String str, int i, int j, boolean isTrue, int count){
		
		if(i>j){
			return 0;
		}
		if(i==j){
			if(isTrue){
				return (str.charAt(i)=='T')?1:0;
			}else{
				return (str.charAt(i)=='F')?1:0;
			}
		}
		String key = i + " "+j+ " "+isTrue;
		
		
		int ans = 0;
		for(int k=i+1;k<=j-1;k++){
			int lt = solve(str, i,k-1,true, count++);
			int lf = solve(str, i,k-1,false, count++);
			int rt = solve(str, k+1,j,true, count++);
			int rf = solve(str, k+1,j,false,count++);
			
			char op = str.charAt(k);
			if(op=='&'){
				
				if(isTrue){
					ans += lt*rt;
				}else{
					ans += lt*rf + lf*rt + lf*rf;
				}
			}else if(op=='|'){
				if(isTrue){
					ans += lt*rt + lt*rf + lf*rt;
				}else{
					ans += lf*rf;
				}
			}else if(op == '^'){
				if(isTrue){
					ans += lt*rf + lf * rt;
				}else{
					ans += lt*rt + lf*rf;
				}
			}
		}
		System.out.println("count value =="+count);
		return ans;
	}

}
