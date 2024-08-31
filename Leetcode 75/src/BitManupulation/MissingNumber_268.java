package BitManupulation;

public class MissingNumber_268 {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int xor=0;
        switch (n %4){
            case 1 :{
                xor=1;
                break;
            }
            case 2 : {
                xor=n+1;
                break;
            }
            case 3 : {
                xor=0;
                break;
            }
            case 0 : {
                xor=n;
                break;
            }
        }

        for(int i=0;i<n;i++){
            xor=xor^nums[i];
        }

        return  xor;
    }


    /*
    1 -> 1
    2 -> 3
    3 -> 0
    4 -> 4
    5 -> 1
    6 -> 7
    7 -> 0
    8 -> 8
    9 -> 1
     */
}
