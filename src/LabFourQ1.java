import java.util.Scanner;
public class LabFourQ1 {
    //Adding
    public static double addition(double a, double b){
        return a + b;
    }
    //Subtraction
    public static double subtraction(double a, double b){
        return a - b;
    }
    //Division
    public static double division(double a, double b) {
        if (b == 0) { //if its 0
            System.out.println("Error: cannot divide by zero");
            return 0;
        }
        return a / b;
    }
    //Multiplication
    public static double multiplication(double a, double b){
        return a * b;
    }
    public static double power(double num, int exp){
        double result = 1;
        for (int i = 0; i < exp; i++){
            result = result * num;
        }
        return result;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        while (true){ // can run multiple calculations
            System.out.println("Enter Number:    ");
            double numOne = input.nextDouble();

            System.out.print("Enter Second Number:    ");
            double numTwo = input.nextDouble();

            System.out.print("Enter Operation (+,-,*,/,^):     ");
            char operation = input.next().charAt(0);

            double result = 0;

            if (operation == '+') { //goes until it reaches the operation the user selected
                result = addition(numOne, numTwo);
            }else if (operation == '-') {
                result = subtraction(numOne, numTwo);
            }else if (operation == '*') {
                result = multiplication(numOne, numTwo);
            }else if (operation == '/') {
                result = division(numOne, numTwo);
            }else if (operation == '^') {
                result = power(numOne, (int) numTwo);
            }else{
                System.out.print("Not an operation");
                continue;
            }
            System.out.println("Result: " + result);
        }
    }
}
