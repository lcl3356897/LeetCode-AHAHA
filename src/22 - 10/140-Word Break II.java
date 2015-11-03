public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> rst = new ArrayList<String>();
        if(s.length() == 0) return rst;

        boolean[][] isWord = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                isWord[i][j] = wordDict.contains(s.substring(i, j + 1));
            }
        }

        boolean[] possible = new boolean[s.length() + 1];
        possible[s.length()] = true;
        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = i; j < s.length(); j++){
                if(isWord[i][j] && possible[j+1]){
                    possible[i] = true;
                    break;
                }
            }
        }

        List<String> path = new ArrayList<String>();
        search(0, s, path, isWord, possible, rst);
        return rst;
    }

    private void search(int index, String s, List<String> path, boolean[][] isWord, boolean[] possible, List<String> rst){
        if(!possible[index]) return;

        if(index == s.length()){
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < path.size(); i++){
                sb.append(path.get(i) + " ");
            }
            rst.add(new String(sb).trim());
            return;
        }

        for(int i = index; i < s.length(); i++){
            if(!isWord[index][i]) continue;
            path.add(s.substring(index, i + 1));
            search(i + 1, s, path, isWord, possible, rst);
            path.remove(path.size() - 1);
        }
    }
}