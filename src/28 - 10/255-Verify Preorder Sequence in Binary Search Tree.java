public class Solution {
	public boolean verifyPreorder(int[] preorder) {
	    int low = Integer.MIN_VALUE;
	    Stack<Integer> st = new Stack<Integer>();
	    for (int p : preorder) {
	        if (p < low) return false;
	        while (!st.empty() && p > st.peek()){
	            low = st.pop();
	        }
	        st.push(p);
	    }
	    return true;
	}
}