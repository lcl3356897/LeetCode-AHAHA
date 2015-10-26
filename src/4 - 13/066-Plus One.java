public class Solution {
    public int[] plusOne(int[] digits) {
     	int[] rst = new int[digits.length+1];   
     	int next = 0;
     	for(int i=digits.length - 1;i>=0;i++){
     		int tmp = digits[i] + 1 + next;
     		int remin = tmp % 10;
     		next = tmp / 10;
     		rst[digits.length - 1 - i] =  remin;
     	}
     	rst[rst.length - 1] = next;
     	int[] ans;
     	int last;
     	if(rst[rst.length - 1] == 0){
     		last = rst.length-1;
     		ans = new int[rst.length-1];
     	}
     	else{
     		last = rst.length;
     		ans = new int[rst.length];
     	}
     	for(int i=0;i<ans.length;i++){
     		ans[i] = rst[last - 1 - i];
     	}
     	return ans;
    }
}