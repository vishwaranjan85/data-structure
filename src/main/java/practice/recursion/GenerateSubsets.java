package practice.recursion;

public class GenerateSubsets {

	public static void main(String[] args) {
		GenerateSubsets obj = new GenerateSubsets();
		obj.generate("abc", "");
		System.out.println("++++++++++++++++++++");
		obj.generatePermuteCase("abc", "");
		
		System.out.println("++++++++++++++++++++");
		obj.generateLetterCasePermute("A1B2", "");

	}
	
	public void generate(String input, String output){
		
		if(input.length()==0){
			System.out.println(output);
			return;
		}
		
		generate(input.substring(1,input.length()), output);
		generate(input.substring(1,input.length()), output+String.valueOf(input.charAt(0)));
		return;
	}
	
	public void generatePermuteCase(String input, String output){
		
		if(input.length()==0){
			System.out.println(output);
			return;
		}
		
		generatePermuteCase(input.substring(1,input.length()), output+String.valueOf(input.charAt(0)));
		generatePermuteCase(input.substring(1,input.length()), output+(String.valueOf(input.charAt(0)).toUpperCase()));
		return;
	}
	
	public void generateLetterCasePermute(String input, String output){
		
		if(input.length()==0){
			System.out.println(output);
			return;
		}
		if(Character.isDigit(input.charAt(0))){
			generateLetterCasePermute(input.substring(1,input.length()), output+String.valueOf(input.charAt(0)));
		}else{
			generateLetterCasePermute(input.substring(1,input.length()), output+(String.valueOf(input.charAt(0)).toLowerCase()));
			generateLetterCasePermute(input.substring(1,input.length()), output+(String.valueOf(input.charAt(0)).toUpperCase()));
		}
		return;
	}
}
