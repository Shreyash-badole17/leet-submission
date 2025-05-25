class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxc= 0;
        int count=0;
        for(int num : nums){
            if(num == 1){
                count++;
            }
            else{
                if(count>maxc){
                    maxc=count;
                }
                count=0;
            }
        }
        return (count>maxc)? count:maxc;
    }
}
// class Solution {
//     public int findMaxConsecutiveOnes(int[] nums) {
//         int maxc = 0, count = 0;
//         for (int x : nums) {
//             // if x==1 → count = count+1; if x==0 → count = 0
//             count = x * (count + 1);
//             // inline max update
//             maxc = maxc < count ? count : maxc;
//         }
//         return maxc;
//     }
// }