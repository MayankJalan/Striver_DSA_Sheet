package BitManupulation;

public class SumofTwoIntegers_371 {
    public int getSum(int a, int b) {
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(a+b));
        while(b !=0){
            int temp=a ^b;
            b=(a&b) <<1;
            a=temp;
        }
        return a;


    }

    public static void main(String[] args) {
        new SumofTwoIntegers_371().getSum(19,11);
    }
}

/*
10011
01011

11000

11110

 */
