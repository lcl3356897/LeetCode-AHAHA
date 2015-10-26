public class Solution {
	private int firstMissingNumber(List<Integer> list){
		int m = list.size();
		for(int i = 0; i < m; i++){
			if(!list.contains((Integer)i)) return i;
		}
		return m;
	}
	
	public boolean canWin(String s){
		int curlen = 0, maxlen = 0;
		// Also get the maximum continuous length
		List<Integer> board_init_state = new ArrayList<Integer>();
		for(int i = 0; i < s.length(); i++){
			// Find the length of all continuous '+' signs
			if(s.charAt(i) == '+') curlen++;
			
			if(i+1 == s.length() || s.charAt(i) == '-'){
				if(curlen >= 2) board_init_state.add(curlen);
				// Get the maximum continuous length
				maxlen = Math.max(maxlen, curlen);
				curlen = 0;
			}
		}
		
		// Sprague-Grundy function of 0 ~ maxlen
		int[] g = new int[maxlen + 1];
		for(int len = 2; len <= maxlen; len++){
			// the S-G value of all subgame states
			List<Integer> gsub = new ArrayList<Integer>();
			for(int first = 0; first < len/2; first++){
				int second = len - first - 2;
				gsub.add(g[first] ^ g[second]);
			}
			g[len] = firstMissingNumber(gsub);
		}
		
		int rst = 0;
		for(int i : board_init_state) rst ^= g[i];
		return rst != 0;
	}
}