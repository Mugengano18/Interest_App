package App;

import Calculations.InterestCalculator;
import JSON.JSONFileHandler;
import Models.Interest;

import java.text.NumberFormat;
import java.util.Scanner;

public class InterestApp {
    public static void main(String[] args) {
        final int PRINCIPAL_MIN = 1000;
        final int PRINCIPAL_MAX = 50_000_000;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter borrower name: ");
        String borrowerName = scanner.nextLine();


        int loanAmount  = (int) readNumber("Enter loan amount: ", PRINCIPAL_MIN, PRINCIPAL_MAX);


        float annualInterest = (float) readNumber("Enter Annual Interest Rate: ", 1, 30);


        int loanTerm = (int) readNumber("Enter loan term (in years): ", 1, 30);

        Interest interestInput = new Interest(borrowerName,loanAmount,annualInterest,loanTerm);
        // Save mortgage details to JSON file
        JSONFileHandler.saveToFile("interest.json", interestInput);

        double monthlyPayment = InterestCalculator.calculateMonthlyPayment(interestInput);
        double totalPayment = InterestCalculator.calculateTotalPayment(interestInput);
        double interest = InterestCalculator.calculateInterest(interestInput);

        System.out.println("Monthly Payment: " + NumberFormat.getCurrencyInstance().format(monthlyPayment));
        System.out.println("Total Payment: $" + NumberFormat.getCurrencyInstance().format(totalPayment));
        System.out.println("Total Interest: $" + interest);

        scanner.close();
    }

    private static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if(value >= min && value <= max) {
                break;
            }
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }
}
