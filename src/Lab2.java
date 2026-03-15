import java.util.Scanner;
public class Lab2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Your Full Name:");
        String fullName = input.nextLine();

        System.out.println("Enter Account Number:");
        String accountNumber = input.nextLine();

        System.out.println("Initial Balance:");
        double initialBalance = input.nextDouble();
        input.nextLine();

        String trimmedName = fullName.trim();
        String upperName = trimmedName.toUpperCase();

        if (accountNumber.length() != 8) {
            System.out.println("Invalid Account Number");
            input.close();
            return;
        }

        if (accountNumber.charAt(0) != '1') {
            System.out.println("Invalid Account Number");
            input.close();
            return;
        }

        for (int i = 0; i < accountNumber.length(); i++) {
            if (!Character.isDigit(accountNumber.charAt(i))) {
                System.out.println("Invalid Account Number");
                input.close();
                return;
            }
        }
        System.out.print("Deposit Amount:  ");
        double deposit = input.nextDouble();
        initialBalance = initialBalance + deposit;

        System.out.println("Withdrawal Amount:  ");
        double withdrawal = input.nextDouble();
        initialBalance = initialBalance - withdrawal;
        input.nextLine();

        System.out.println("Create Four Digit PIN:");
        String pin = input.nextLine();

        if (pin.length() != 4) {
            System.out.println("Incorrect PIN");
            input.close();
            return;
        }
        for (int i = 0; i < pin.length(); i++) {
            if (!Character.isDigit(pin.charAt(i))) {
                System.out.println("Incorrect PIN");
                input.close();
                return;
            }
        }
        System.out.print("Re-enter PIN:  ");
        String reEnteredPin = input.nextLine();

        if (pin.equals(reEnteredPin)) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Incorrect PIN");
        }

        String MaskedAccountNumber = accountNumber.charAt(0) + "XXXXXXX";
        System.out.println("ACCOUNT SUMMARY:");
        System.out.println("------------------------");
        System.out.println("Name: " + upperName);
        System.out.println("Account Number: " + MaskedAccountNumber);
        System.out.printf("Final Balance: $%.2f%n", initialBalance);

        input.close();

    }
}



