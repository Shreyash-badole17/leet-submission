class Solution {
    public String minWindow(String s, String t) {
        int m= s.length();
        int n= t.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            char c= t.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int l=0,cnt=0,maxLen=1000000,stidx=-1;
        for(int r=0;r<m;r++){
            char c= s.charAt(r);
            if(map.containsKey(c)){
                if(map.get(c)>0){
                    cnt++;
                }
                map.put(c,map.get(c)-1);
            }
            else{
                map.put(c,-1);
            }
            while(cnt==n){
                if((r-l+1)<maxLen){
                    stidx=l;
                    maxLen=r-l+1;
                }
                char ch=s.charAt(l);
                map.put(ch,map.get(ch)+1);
                if(map.get(s.charAt(l))>0) cnt--;
                l++;
            }
        }
        return stidx==-1?"":s.substring(stidx,stidx+maxLen);
    }
}