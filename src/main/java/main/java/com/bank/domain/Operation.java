package main.java.com.bank.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Operation {

    private UUID uuid;
    private EventType type;
    private LocalDateTime date;
    private BigDecimal amount;
    private BigDecimal balance;

    public Operation(EventType deposit, BigDecimal amount, BigDecimal balance) {
        this.uuid = UUID.randomUUID();
        this.type = deposit;
        this.date = LocalDateTime.now();
        this.amount = amount;
        this.balance = balance;
    }

    public UUID getUuid() {
        return uuid;
    }

    public EventType getType() {
        return type;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return Objects.equals(uuid, operation.uuid) && type == operation.type && Objects.equals(date, operation.date) && Objects.equals(amount, operation.amount) && Objects.equals(balance, operation.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, type, date, amount, balance);
    }

    @Override
    public String toString() {
        return "Operation{" +
                "uuid=" + uuid +
                ", type=" + type +
                ", date=" + date +
                ", amount=" + amount +
                ", balance=" + balance +
                '}';
    }
}
