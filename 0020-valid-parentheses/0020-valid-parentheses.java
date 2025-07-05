class Solution {
    public boolean isValid(String s) {
        Stack<Character> bar = new Stack<>();
        for(char c : s.toCharArray()){
            switch(c){
                case '(' :
                bar.push(')');
                break;
                
                case '{' :
                bar.push('}');
                break;

                case '[' :
                bar.push(']');
                break;

                default:
                    if(bar.isEmpty()||c!=bar.pop()){
                        return false;
                    }
            }        
        }
        return bar.isEmpty();
    }
}