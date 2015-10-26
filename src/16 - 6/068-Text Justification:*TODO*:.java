public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
    	List<String> rst = new ArrayList<String>();
    	if(words == null || words.length == 0){
    		return rst;
    	}
    	List<StringBuffer> tmp = new ArrayList<StringBuffer>();
    	StringBuffer cur = new StringBuffer();
    	for(String w : words){
    		if(cur.length() + w.length() <= maxWidth){
    			cur.append(w+" ");
    		}
    		else{
    			tmp.add(new StringBuffer(cur));
    			cur = new StringBuffer();
    			cur.append(w+" ");
    		}
    	}
    	tmp.add(new StringBuffer(cur));
    	
    	for(int i=0;i<tmp.size()-1;i++){
    		String[] arr = tmp.get(i).toString().split(" ");
    		int len=0;
    		for(String w : arr){
    			len += w.length();
    		}
    		cur = new StringBuffer();
    		if(arr.length == 0){
    			int need = (maxWidth - len);    			
    			while(need-- > 0){
    				cur.append(" ");
    			}
    		}
    		else if(arr.length == 1){
    			int need = (maxWidth - len);
    			cur.append(arr[0]);
    			while(need-- > 0){
    				cur.append(" ");
    			}
    		}
    		else{
        		int need = (maxWidth - len) / (arr.length - 1);
        		int more = (maxWidth - len) % (arr.length - 1);
        		for(int j=0;j<arr.length-1;j++){
        			cur.append(arr[j]);
        			for(int k=0;k<need;k++){
        				cur.append(" ");
        			}
        			if(j < more){cur.append(" ");}
        		}
        		cur.append(arr[arr.length-1]);
    		}
    		rst.add(new String(cur));
    	}
    	String[] arr = tmp.get(tmp.size()-1).toString().split(" ");
		cur = new StringBuffer();
		for(int i=0;i<arr.length;i++){
			cur.append(arr[i]);
			if(i != arr.length-1){
				cur.append(" ");
			}
		}
		while(cur.length() < maxWidth){
		    cur.append(" ");
		}
		rst.add(new String(cur));
    	
    	
    	return rst;
    }
}