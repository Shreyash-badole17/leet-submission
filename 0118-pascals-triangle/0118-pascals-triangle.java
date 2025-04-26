class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle=new ArrayList<List<Integer>>();
        List<Integer> prevRow = new ArrayList<Integer>();
        if(numRows>0){
            prevRow.add(1);
            triangle.add(prevRow);
            if(numRows==1){
                return triangle;
            }
        }
        
        for(int i=1;i<numRows;i++){
            prevRow=triangle.get(i-1);
            List<Integer> currRow = new ArrayList<Integer>();
            currRow.add(1);
            for(int j=1;j<prevRow.size();j++){
                currRow.add(prevRow.get(j-1) + prevRow.get(j));
            }
            currRow.add(1);
            triangle.add(currRow);
        }
        return triangle;
    }
}