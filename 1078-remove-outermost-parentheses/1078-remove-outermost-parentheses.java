// class Solution {
//     public String removeOuterParentheses(String s) {
//         int len = s.length();
//         int start=0,open=0,end=0;
//         StringBuilder sb =new StringBuilder(s);
//         int j=0;
//         for(int i=0;i<len;i++){
//             char c=s.charAt(i);
//             if(c=='('&&start==0){
//                 start=i;
//             }
//             if(c=='('){
//                 open++;
//             }
//             if(c==')'){
//                 open--;
//             }
//             if(c==')'&&open==0){
//                 end=i;
//                 sb.deleteCharAt(start-j*2);
//                 sb.deleteCharAt(end-j*2-1);
//                 j++;
//                 start=0;
//                 end=0;
//             }
//         }
//         return sb.toString();
//     }
// }
class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder str=new StringBuilder();
        int count=0;
        for(char ch:s.toCharArray()){
        if (ch=='('){
            if(count>0){
                str.append(ch);
            }
            count++;

        }
        else if(ch==')'){
            count--;
            if(count>0){
                str.append(ch);

            }
        }   
        }
        return str.toString();
        
    }
}