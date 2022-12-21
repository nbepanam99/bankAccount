package main.java.com.bank;

import main.java.com.bank.domain.BankAccount;
import main.java.com.bank.domain.Operation;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static BankAccount bankAccount;
    private static final DateTimeFormatter formatters=DateTimeFormatter.ofPattern("d/MM/uuuu HH:mm");

    public static void main(String[] args) {

        bankAccount = new BankAccount();
        Scanner scanner = new Scanner(System.in);
        int selection;
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
                case 1 -> {
                    System.out.println("Please enter amount");
                    double amount = scanner.nextDouble();
                    try {
                        depositOperation(amount);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.println("Please enter amount");
                    double amount = scanner.nextDouble();
                    try {
                        withdrawalOperation(amount);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                }
                case 3 -> historyOperation();
                default -> System.out.println("Quit");
            }

        } while (selection < 4);


    }

    private static void historyOperation() {
        System.out.println("History : ");
        List<Operation> history = bankAccount.getHistory();
        history.forEach(operation -> System.out.println(
                " Date : "+ operation.getDate().format(formatters) + " : " + String.format("%1$"+10+ "s", operation.getType())
                        + ", amount : " + operation.getAmount()
        ));

        System.out.println("Balance : "+ history.get(history.size()-1).getBalance() +"€") ;


    }

    private static void withdrawalOperation(Double amount) {
        bankAccount.withdraw(new BigDecimal(amount));
    }

    private static void depositOperation(Double amount) {
        bankAccount.deposit(new BigDecimal(amount));


    }
}
