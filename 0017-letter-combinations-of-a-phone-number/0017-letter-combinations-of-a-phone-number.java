class Solution {
    public static final String[] KEYPD={
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits==null||digits.isEmpty()) return res;
        Loop(res,0,digits,new StringBuilder());
        return res;
    }
    void Loop(List<String> res,int curr,String digits,StringBuilder sb){
        if(digits.length()==curr){
            res.add(sb.toString());
            return;
        }

        char digitchar = digits.charAt(curr);
        String letters = KEYPD[digitchar-'0'];

        for(char c: letters.toCharArray()){
            sb.append(c);
            Loop(res,curr+1,digits,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}