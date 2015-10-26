public class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int start = 0, rest = 0, cur = 0;
        for(int i=0; i<cost.length; i++) {
            rest += gas[i] - cost[i];
            cur += gas[i] - cost[i];
            if(cur<0) {
                start = i+1;
                cur = 0;
            }
        } 
        if(rest < 0) return -1;
        return start;
    }
}