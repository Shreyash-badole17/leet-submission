class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        if (n != goal.length()) {
            return false;
        }
        char[] sarr = s.toCharArray();
        char[] garr = goal.toCharArray();
        for (int i = 0; i < n; i++) {
            if (sarr[i] != garr[0]) {
                continue;
            }
            boolean ok = true;
            for (int k = 0; k < n; k++) {
                if (sarr[(i + k) % n] != garr[k]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return true;
            }
        }
        return false;
    }
}

// class Solution {
//     public boolean rotateString(String s, String goal) {
//         if(s.length()!=goal.length()){
//             return false;
//         }
//         int matched=0;
//         char[] sarr=s.toCharArray();
//         char[] garr=goal.toCharArray();
//         for(int i=0;i<s.length();i++){
//             if(sarr[i]==garr[0]&&sarr[s.length()-1]==garr[(s.length()-1)-i]){
//                 matched=i;
//                 break;
//             }
//         }
//         for(int i=matched;i<(s.length()+matched);i++){
//             if(sarr[i%s.length()]!=garr[i-matched]){
//                 return false;
//             }
//         }
//         return true;
//     }
// }