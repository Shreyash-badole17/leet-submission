class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()<=k) return "0";
        Stack<Character> st= new Stack<>();
        for(char c: num.toCharArray()){
            while(k>0 && !st.isEmpty() && st.peek()>c){
                st.pop();
                k--;
            }
            st.push(c);
        }
        while(k-->0){
            st.pop();
        }

        StringBuilder sb = new StringBuilder();
        for (char c : st) {
            if (sb.length() == 0 && c == '0') continue;
            sb.append(c);
        }
         return sb.length() == 0 
            ? "0" 
            : sb.toString();
    }
}