package main.java.com.bank;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("---------------------------------");
        System.out.println("-- Start Project Bank Account  --");
        System.out.println("--");
        System.out.println("-- Select Operation ");
        System.out.println("-- 1 Deposit");
        System.out.println("-- 2 Withdrawal ");
        System.out.println("-- 3 Show history");
        System.out.println("-- ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.close();

        switch (choice) {
            case 1:
                depositOperation();
                break;
            case 2:
                withdrawalOperation();
                break;
            case 3:
                historyOperation("Sunday");
                break;
        }





    }

    private static void historyOperation(String sunday) {
        System.out.println("History : ");
    }

    private static void withdrawalOperation() {
        System.out.println("Enter amount : ");
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        scanner.close();
        System.out.println("Result : ");
    }

    private static void depositOperation() {
        System.out.println("Enter amount : ");
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        scanner.close();



    }
}
