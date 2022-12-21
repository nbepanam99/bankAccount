package main.java.com.bank.usecase;

import main.java.com.bank.domain.BankAccount;
import main.java.com.bank.domain.Operation;

import java.util.List;

public interface History {

    List<Operation> getHistory(BankAccount bankAccount);

}
