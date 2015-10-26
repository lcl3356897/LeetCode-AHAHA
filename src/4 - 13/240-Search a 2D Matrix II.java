public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int rmin = 0, rmax = matrix.length-1, cmin = 0, cmax = matrix[0].length-1;
        return search(matrix, target, rmin, rmax, cmin, cmax);
    }
    public boolean search(int[][] matrix, int target, int rmin, int rmax, int cmin, int cmax){
        if(rmin > rmax || cmin > cmax){
            return false;
        }
        int rmid = rmin + (rmax - rmin) / 2;
        int cmid = cmin + (cmax - cmin) / 2;
        if(matrix[rmid][cmid] == target){
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