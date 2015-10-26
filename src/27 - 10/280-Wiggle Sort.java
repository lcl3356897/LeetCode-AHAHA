public class Solution {
	public void wiggleSort(int[] arr) {
		if(arr == null || arr.length <= 1) return;
		boolean inc = true;
		int prev = arr[0];
		for(int i = 1; i < arr.length; i++){
			if((inc && prev <= arr[i]) || (!inc && prev >= arr[i])){
				arr[i-1] = prev;
				prev = arr[i];
			}
			else{
				arr[i-1] = arr[i];
			}
			inc = !inc;
		}
		arr[arr.length - 1] = prev;
	}
}