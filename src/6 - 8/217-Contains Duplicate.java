public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        BitSet notneg = new BitSet();
        BitSet neg = new BitSet();
        for(int i=0;i<nums.length;i++){
            if(nums[i] < 0){
                if(neg.get(Math.abs(nums[i]))){
                    return true;
                }
                neg.set(Math.abs(nums[i]), true);
            }
            else{
                if(notneg.get(nums[i])){
                    return true;
                }
                notneg.set(nums[i], true);
            }
        }
        return false;
    }
}

//
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                return true;
            }
            hm.put(nums[i], 0);
        }
        return false;
    }
}