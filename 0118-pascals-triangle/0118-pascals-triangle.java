class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> map = new ArrayList<>();
        if(numRows<0){
           return map; 
        }
        map.add(new ArrayList<>(List.of(1)));
        for(int i=1;i<numRows;i++){
            List<Integer> prevRow = map.get(i-1);
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for(int j=1;j<i;j++){
                newRow.add(prevRow.get(j-1)+prevRow.get(j));
            }
            newRow.add(1);
            map.add(newRow);
        }
        return map;
    }
}