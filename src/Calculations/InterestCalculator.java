package Calculations;

import Models.Interest;

import java.text.NumberFormat;

public class InterestCalculator {

    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;

    public static double calculateMonthlyPayment(Interest interest) {
        float monthlyInterestRate = interest.getInterestRate() / MONTHS_IN_YEAR;
        int numberOfPayments = interest.getLoanTerm() * MONTHS_IN_YEAR;

        double monthlyPayment = interest.getLoanAmount() * (
                (monthlyInterestRate * (Math.pow(1+ monthlyInterestRate, numberOfPayments))) /
                        ((Math.pow(1+ monthlyInterestRate, numberOfPayments)) - 1));


//        float monthlyInterest = interest.getInterestRate() / PERCENT / MONTHS_IN_YEAR;
//
//        double totalNumberOfPayments = interest.getLoanTerm() * MONTHS_IN_YEAR;
//
//        // calculate the monthly interest per month
//        double paymentsPerMonth = Math.pow(1 + monthlyInterest, totalNumberOfPayments);
//        // calculate the mortgage value
//        double interest_1 =  interest.getLoanAmount() * (monthlyInterest * paymentsPerMonth) / (paymentsPerMonth - 1);

        return monthlyPayment;
    }

    public static double calculateTotalPayment(Interest interest) {
        int numberOfPayments = interest.getLoanTerm() * MONTHS_IN_YEAR;

        Double total_payment = calculateMonthlyPayment(interest) * numberOfPayments;

        return total_payment;
    }

    public static double calculateInterest(Interest interest) {
        // Perform interest calculation logic here
        return 0;
    }
}
