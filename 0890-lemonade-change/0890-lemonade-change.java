class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveDollarBills = 0, tenDollarBills = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveDollarBills++;
            } else if (bills[i] == 10) {
                if (fiveDollarBills <= 0) {
                    return false;
                }

                fiveDollarBills--;
                tenDollarBills++;
            } else {
                if (fiveDollarBills > 0 && tenDollarBills > 0) {
                    fiveDollarBills--;
                    tenDollarBills--;
                } else if (fiveDollarBills >= 3) {
                    fiveDollarBills -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}

// class Solution {
//     public boolean lemonadeChange(int[] bills) {
//         int len= bills.length;
//         int collection=0;
//         int[] dollar= new int[21];

//         for(int i=0;i<len;i++){
//             switch(bills[i]){
//                 case 5:
//                 collection+=bills[i];
//                 dollar[bills[i]]++;
//                 break;

//                 case 10:
//                 collection+=bills[i];
//                 dollar[bills[i]]++;
//                 if(dollar[5]>0){
//                     dollar[5]--;
//                 }
//                 else{
//                     return false;
//                 }
//                 break;

//                 case 20:
//                 collection+=bills[i];
//                 dollar[bills[i]]++;
//                 if(dollar[10]>0&&dollar[5]>0){
//                     dollar[10]--;
//                     dollar[5]--;
//                 }
//                 else if(dollar[5]>2){
//                     dollar[5]-=3;
//                 }
//                 else{
//                     return false;
//                 }
//                 break;

//                 default:
//                 return false;
//             }

//         }
//         return true;
//     }
// }
