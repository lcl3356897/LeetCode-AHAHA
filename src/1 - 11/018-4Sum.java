//3Sum update version
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(nums == null || nums.length <= 3){
        	return rst;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
        	if(i>0 && nums[i-1] == nums[i]){
        		continue;
        	}
        	for(int j=i+1;j<nums.length-2;j++){
        		if(j > i+1 && nums[j-1] == nums[j]){
        			continue;
        		}
        		int k=j+1, l=nums.length-1;
        		while(k<l){
        		    if(k > j+1 && nums[k-1] == nums[k]){
        		        k++;continue;
        		    }
        		    if(l < nums.length-1 && nums[l] == nums[l+1]){
        		        l--;continue;
        		    }
        			int sum = nums[i] + nums[j] + nums[k] + nums[l];
        			if(sum < target){
        				k++;
        			}
        			else if(sum > target){
        				l--;
        			}
        			else{
        				List<Integer> tmp = new ArrayList<Integer>();
        				tmp.add(nums[i]);tmp.add(nums[j]);
        				tmp.add(nums[k]);tmp.add(nums[l]);
        				if(rst.indexOf(tmp) == -1){
        					rst.add(tmp);
        				}
        				k++;l--;
        			}
        		}
        	}
        }
        return rst;
    }
}
//Two Two-Sum
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(nums == null || nums.length <= 3){
        	return rst;
        }
        HashMap<Integer, List<List<Integer>>> pair = new HashMap<Integer, List<List<Integer>>>();
        for(int i=0;i<nums.length-1;i++){
        	for(int j=i+1;j<nums.length;j++){
        		List<List<Integer>> value = new ArrayList<List<Integer>>();
        		List<Integer> tmp = new ArrayList<Integer>();
        		tmp.add(i);tmp.add(j);
        		if(pair.containsKey(nums[i]+nums[j])){
        			pair.get(nums[i]+nums[j]).add(tmp);
        		}
        		else{
        			value.add(tmp);
            		pair.put(nums[i]+nums[j], value);
        		}
        	}
        }
        HashMap<Integer, HashMap> hs = new HashMap<Integer, HashMap>();
        for(int sum : pair.keySet()){
        	if(pair.containsKey(target - sum)){
        		for(int i=0;i<pair.get(sum).size();i++){
        			for(int j=0;j<pair.get(target-sum).size();j++){
                		List<Integer> tmp = new ArrayList<Integer>();
        				tmp.add((Integer) pair.get(sum).get(i).get(0));
        				tmp.add((Integer) pair.get(sum).get(i).get(1));
        				if(tmp.contains(pair.get(target - sum).get(j).get(0))){
        					continue;
        				}
        				tmp.add((Integer) pair.get(target - sum).get(j).get(0));
        				if(tmp.contains(pair.get(target - sum).get(j).get(1))){
        					continue;
        				}
        				tmp.add((Integer) pair.get(target - sum).get(j).get(1));
        				List<Integer> tmprst = new ArrayList<Integer>();
        				for(int tmpi=0;tmpi<tmp.size();tmpi++){
        					tmprst.add(nums[tmp.get(tmpi)]);
        				}
        				Collections.sort(tmprst);
                		if(rst.indexOf(tmprst) == -1){
                			rst.add(tmprst);
                		}
        			}
        		}
        	}
        }
        return rst;
    }
}