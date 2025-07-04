// class Solution {
//     public double myPow(double x, int n) {
//         long N = n;
//         if (N < 0) {
//             x = 1 / x;
//             N = -N;
//         }
//         return fastPow(x, N);
//     }

//     private double fastPow(double x, long n) {
//         if (n == 0) return 1.0;
//         double half = fastPow(x, n / 2);
//         if (n % 2 == 0) {
//             return half * half;
//         } else {
//             return half * half * x;
//         }
//     }
// }

class Solution{
    public double myPow(double x, int n){
        long N=n;
        if(N<0){
            x=1/x;
            N=-N;
        }

        double result=1.0;

        while(N>0){
            if((N&1)==1){
                result*=x;
            }
            x*=x;
            N=N>>1;
        }
        return result;
    }
}