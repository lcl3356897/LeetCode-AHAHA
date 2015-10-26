public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null || m < 0 || nums2 == null || n <= 0){
        	return;
        }
        int p1=m-1, p2=n-1, p3=m+n-1;
        while(p1>=0 && p2>=0){
        	nums1[p3--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        while(p1 >= 0){
        	nums1[p3--] = nums1[p1--];
        }
        while(p2 >= 0){
        	nums1[p3--] = nums2[p2--];
        }

    }
}

//正常
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null || m < 0 || nums2 == null || n <= 0){
        	return;
        }
        int p1=0, p2=0;
        while(p2 < n && p1 < m+p2){
        	if(nums1[p1] > nums2[p2]){
        		for(int i=m+p2;i>p1;i--){
        			nums1[i] = nums1[i-1];
        		}
        		nums1[p1++] = nums2[p2++];
        	}
        	else{
        		p1++;
        	}
        }
        if(p1 >= m){
        	for(;p2<n;){
        		nums1[p1++] = nums2[p2++];
        	}
        }
    }
}