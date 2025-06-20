class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder cur, int open, int close, int max) {
        // 1. If the current string is length 2*n, we've placed all parentheses
        if (cur.length() == max * 2) {
            result.add(cur.toString());
            return;
        }

        // 2. Try adding '(' if we still have some left
        if (open < max) {
            cur.append('(');
            backtrack(result, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);  // backtrack
        }

        // 3. Try adding ')' if it won’t invalidate (must have more '(' than ')' so far)
        if (close < open) {
            cur.append(')');
            backtrack(result, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);  // backtrack
        }
    }
}
