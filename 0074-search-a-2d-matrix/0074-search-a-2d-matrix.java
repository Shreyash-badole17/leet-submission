class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[] nums = new int[m*n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                nums[(i*(n-1))+(j+i)]=matrix[i][j];
            }
        }
        int right=nums.length-1;
        int left=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }
            else if(nums[mid]>target){
                right=mid-1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}