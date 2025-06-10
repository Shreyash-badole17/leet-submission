// class Solution {
//     public boolean isIsomorphic(String s, String t) {
//         HashMap<Character,Character> map =new HashMap<>();  
//         char[] c=s.toCharArray();
//         char[] ch=t.toCharArray();
//         for(int i=0;i<s.length();i++){
//             if(map.containsKey(c[i])){
//                 char val= map.get(c[i]);
//                 if(val==ch[i]){
//                     continue;
//                 }
//                 return false;
//             }
//             else if(map.containsValue(ch[i]))return false;
//             else{
//                 map.put(c[i],ch[i]);
//             }
//         }
//         return true; 
//     }
// }
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
			return false;
		}
		int hash[] = new int[256];
		boolean ismapped[] = new boolean[256];
		for (int i = 0; i < s.length(); i++) {
			char s1 = s.charAt(i);
			char s2 = t.charAt(i);
			if (hash[s1] == 0) {
				if (ismapped[s2 ]) {
					return false;
				}
				hash[s1] = s2;
				ismapped[s2] = true;
			} else {
				if (hash[s1] != s2) {
					return false;
				}
			}
		}
		return true;
    }
}