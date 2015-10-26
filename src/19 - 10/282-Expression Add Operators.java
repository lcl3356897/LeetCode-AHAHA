public class Solution {
	List<String> rst = new ArrayList<String>();
	
	public List<String> addOperators(String num, int target) {
		helper(num, target, 0, 0, "");
		return rst;
    }
	
	private void helper(String num, int target, long pre, long curSum, String path){
		if(num.length() == 0 && curSum == target){
			rst.add(new String(path));
			return;
		}
		for(int i=1;i<=num.length();i++){
			String cur = num.substring(0, i);
			long curVal = 0;
			for(int j=0;j<cur.length();j++){
				curVal = curVal * 10 + cur.charAt(j) - '0';
			}
			if(cur.length() > 1 && cur.charAt(0) == '0') return;
			String next = num.substring(i);
			if(path.length() > 0){
				helper(next, target, curVal, curSum + curVal, path + "+" + cur);
				helper(next, target, -curVal, curSum - curVal, path + "-" + cur);
				helper(next, target, pre * curVal, (curSum - pre) + pre * curVal, path + "*" + cur);
			}
			else{
				helper(next, target, curVal, curVal, cur);
			}
		}
		return;
	}
}