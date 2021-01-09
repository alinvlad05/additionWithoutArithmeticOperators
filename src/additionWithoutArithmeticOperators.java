public class additionWithoutArithmeticOperators {
    public static void main(String[] args) {
        //Explained here by Alin Vlad
        int a = 1;  //01    will become sum
        int b = 3;  //11    will become carry pos with shift
        int carry = a & b;
        //01 (a)
        //11 (b)
        //__  &
        //01  positions that have a carry ( we left shift one position,becomes next b)

        int sum = a ^ b;
        //01 (a)
        //11 (b)
        //__  ^
        //10  actual addition (becomes next a)

        while (carry != 0) {
            carry = carry << 1;
            a = sum;
            b = carry;
            carry = a & b;
            //10
            //10  is 01 left shifted one position
            //__ &
            //10   positions that have a carry (we left shift one position,becomes next b)
            sum = a ^ b;
            //10
            //10  is 01 left shifted one position
            //__ ^
            //00  actual addition (becomes next a)
        }

        //Last iteration

        //000
        //100
        //__ &
        //000 positions that have a carry(there is nothing to carry)  while loop ends

        //000
        //100  is 10 left shifted one position
        //__ ^
        //100  actual addition;FINAL VALUE (no more becoming next a because while loop ended)
        System.out.println(sum);
    }
}


