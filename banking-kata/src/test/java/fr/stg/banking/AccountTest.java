package fr.stg.banking;

import fr.stg.banking.service.BankingService;
import fr.stg.banking.service.impl.BankingServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    private static final String PRINTING_STATMENT_HEADER = "Date  Amount  Balance\n";
    private static final String LINE_DEPOSIT_OPERATION = LocalDate.now() + "   500      500\n";
    private static final String LINE_WITHDRAW_OPERATION = LocalDate.now() + "   -100      400";

    BankingService bankingService;

    @Before
    public void setUp() {
        bankingService = new BankingServiceImpl();
    }

    @Test
    public void test_if_deposit_ok() {
        // Given
        Account account = new Account();

        // When
        bankingService.deposit(account, 10);

        // Then
        assertThat(account.getOperations()).isNotNull();
        assertThat(account.getOperations()).hasSize(1);
        assertThat(account.getSold()).isEqualTo(10);
    }

    @Test
    public void test_if_withdraw_ok() {
        // Given
        Account account = new Account();

        // When
        bankingService.withdraw(account, 20);

        // Then
        assertThat(account.getOperations()).isNotNull();
        assertThat(account.getOperations()).hasSize(1);
        assertThat(account.getSold()).isEqualTo(-20);
    }

    @Test
    public void test_if_print_statment_is_ok() {
        // Given
        Account account = new Account();

        // When
        bankingService.deposit(account, 500);
        bankingService.withdraw(account, 100);

        // Then
        assertThat(bankingService.printStatment(account)).isEqualTo(PRINTING_STATMENT_HEADER +
                LINE_DEPOSIT_OPERATION +
                LINE_WITHDRAW_OPERATION);
    }

}
