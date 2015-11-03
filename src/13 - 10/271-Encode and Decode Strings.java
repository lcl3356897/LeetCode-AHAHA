public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuffer code = new StringBuffer();
        for(String s : strs){
        	code.append(s.length());
        	code.append("#");
        	code.append(s);
        }
        return code.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> strs = new ArrayList<String>();
        decode(s, strs);
        return strs;
    }
    
    private void decode(String s, List<String> strs){
    	if(s == null || s.length() == 0) return;
    	int len = Integer.parseInt(s.substring(0, s.indexOf("#")));
    	s = s.substring(s.indexOf("#") + 1);
    	strs.add( s.substring(0, len) );
    	s = s.substring(len);
    	decode(s, strs);
    }
}