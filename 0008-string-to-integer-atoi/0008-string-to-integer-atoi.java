class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        // 1) skip leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        // 2) read optional sign
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') sign = -1;
            i++;
        }
        
        // 3) parse digits
        long result = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');
            // 4) clamp on overflow
            if (sign * result >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign * result <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        
        return sign * (int) result;
    }
}
