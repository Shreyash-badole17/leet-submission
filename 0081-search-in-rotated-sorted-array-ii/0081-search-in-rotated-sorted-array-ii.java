class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        boolean result;
        int drop;
        if(nums[n-1]<=nums[0]){
            drop=0;
            for(int i=1;i<n-1;i++){
                if(nums[i]>nums[i+1]){
                    drop=i;
                    break;
                }
            }
            result=binarySearch(nums,target,0,drop);
            if(result==false){
                result=binarySearch(nums,target,drop+1,n-1);
            }
        }
        else{
            result=binarySearch(nums,target,0,n-1);
        }
        return result;      
    }

    boolean binarySearch(int arr[],int x,int low,int high){
        int mid;
        while(low<=high){
            mid=low+(high-low)/2;
            if(arr[mid]==x){
                return true;
            }
            if(arr[mid]<x){
                low=mid+1;
            }
            if(arr[mid]>x){
                high=mid-1;
            }
        }
        return false;
    }
}