public class Solution {
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> rst = new ArrayList<Integer>();
		if(input == null || input.length() == 0) return rst;
		
		for(int i=0; i<input.length();i++){
			char c = input.charAt(i);
			if(c != '+' && c !='-' && c != '*') continue;
			
			List<Integer> part1 = diffWaysToCompute(input.substring(0, i));
			List<Integer> part2 = diffWaysToCompute(input.substring(i+1, input.length()));
			
			for(Integer m : part1){
				for(Integer n : part2){
					if(c == '+') rst.add(m + n);
					if(c == '-') rst.add(m - n);
					if(c == '*') rst.add(m * n);
				}
			}
		}
		if(rst.size() == 0){
			rst.add(Integer.parseInt(input));
		}
		return rst;
	}
}