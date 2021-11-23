package practice.dynamic_programming.mcm;

public class ScrambledString {

	public static void main(String[] args) {
		ScrambledString obj = new ScrambledString();
		boolean flag = obj.isScramble("great", "rgated");
		System.out.println(flag);
	}
	
	private boolean isScramble(String A, String B){
		if(A.equals(B)){
			return true;
		}
		if(A.length() <=1){
			return false;
		}
		boolean flag = false;
		//System.out.println("a=="+a+" b==="+b);
		for(int i=1; i<A.length();i++){
			System.out.println("index =="+i);
			System.out.println("a=="+A+" b==="+B);
			if((isScramble(A.substring(0,i),B.substring(B.length()-i,B.length())) 
					&& isScramble(A.substring(i,A.length()), B.substring(0,B.length()-i)))
					|| (isScramble(A.substring(0,i), B.substring(0,i)) 
							&& isScramble(A.substring(i,A.length()),B.substring(i,B.length())))){
				
				flag = true;
				break;
			}
		}
		return flag;
	}

}
