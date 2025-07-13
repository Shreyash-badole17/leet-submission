class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int i=0,j=0,matches=0;
        int n=players.length,m=trainers.length;
        while(i<n && j<m){
            if(players[i]<=trainers[j]){
                i++;
                j++;
                matches++;
            }
            else{
                j++;
            }
        }
        return matches;
    }
}