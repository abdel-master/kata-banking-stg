package fr.stg.banking;

import java.time.LocalDate;

public record Operation(LocalDate date, int amount, int balance) {

    public Operation(int amount, int balance) {
        this(LocalDate.now(), amount, balance);
    }

    @Override
    public String toString() {
        return this.date + "   " + this.amount + "      " + this.balance + "\n";
    }

}
