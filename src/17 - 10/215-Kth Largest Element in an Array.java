public class Solution {
    public int findKthLargest(int[] nums, int k) {
    	class ReverseOrder implements Comparator<Integer>{
    		public int compare(Integer i1, Integer i2){
    			return -(i1-i2);
    		}
    	}
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new ReverseOrder());
        for(int n : nums){
        	pq.add(n);
        }
        while(k-->1){
        	pq.poll();
        }
        return pq.peek();
    }
}


//Quick-Select

public class Solution {             
    public int findKthLargest(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int n : nums) list.add(n);
        return quick(list, k);
    }
    
    private int quick(List<Integer> num, int k){
        int pivot = num.get(0);
        ArrayList<Integer> num1 = new ArrayList<Integer>();
        ArrayList<Integer> num2 = new ArrayList<Integer>();
        for(int i=1;i<num.size();i++){
            if(num.get(i) > pivot){
                num1.add(num.get(i));
            }
            else if(num.get(i) < pivot){
                num2.add(num.get(i));
            }
        }
        if(k <= num1.size()){
            return quick(num1, k);
        }
        if(k > (num.size() - num2.size())){
            return quick(num2, k- (num.size() - num2.size()) );
        }
        return pivot;
    }
}