//
public class Solution {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null) return null;

		if(root.val <= p.val) {
			return inorderSuccessor(root.right, p);
		}
		else {
			TreeNode left = inorderSuccessor(root.left, p);
		    return (left != null) ? left : root;
		  }
	}
}

//
public class Solution {
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
      if (root == null) return null;
      while (root != null && root.val <= p.val) root = root.right;
      
      TreeNode left = inorderSuccessor(root.left, p);
      
      return (left != null && left.val > p.val) ? left : root;
  }
}