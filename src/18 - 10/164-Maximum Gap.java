public class Solution {
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int min = nums[0], max = nums[0];
        for(int n : nums){
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        if(min == max) return 0;

        int bucketGap = (max - min) / nums.length + 1;
        int bucketLen = (max - min) / bucketGap + 1;
        int[][] bucket = new int[bucketLen][2];
        for(int i=0;i<bucket.length;i++){
            bucket[i][0] = Integer.MAX_VALUE;
            bucket[i][1] = Integer.MIN_VALUE;
        }

        for(int i=0;i<nums.length;i++){
            int index = (nums[i] - min) / bucketGap;
            bucket[index][0] = Math.min(bucket[index][0], nums[i]);
            bucket[index][1] = Math.max(bucket[index][1], nums[i]);
        }

        int rst = 0;
        int prev = bucket[0][1];
        for(int i=1;i<bucket.length;i++){
            if(bucket[i][0] == Integer.MAX_VALUE) continue;
            rst = Math.max(rst, bucket[i][0] - prev);
            prev = bucket[i][1];
        }

        return rst;
    }
}