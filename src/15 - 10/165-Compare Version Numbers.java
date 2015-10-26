public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int minLen = Math.min(v1.length, v2.length);
        for(int i=0;i<minLen;i++){
        	if(Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])){
        		return 1;
        	}
        	if(Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])){
        		return -1;
        	}
        }
        if(v1.length > minLen){
        	for(int i=minLen;i<v1.length;i++){
        		if(Integer.parseInt(v1[i]) > 0){
        			return 1;
        		}
        	}
        }
        if(v2.length > minLen){
        	for(int i=minLen;i<v2.length;i++){
        		if(Integer.parseInt(v2[i]) > 0){
        			return -1;
        		}
        	}
        }
        return 0;
    }
}