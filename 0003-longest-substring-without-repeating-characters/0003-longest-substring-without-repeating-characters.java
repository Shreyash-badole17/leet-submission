class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n= s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int left=0;
        int maxLen=0,len=0;
        for(int right=0;right<n;right++){
            char c = s.charAt(right);
            if(!map.containsKey(c)){
                len=right-left+1;
                map.put(c,right);
            }
            else{
                left=Math.max(left,map.get(c)+1);
                len=right-left+1;
                map.put(c,right);
            }
            maxLen=Math.max(maxLen,len);
        }
        return maxLen;
    }
}

// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int n = s.length();
//         Map<Character, Integer> lastIndex = new HashMap<>();
//         int maxLen = 0;
//         int left = 0;

//         for (int right = 0; right < n; right++) {
//             char c = s.charAt(right);

//             // If we've seen c before, move left forward—but never backward
//             if (lastIndex.containsKey(c)) {
//                 left = Math.max(left, lastIndex.get(c) + 1);
//             }

//             // Record the latest index of c
//             lastIndex.put(c, right);

//             // Update maxLen with the size of the current window [left..right]
//             maxLen = Math.max(maxLen, right - left + 1);
//         }

//         return maxLen;
//     }
// }
