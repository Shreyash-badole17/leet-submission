class Solution {
    public int maximumWealth(int[][] accounts) {
        int highwealth=0,curwealth=0;
        for(int i=0;i<accounts.length;i++){
            for(int j=0;j<accounts[0].length;j++){
                curwealth+=accounts[i][j];
            }
            if(highwealth<curwealth){
                highwealth=curwealth;
            }
            curwealth=0;
        }
        return highwealth;
    }
}