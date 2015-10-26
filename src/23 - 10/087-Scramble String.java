public class Solution {
	public boolean isScramble(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		char[] arr1 = s1.toCharArray();Arrays.sort(arr1);
		char[] arr2 = s2.toCharArray();Arrays.sort(arr2);
		if(!Arrays.equals(arr1, arr2)) return false;
		if(s1.length() == 1 && s2.length() == 1) return true;
		for(int i=1;i<s1.length();i++){
			boolean rst1 = isScramble(s1.substring(0, i), s2.substring(0, i)) 
					&& isScramble(s1.substring(i, s1.length()), s2.substring(i, s2.length()));
			boolean rst2 = isScramble(s1.substring(0, i), s2.substring(s2.length() - i, s2.length()))
					&& isScramble(s1.substring(i, s1.length()), s2.substring(0, s2.length() - i));
			if(rst1 || rst2) return true;
		}
		return false;
    }
}