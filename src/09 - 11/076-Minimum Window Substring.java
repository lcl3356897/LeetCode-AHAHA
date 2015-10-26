public class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()){
        	return "";
        }           
        int[] appear = new int[256];  
        int[] expect = new int[256];  
        for(int i =0; i < t.length(); i++){  
             expect[t.charAt(i)]++;                 
        }  
        int minValue = Integer.MAX_VALUE, minStart = 0;  
        int wid_start=0;  
        int appeared = 0;   
        for(int wid_end = 0; wid_end< s.length(); wid_end++)  {  
             if(expect[s.charAt(wid_end)] > 0){// this char is a part of T  
                  appear[s.charAt(wid_end)]++;  
                  if(appear[s.charAt(wid_end)] <= expect[s.charAt(wid_end)])  
                       appeared ++;                      
             }  
             if(appeared == t.length()){                 
                  while(appear[s.charAt(wid_start)] > expect[s.charAt(wid_start)]   
                  || expect[s.charAt(wid_start)] == 0){  
                       appear[s.charAt(wid_start)]--;  
                       wid_start ++;  
                  }                      
	             if(minValue > (wid_end - wid_start +1)){  
	            	 minValue = wid_end - wid_start +1;
	            	 minStart = wid_start;  
	             }  
             }                 
        }
        return minValue == Integer.MAX_VALUE ? "" :s.substring(minStart, minStart+minValue);      
    }
}