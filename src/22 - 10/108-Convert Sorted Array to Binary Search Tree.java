public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }
    
    private TreeNode build(int[] nums, int start, int end){
    	if(start > end) return null;
    	
    	int mid = start + (end - start) / 2;
    	TreeNode root = new TreeNode(nums[mid]);
    	root.left = build(nums, start, mid - 1);
    	root.right = build(nums, mid + 1, end);
    	
    	return root;
    }
}