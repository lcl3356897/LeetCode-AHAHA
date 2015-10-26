//Treat it as an one dim array
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
        	return false;
        }
        int left = 0, right = matrix.length * matrix[0].length - 1;
        while(left <= right){
        	int mid = left + (right - left) / 2;
        	int x = mid / matrix[0].length;
        	int y = mid % matrix[0].length;
        	if(matrix[x][y] < target){
        		left = mid + 1;
        	}
        	else if(matrix[x][y] > target){
        		right = mid - 1;
        	}
        	else{
        		return true;
        	}
        }
        return false;
    }
}
//BinarySearch row then BinarySearch column
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
        	return false;
        }
        int top = 0, bottom = matrix.length - 1;
        while(top <= bottom){
        	int mid = top + (bottom - top) / 2;
        	if(matrix[mid][0] < target){
        		top = mid+1;
        	}
        	else if(matrix[mid][0] > target){
        		bottom = mid-1;
        	}
        	else{
        		return true;
        	}
        }
        int row = bottom < 0 ? top : bottom;
        int left = 0, right = matrix[0].length - 1;
        while(left <= right){
        	int mid = left + (right - left) / 2;
        	if(matrix[row][mid] < target){
        		left = mid + 1;
        	}
        	else if(matrix[row][mid] > target){
        		right = mid - 1;
        	}
        	else{
        		return true;
        	}
        }
        return false;
    }
}
//Divide and Conquer
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
        	return false;
        }
        int rmin = 0, rmax = matrix.length - 1, cmin = 0, cmax = matrix[0].length - 1;
        return search(matrix, target, rmin, rmax, cmin, cmax);
    }
    public boolean search(int[][] matrix, int target, int rmin, int rmax, int cmin, int cmax){
    	if(rmin > rmax || cmin > cmax){
    		return false;
    	}
    	int rmid = rmin + (rmax - rmin) / 2;
    	int cmid = cmin + (cmax - cmin) / 2;
    	if(matrix[rmin][cmin] == target || matrix[rmin][cmax] == target || matrix[rmax][cmin] == target || matrix[rmax][cmax] == target || matrix[rmid][cmid] == target){
    		return true;
    	}
    	if(rmin == rmax && cmin == cmax){
    		return false;
    	}
    	if(matrix[rmid][cmid] < target){
    		return search(matrix, target, rmin, rmid, cmid+1, cmax) || search(matrix, target, rmid+1, rmax, cmin, cmid) || search(matrix, target, rmid+1, rmax, cmid+1, cmax);
    	}
    	else{
    		return search(matrix, target, rmin, rmid, cmin, cmid) || search(matrix, target, rmin, rmid, cmid+1, cmax) || search(matrix, target, rmid+1, rmax, cmin, cmid);
    	}
    }
}