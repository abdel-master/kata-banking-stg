package fr.stg.banking.service.impl;

import fr.stg.banking.Account;
import fr.stg.banking.Operation;
import fr.stg.banking.service.BankingService;

public class BankingServiceImpl implements BankingService {

    public static final String PRINTING_STATMENT_HEADER = "Date  Amount  Balance\n";

    @Override
    public void deposit(Account account, int amount) {
        operation(account, amount);
    }

    @Override
    public void withdraw(Account account, int amount) {
        operation(account, -amount);
    }

    @Override
    public String printStatment(Account account) {
        StringBuilder output = new StringBuilder();
        output.append(PRINTING_STATMENT_HEADER);
        for (Operation operation : account.getOperations())
            output.append(operation.toString());
        var out = output.toString();
        return out.substring(0, out.length() -1);
    }

    private void operation(Account account, int amount) {
        int sold = account.getSold();
        sold += amount;
        account.setSold(sold);
        Operation operation = new Operation(amount, sold);
        account.getOperations().add(operation);
    }

}
