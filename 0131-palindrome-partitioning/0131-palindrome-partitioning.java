import java.util.*;

public class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        // 1. Precompute palindrome table
        boolean[][] isPal = new boolean[n][n];
        for (int end = 0; end < n; end++) {
            for (int start = 0; start <= end; start++) {
                if (s.charAt(start) == s.charAt(end) 
                    && (end - start < 2 || isPal[start + 1][end - 1])) {
                    isPal[start][end] = true;
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>();
        backtrack(s, 0, isPal, path, result);
        return result;
    }

    private void backtrack(String s, int start, boolean[][] isPal,
                           Deque<String> path, List<List<String>> result) {
        int n = s.length();
        if (start == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int end = start; end < n; end++) {
            if (!isPal[start][end]) continue;
            // choose substring s[start..end]
            path.addLast(s.substring(start, end + 1));
            backtrack(s, end + 1, isPal, path, result);
            path.removeLast();
        }
    }
}
