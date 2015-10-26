/**
* HashMap
*/

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
    	List<Integer> rst = new ArrayList<Integer>();
        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
        	if(hs.containsKey(nums[i])){
        		hs.put(nums[i], hs.get(nums[i])+1);
        	}
        	else{
        		hs.put(nums[i], 1);
        	}
        	if(hs.get(nums[i]) > nums.length / 3 && rst.contains(nums[i]) == false){
        		rst.add(nums[i]);
        	}
        }
        return rst;
    }
}
/**
* Moore voting algorithm
*/
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> rst = new ArrayList<Integer>();
        int n1=0, n2=0, c1=0, c2=0;
        for(int i=0;i<nums.length;i++){
        	if(nums[i] == n1){
        		c1++;
        	}
        	else if(nums[i] == n2){
        		c2++;
        	}
        	else if(c1==0){
        		n1=nums[i];
       			c1=1;
        	}
        	else if(c2==0){
        		n2=nums[i];
        		c2=1;
        	}
        	else{
        		c1--;
        		c2--;
        	}
        }
        c1=0;c2=0;
        for(int i=0;i<nums.length;i++){
        	if(nums[i]==n1){
        		c1++;
        	}
        	else if(nums[i]==n2){
        		c2++;
        	}
        }
        if(c1 > nums.length/3){
        	rst.add(n1);
        }
        if(c2 > nums.length/3){
        	rst.add(n2);
        }
        Collections.sort(rst);
        return rst;
    }
}