//
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
          List<Integer> rst = new ArrayList<Integer>();

          Stack<Integer> incr = new Stack<Integer>(); // predecessors
          Stack<Integer> decr = new Stack<Integer>(); // successors

          inorder(root, target, true, incr);
          inorder(root, target, false, decr);

          while (k-- > 0) {
            if (incr.isEmpty())  rst.add(decr.pop());
            else if (decr.isEmpty())  rst.add(incr.pop());
            else if (Math.abs(incr.peek() - target) < Math.abs(decr.peek() - target))
              rst.add(incr.pop());
            else
              rst.add(decr.pop());
          }

          return rst;
        }

        // inorder traversal
        void inorder(TreeNode root, double target, boolean ascend, Stack<Integer> stack) {
          if (root == null) return;
          
          inorder(ascend ? root.left : root.right, target, ascend, stack);
          // early terminate, no need to traverse the whole tree
          if ((ascend && root.val > target) || (!ascend && root.val <= target)) return;
          // track the value of current node
          stack.push(root.val);
          inorder(ascend ? root.right : root.left, target, ascend, stack);
        }
}

//
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
    	List<Integer> rst = new ArrayList<Integer>();
    	class closestCompare implements Comparator<Integer>{
    		public int compare(Integer i1, Integer i2){
    			if(Math.abs(target - i1) < Math.abs(target - i2)){
    				return -1;
    			}
    			else if(Math.abs(target - i1) == Math.abs(target - i2)){
    				return 0;
    			}
    			else{
    				return 1;
    			}
    		}
    	}
    	PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new closestCompare());
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	q.add(root);
    	while(!q.isEmpty()){
    		TreeNode cur = q.poll();
    		pq.add(cur.val);
    		if(cur.left != null) q.add(cur.left);
    		if(cur.right != null) q.add(cur.right);
    	}
    	
    	for(int i = 0; i < k; i++){
    		rst.add(pq.poll());
    	}
    	
    	return rst;
    }
}