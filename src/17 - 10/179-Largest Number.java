public class Solution {
	public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i=0;i<nums.length;i++){
        	strs[i] = String.valueOf(nums[i]);
        }
        
        class StringCombineCompare implements Comparator<String>{
        	public int compare(String s1, String s2){
        		String leftright = s1 + s2;
        		String rightleft = s2 + s1;
        		return -leftright.compareTo(rightleft);
        	}
        }
        Arrays.sort(strs, new StringCombineCompare());
        
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<strs.length;i++){
        	sb.append(strs[i]);
        }
        
        while(sb.length() > 1 && sb.charAt(0) == '0'){
        	sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
}