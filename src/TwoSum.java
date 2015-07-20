import java.util.Arrays;
import java.util.HashMap;

/*
 * 思路：
 * 用HashMap保存数值和所在位置 
 * 
 * 注意
 * 1 有就返回
 * 2 不用排序，否则index会乱
 */

class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		int[] rst = new int[2];
		for(int i=0;i<nums.length;i++){
			hs.put(nums[i], i);
		}
		for(int i=0;i<nums.length;i++){
			if(hs.containsKey(target - nums[i]) && i != hs.get(target - nums[i])){
				rst[0] = i+1;
				rst[1] = hs.get(target - nums[i]) + 1;
				return rst;
			}
		}
		return rst;
    }

	
	public static void main(String[] args){
		int[] numbers = {3,2,4};
		int target = 6;
		int[] rst = twoSum(numbers, target);
		System.out.println(rst[0] + "   " + rst[1]);
	}
	
}
