public class TwoSum {
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    
    // Add the number to an internal data structure.
	public void add(int number) {
	    if(hm.containsKey(number)){
	    	hm.put(number, hm.get(number) + 1);
	    }
	    else{
	    	hm.put(number, 1);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
		for(int n : hm.keySet()){
			if(hm.containsKey( value - n )){
				if( n == value - n && hm.get(n) < 2 ){
					continue;
				}
				return true;
			}
		}
	    return false;
	}
}