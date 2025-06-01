class Solution {
    public int search(int[] nums, int target) {
        int result= binarySearch(nums,target);
        return result;
    }
    int binarySearch(int arr[],int x){
        int n= arr.length;
        int low=0,high = n-1,mid;
        while(low<=high){
            mid=low + (high-low)/2;
            if(arr[mid]==x){
                return mid;
            }
            if(arr[mid]<x){
                low=mid+1;
            }
            if(arr[mid]>x){
                high=mid-1;
            }
        }
        return -1;
    }
}