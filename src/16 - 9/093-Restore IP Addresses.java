public class Solution {
    List<String> rst = new ArrayList<String>();
    List<String> path = new ArrayList<String>();

    public List<String> restoreIpAddresses(String s) {
        if(s == null || s.length() < 4) return new ArrayList<String>();
        helper(s, 4);
        return rst;
    }

    private void helper(String s, int part){
        if(part == 0){
            if(s.length() != 0) return;
            StringBuffer sb = new StringBuffer();
            for(String str : path){
                sb.append(str + ".");
            }
            sb.deleteCharAt(sb.length() - 1);
            if(!rst.contains(sb.toString())){
                rst.add(new String(sb));
            }
            return;
        }

        StringBuffer cur = new StringBuffer();
        for(int i = 0; i < 3 && i < s.length(); i++){
            cur.append(s.charAt(i));
            if(cur.length() >= 2 && cur.charAt(0) == '0') return;
            if(Integer.parseInt(cur.toString()) > 255)  return;
            path.add(new String(cur));
            helper(s.substring(i + 1), part - 1);
            path.remove(path.size() - 1);
        }
    }
}