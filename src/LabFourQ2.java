import java.util.Scanner;
public class LabFourQ2 {
    public static boolean isEven(int num){
        return num % 2 == 0; //no remainder after dividing by 2
    }
    public static boolean isPrime(int num){
        if (num <= 1) { //less than or equal to one not prime
            return false;
        }
        for (int i = 2; i < num; i++){ //
            if (num % i == 0){ //cannot be divisible by any other number
                return false;
            }
        }
        return true;
    }
    public static int getFactorial(int num){
        int result = 1;
        for (int i = 1; i <= num; i++){  //multiply num by 1 through num
            result *= i;
        }
        return result;
    }
    public static int sumOfDigits(int num){
        int sum = 0;

        while (num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public static int reverseNumber(int num){
        int reverse = 0;
        while (num > 0){
            reverse = reverse * 10 + (num % 10);
            num /= 10;
        }
        return reverse;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Number:  ");
        int number = input.nextInt();
        //returns to each method and prints output
        System.out.println("Is Even?:" + isEven(number));
        System.out.println("Is Prime?:" + isPrime(number));
        System.out.println("Factorial:" + getFactorial(number));
        System.out.println("Sum of Digits:" + sumOfDigits(number));
        System.out.println("Reversed Number:" + reverseNumber(number));
    }
}
