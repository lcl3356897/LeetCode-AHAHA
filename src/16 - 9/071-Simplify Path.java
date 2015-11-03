public class Solution {
    public String simplifyPath(String path) {
        List<String> dir = new ArrayList<String>();
        StringBuffer cur = new StringBuffer();
        path += "/";
        for(int i = 0; i < path.length();i++){
            if(path.charAt(i) == '/'){
                if(cur.toString().equals(".") || cur.length() == 0){
                    
                }
                else if(cur.toString().equals("..")){
                    if(!dir.isEmpty()) dir.remove(dir.size() - 1);
                }
                else{
                    dir.add(new String(cur));
                }
                cur.delete(0, cur.length());
            }
            else{
                cur.append(path.charAt(i));
            }
        }   
        StringBuffer rst = new StringBuffer();
        rst.append("/");
        for(int i = 0; i < dir.size(); i++){
            rst.append(dir.get(i));
            if(i != dir.size() - 1) rst.append("/");
        }
        return rst.toString();
    }
}