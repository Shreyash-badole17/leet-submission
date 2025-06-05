class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length;
        int[] nums3=new int[m+n];
        int o=m+n;
        int i=0,j=0,k=0;
        while(i<m&&j<n){
            if(nums1[i]<=nums2[j]){
                nums3[k++]=nums1[i++];
            }
            else{
                nums3[k++]=nums2[j++];
            }
        }
        while(i<m){
            nums3[k++]=nums1[i++];
        }
        while(j<n){
            nums3[k++]=nums2[j++];
        }
        if((o)%2==1){
            return nums3[o/2];
        }
        else{
            double median = (double)(nums3[o/2]+nums3[(o/2)-1])/2;
            return median;
        }
    }
}