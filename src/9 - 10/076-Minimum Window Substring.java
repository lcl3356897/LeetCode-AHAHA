public class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()){
          return "";
        }
        int[] appear = new int[256], expect = new int[256];
        for(char c : t.toCharArray()){
          expect[c]++;
        }
        int min_value = Integer.MAX_VALUE, min_start = 0;
        int win_start = 0;
        int appeared = 0;
        for(int win_end = 0; win_end < s.length(); win_end++){
          if(expect[s.charAt(win_end)] > 0){
            appear[s.charAt(win_end)]++;
            if(appear[s.charAt(win_end)] <= expect[s.charAt(win_end)]){
              appeared++;
            }
          }
          if(appeared == t.length()){
            while(appear[s.charAt(win_start)] > expect[s.charAt(win_start)]
              || expect[s.charAt(win_start)] == 0){
              appear[s.charAt(win_start)]--;
              win_start++;
            }
            if((win_end - win_start + 1) < min_value){
              min_start = win_start;
              min_value = win_end - win_start + 1;
            }
          }
        }

        return min_value == Integer.MAX_VALUE ? "" : s.substring(min_start, min_start + min_value);
    }
}