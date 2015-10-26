//1.分治
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if(len % 2 == 0){
            return ( findKthElement(nums1, 0, nums2, 0, len/2) + findKthElement(nums1, 0, nums2, 0, len/2+1) ) / 2.0;
        }
        else{
            return findKthElement(nums1, 0, nums2, 0, len/2 + 1);
        }
    }

    private double findKthElement(int[] A, int AStart, int[] B, int BStart, int k){
        if(AStart >= A.length){
            return B[BStart + k -1];
        }   
        if(BStart >= B.length){
            return A[AStart + k - 1];
        }
        if(k == 1){
            return Math.min(A[AStart], B[BStart]);
        }

        int AKey = AStart + k/2 - 1 < A.length ? A[AStart + k/2 - 1] : Integer.MAX_VALUE;
        int BKey = BStart + k/2 - 1 < B.length ? B[BStart + k/2 - 1] : Integer.MAX_VALUE;
        if(AKey < BKey){
            return findKthElement(A, AStart + k/2, B, BStart, k - k/2);
        }
        else{
            return findKthElement(A, AStart, B, BStart + k/2, k - k/2);
        }
    }
}