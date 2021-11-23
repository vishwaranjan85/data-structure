package practice.dynamic_programming.mcm;

public class EggDroppingProblem {

	public static void main(String[] args) {
		EggDroppingProblem obj = new EggDroppingProblem();
		int min = obj.solve(2, 4);
		System.out.println(min);
	}
	
	private int solve(int e, int f){
		if(f==0 || f==1){
			return f;
		}
		if(e==1){
			return f;
		}
		int min = Integer.MAX_VALUE;
		
		for(int k=1;k<=f;k++){
			int temp = 1+Math.max(solve(e-1,k-1), solve(e,f-k));
			min= Math.min(min, temp);
		}
		return min;
	}

}
