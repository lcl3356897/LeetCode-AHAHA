public class ValidWordAbbr {
	Map<String, List<String>> unique;
	
    public ValidWordAbbr(String[] dictionary) {
    	unique = new HashMap<String, List<String>>();
        for(String s : dictionary){
        	String abbr = make(s);
        	if(unique.containsKey(abbr)){
        		unique.get(abbr).add(s);
        	}
        	else{
        		List<String> list = new ArrayList<String>();
        		list.add(s);
        		unique.put(abbr, list);
        	}
        }
    }
    
    private String make(String s){
    	if(s.length() <= 2) return s;
    	else return s.charAt(0) + String.valueOf(s.length() - 2) + s.charAt(s.length() - 1);
    }

    public boolean isUnique(String word) {
        String abbr = make(word);
        if(unique.containsKey(abbr) && (unique.get(abbr).size() > 1 || !unique.get(abbr).contains(word))) return false;
        return true;
    }
}