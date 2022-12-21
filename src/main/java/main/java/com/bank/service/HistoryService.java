package main.java.com.bank.service;

import main.java.com.bank.domain.BankAccount;
import main.java.com.bank.domain.Operation;
import main.java.com.bank.usecase.History;

import java.util.List;

public class HistoryService implements History {

    @Override
    public List<Operation> getHistory(BankAccount bankAccount) {
        return bankAccount.getHistory();
    }
}
