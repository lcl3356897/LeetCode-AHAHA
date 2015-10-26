public class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int hl = 0, hr = 0;
        TreeNode l = root, r = root;
        while(l != null) { hl++; l = l.left;}
        while(r != null) { hr++; r = r.right;}
        if(hl == hr) return (2<<(hl-1)) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}