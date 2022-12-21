package main.java.com.bank;

import main.java.com.bank.domain.BankAccount;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    private static BankAccount bankAccount;

    public static void main(String[] args) {
        bankAccount = new BankAccount();
        Scanner scanner = new Scanner(System.in);
        int selection=0;
        var msg = """
                ---------------------------------
                   -- 1 Deposit
                   -- 2 Withdrawal
                   -- 3 Show history
                   -- 4 Quit
                """;

        do {
            System.out.println(msg);
            selection = scanner.nextInt();
            switch (selection) {
                case 1 : {
                    System.out.println("Please enter amount");
                    double amount = scanner.nextDouble();
                    depositOperation(amount);
                    break;
                }
                case 2 : {
                    System.out.println("Please enter amount");
                    double amount = scanner.nextDouble();
                    withdrawalOperation(amount);
                    break;
                }
                case 3  :{
                    historyOperation();
                    break;
                }
                default:
                    System.out.println("Quit");
            }

        } while (selection < 4);


    }

    private static void historyOperation() {
        System.out.println("History : ");
        bankAccount.getHistory().forEach(operation -> System.out.println(
                " Date : "+ operation.getDate() + " : " +operation.getType() + ", amount : " + operation.getAmount() + ", balance: " + operation.getBalance()
        ));
    }

    private static void withdrawalOperation(Double amount) {
        bankAccount.withdraw(new BigDecimal(amount));
        System.out.println("Result : ");
    }

    private static void depositOperation(Double amount) {
        bankAccount.deposit(new BigDecimal(amount));


    }
}
