public class Solution {
    public int mySqrt(int x) {
    	if(x <= 1) return x;
        int left = 0, right = x;
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(x / mid == mid) 
                return mid;
            else if(x / mid < mid)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return right;
    }
}

//Newton
public class Solution {
    public int mySqrt(int x) {
        double eps = 0.000000001;
        double val = x;//最终
        double last;//保存上一个计算的值
        do{
            last = val;
            val = (val + x/val) / 2;
        }while(Math.abs(val - last) > eps);
        return (int)val;
    }
}