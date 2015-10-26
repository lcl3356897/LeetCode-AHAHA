public class Solution {
	public int[] singleNumber(int[] nums) {
		int[] rst = new int[2];
		int xor = 0;
		for(int tmp : nums){
			xor ^= tmp;
		}
		int mask = xor & (~(xor-1));
		int i=0, j=0;
		for(int tmp : nums){
			if((tmp & mask) == 0){
				i ^= tmp;
			}
			else{
				j ^= tmp;
			}
		}
		rst[0] = i; rst[1] = j;
		return rst;
	}
}