class Solution {
    public int reverse(int x) {
        int reverse,i=0;
        while(x!=0){
            if(i>(Math.pow(2,31)-1)/10 ||i< Math.pow(-2,31)/10)
            return 0;
            reverse=x%10;
            i=reverse+(10*i);
            x=x/10;
            }
            return i;
    }
}