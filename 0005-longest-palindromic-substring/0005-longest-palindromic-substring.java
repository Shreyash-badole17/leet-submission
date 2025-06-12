// class Solution {
//     public String longestPalindrome(String s) {
//         int n=s.length();
//         int remember=0;
//         char[] c=s.toCharArray();
//         for(int i=0;i<=(n-1)/2;i++){
//             if(c[i]==c[n-i-1]){
//                 int trace=i+1;
//                 remember=i;
//                 while(trace<=(n-1)/2){
//                     if(c[trace]==c[n-trace-1]){
//                         trace++;
//                     }
//                     else{
//                         remember=0;
//                         trace=(n-1);
//                         continue;
//                     }
//                 }
//                 if(remember!=0){
//                     break;
//                 }
//             }
//         }
//         StringBuilder sb= new StringBuilder();
//         for(int i=remember;i<=(n-remember-1);i++){
//             sb.append(c[i]);
//         }
//         return sb.toString();
//     }
// }
class Solution {
    // Expand around center approach: O(n^2) time, O(1) space
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);      // odd length
            int len2 = expandAroundCenter(s, i, i + 1);  // even length
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
