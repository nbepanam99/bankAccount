package main.java.com.bank.domain;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

public class BankAccountEvent {

    UUID id;
    EventType eventType;
    BigDecimal amount;
    ZonedDateTime occurredAt;

    public BankAccountEvent(UUID randomUUID, EventType eventType, BigDecimal amount, ZonedDateTime zonedDateTime) {
    }

    public static BankAccountEvent depositCash(BigDecimal amount) {
        return new BankAccountEvent(UUID.randomUUID(), EventType.DEPOSIT, amount, ZonedDateTime.now());
    }

    public static BankAccountEvent withdrawCash(BigDecimal amount) {
        return new BankAccountEvent(UUID.randomUUID(), EventType.WITHDRAW, amount, ZonedDateTime.now());
    }

    public UUID getId() {
        return id;
    }

    public EventType getEventType() {
        return eventType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public ZonedDateTime getOccurredAt() {
        return occurredAt;
    }
}
