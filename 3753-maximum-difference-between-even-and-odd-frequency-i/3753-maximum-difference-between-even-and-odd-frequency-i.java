class Solution {
    public int maxDifference(String s) {
        HashMap<Integer,Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<c.length;i++){
            map.put(c[i]-'a',map.getOrDefault(c[i]-'a',0)+1);
        }
        for(int i=0;i<c.length;i++){
            int curr = map.get(c[i]-'a');
            if(curr%2==0){
                min = Math.min(min,curr);
            }
            else{
                max= Math.max(max,curr);
            }
        }
        return max-min;
    }
}