import java.util.Scanner;
public class LabThree {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        int secretNum = 7;

        System.out.println("Guess a Number:  ");
        int guess = input.nextInt();

        while (guess != secretNum){  //while because the user could guess any amount of times
            if (guess > secretNum) {
                System.out.println("Too High! Guess again:   ");
            }else if (guess < secretNum){
                System.out.println("Too Low! Guess again:   ");
            }
            guess = input.nextInt();

        }
        System.out.println("Correct!");

    }
}
