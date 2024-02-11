class Solution {
    public int mostWordsFound(String[] sentences) {
       int count=1,max=0;
        for(int i=0;i<sentences.length;i++){
            for(int j=0;j<sentences[i].length();j++){
               if(sentences[i].charAt(j)==' '){
                   count++;
                }
                } 
                
                max=Math.max(max,count);
                count=1;
        }
        return max;
    }
}