import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //here we can see some examples of the functions in action

        System.out.println("Binary of 42: "+ decimalToBinary(42));
        System.out.println("Decimal of 101010: "+ binaryToDecimal(101010));
        System.out.println("Binary of 17: "+ decimalToBinary(17));
        System.out.println("Decimal of 10001: "+ binaryToDecimal(10001));
        System.out.println("Binary of 25: "+ decimalToBinary(25));
        System.out.println("Decimal of 11001: "+ binaryToDecimal(11001));
        System.out.println("Binary of 300: "+ decimalToBinary(300));
        System.out.println("Decimal of 100101100: "+ binaryToDecimal(100101100));


    }

    public static long decimalToBinary(long n){
        //Example base 10 --> base 2 = 42 --> 101010

        //list to store each number as we divide by 2 and round down when needed, so later we can assign our base 2 to each number in this list(odds are 1 and evens are 0)
        List<Double> decimalStore = new ArrayList<>();

        //we use double here so we can have access to Math.floor()
        double num = n;

        //we store the original number because we will need it later
        decimalStore.add(num);

        //create a strinbuilder so we can append each base 2 number to it later
        StringBuilder append = new StringBuilder();

        //loop to reduce our decimal base 10 down to a binary base 2, storing each number along the way in our list
        while(num > 1){
            //Math.floor() allows us to round down whenever we hit a decimal number, as this is the condition for reaching our final base 2
            num = Math.floor(num/2);
            decimalStore.add(num);
        }

        //we need to reverse here as our list is currently from greatest-> smallest, our base 2 will be assigned from smallest -> greatest
        Collections.reverse(decimalStore);

        //here is where we append our stringbuilder to get the final look of base 2 number(odds get assigned 1 and evens 0)
        for(int i = 0;i<decimalStore.size();i++){
            if(decimalStore.get(i)%2==0){
                //even
                append.append("0");
            }else{
                //odd
                append.append("1");
            }
        }
        //we turn our stringbuilder back to string
        String binary = append.toString();

        //we return an int version of our string to give our final base 2 number(binary).
        return Long.parseLong(binary);
    }

    public static long binaryToDecimal(long n){
        //example we want base 2 --> base 10 = 101010 --> 42
        //we need to get the length of n (binary number) and end at 0; length 6 = 5 --> 0
        //for each number of the length starting at highest(5), we need to find the power of 2 to the length = 2 to the power of 5 (2^5)
        //so if length is 6 and first binary is 1 we get this (1 * 2^5)
        //We do this for every number and add the results of each number together
        // after adding all of them we get our final result of a base 10 decimal number.

        //this will be the list we use to store each base 2 number individually, so later we can find the numbers to multiply by
        List<Long> binaryNumber = new ArrayList<>();

        //this gives us the length of our binary number
        int length = String.valueOf(n).length();

        //here we can add each individual number from our base 2 input and add to our list
        for(int i = 0;i<length;i++){
            binaryNumber.add(n%10);
            n = n/10;
        }

        //we reverse here because our binary is backwards
        Collections.reverse(binaryNumber);

        //this will be the final result additive
        long decimalNum = 0;
        //length of our binary number, so we know which powers to use for each number in our list
        int power = length;

        //here we loop to find all 1's and then perform our operation ex: decimalNum += (1 * 2^5), etc...
        for(int i =0;i<binaryNumber.size();i++){
            power--;
            if(binaryNumber.get(i) != 0){
                decimalNum += (binaryNumber.get(i)) * (Math.pow(2,power));
            }

        }

        //return our final result which gives us our base 10 decimal number
        return decimalNum;
    }
}
