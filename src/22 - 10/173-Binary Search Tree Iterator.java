public class BSTIterator {
    Stack<TreeNode> st;
    
    public BSTIterator(TreeNode root) {
        st = new Stack<TreeNode>();
        while(root != null){
            st.add(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = st.pop();
        int val = node.val;

        node = node.right;
        while(node != null){
            st.add(node);
            node = node.left;
        }
        
        return val;
    }
}