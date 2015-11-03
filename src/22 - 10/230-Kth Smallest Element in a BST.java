//Binary Search
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int leftCount = count(root.left) + 1;
        if(leftCount < k){
            return kthSmallest(root.right, k - leftCount);
        }
        else if(leftCount > k){
            return kthSmallest(root.left, k);
        }
        else{
            return root.val;
        }
    }

    private int count(TreeNode root){
        if(root == null) return 0;
        return count(root.left) + count(root.right) + 1;
    }
}

//InOrder
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<TreeNode>();

        TreeNode p = root;
        int rst = 0;
        
        while(!st.isEmpty() || p != null){
            if(p != null){
                st.add(p);
                p = p.left;
            }
            else{
                TreeNode t = st.pop();
                k--;
                if(k == 0) rst = t.val;
                p = t.right;
            }
        }
        return rst;
    }
}