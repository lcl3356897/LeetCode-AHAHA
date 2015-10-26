public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(n == 1){return 1;}
        
        int left = 1, right = n;
        while(left < right){
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return right;
    }
}