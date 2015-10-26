public class Solution {
    public String simplifyPath(String path) {
        StringBuffer cur = new StringBuffer();
        List<String> dir = new ArrayList<String>();
        path += "/";
        for(int i=0;i<path.length();i++){
            if(path.charAt(i) == '/'){
                if(cur.length() == 0){
                    continue;
                }
                else if(cur.toString().equals(".")){
                    cur.delete(0, cur.length());
                }
                else if(cur.toString().equals("..")){
                    if(!dir.isEmpty()) dir.remove(dir.size()-1);
                    cur.delete(0, cur.length());
                }
                else{
                    dir.add(new String(cur));
                    cur.delete(0, cur.length());
                }
            }
            else{
                cur.append(path.charAt(i));
            }
        }
        StringBuffer rst = new StringBuffer();
        if(dir.size() != 0){
            for(int i=0;i<dir.size();i++){
                rst.append( "/" + dir.get(i));
            }
        }
        else{
            rst.append("/");
        }
        return rst.toString();
    }
}