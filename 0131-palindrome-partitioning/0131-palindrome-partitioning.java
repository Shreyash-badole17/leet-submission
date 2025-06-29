class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        DFS(0, s, new ArrayList<>(), result);

        return result;
    }

    private void DFS(int idx, String s, List<String> list, List<List<String>> result) {
        if(idx == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=idx; i<s.length(); i++) {
            String str = s.substring(idx, i+1);

            if(isPalindrome(str)) {
                list.add(str);
                DFS(i + 1, s, list, result);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        
        while( i < j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}