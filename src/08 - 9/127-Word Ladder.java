public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if(wordDict == null || wordDict.size() == 0){
        	return 0;
        }
        Queue<String> q = new LinkedList<String>();
        int rst = 1;
        q.add(beginWord);
        wordDict.remove(beginWord);
        while(!q.isEmpty()){
        	int n = q.size();
        	for(int i=0;i<n;i++){
        		String cur = q.poll();
        		for(int j=0;j<cur.length();j++){
        			for(char c='a';c<='z';c++){
        				if(c == cur.charAt(j)){
        					continue;
        				}
        				char[] arr = cur.toCharArray();
        				arr[j] = c;
        				String tmp = new String(arr);
        				if(tmp.equals(endWord)){
        					return rst + 1;
        				}
        				if(wordDict.contains(tmp)){
        					q.add(tmp);
        					wordDict.remove(tmp);
        				}
        			}
        		}
        	}
        	rst += 1;
        }
        return 0;
    }
}