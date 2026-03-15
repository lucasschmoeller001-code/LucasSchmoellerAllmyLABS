import java.util.Scanner;
public class LabThreeQ2 {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        int nextNum = Integer.MIN_VALUE; //

        int i = 1;
        for (i = 1; i <= 5; i++){  //loop that continues until user inputs a number 5 times
            System.out.println("Enter a Number:");
            int numB = input.nextInt();

        if (numB > nextNum) {
            nextNum = numB;    // when numB is smaller than the next number, the next number replaces it
        }
        }
        System.out.println("The largest number is:" + nextNum);



    }
}
