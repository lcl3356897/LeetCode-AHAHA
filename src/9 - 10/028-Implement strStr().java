public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null){
        	return -1;
        }
        if(needle.length() == 0){
        	return 0;
        }
        for(int i=0;i<=haystack.length() - needle.length();i++){
        	/* Look for first character */
        	if(haystack.charAt(i) != needle.charAt(0)){
        		while(++i <= haystack.length() - needle.length() && haystack.charAt(i) != needle.charAt(0));
        	}
        	/* Look for rest character */
        	if(i <= haystack.length() - needle.length()){
        		int j = i+1;
        		int end = j + needle.length() - 1;
        		for(int k=1; j<end && haystack.charAt(j) == needle.charAt(k); j++,k++);
        		
        		if(j == end){
        			return i;
        		}
        	}
        }
        return -1;
    }
}

//KMP
public class Solution {
    public int[] KMP(String s){
        int n = s.length();
        int[] next = new int[n];
        Arrays.fill(next, -1);
        int j = -1;
        for(int i = 1; i < n ; i++){
            while(j >= 0 && s.charAt(i) != s.charAt(j+1)){
                j = next[j];
            }
            if(s.charAt(i) == s.charAt(j+1)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
    
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null){
            return -1;
        }
        if(needle.length() == 0){
            return 0;
        }
        int[] next = KMP(needle);
        int m = haystack.length(), n = needle.length();
        int j = -1;
        for(int i = 0; i < m ; i++){
            while(j >= 0 && haystack.charAt(i) != needle.charAt(j+1)){
                j = next[j];
            }
            if(haystack.charAt(i) == needle.charAt(j+1)){
                j++;
            }
            if(j == n - 1){
                return i - n + 1;
            }
        }
        return -1;
    }
}