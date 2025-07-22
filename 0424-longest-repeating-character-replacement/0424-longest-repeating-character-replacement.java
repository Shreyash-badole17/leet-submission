class Solution {
    public int characterReplacement(String s, int k) {
        int left=0,maxCount=0,maxLen=0,n=s.length();
        int count[]= new int[26];

        for(int right=0;right<n;right++){
            int idx= s.charAt(right)-'A';
            count[idx]++;
            maxCount= Math.max(maxCount,count[idx]);
            while((right-left+1)-maxCount>k){
                count[s.charAt(left)-'A']--;
                left++;
            }
            maxLen= Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }
}