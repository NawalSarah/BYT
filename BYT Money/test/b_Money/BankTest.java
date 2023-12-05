package b_Money;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BankTest {
    Currency SEK, DKK;
    Bank SweBank, Nordea, DanskeBank;

    @Before
    public void setUp() throws Exception {
        DKK = new Currency("DKK", 0.20);
        SEK = new Currency("SEK", 0.15);
        SweBank = new Bank("SweBank", SEK);
        Nordea = new Bank("Nordea", SEK);
        DanskeBank = new Bank("DanskeBank", DKK);
        SweBank.openAccount("Adam");
        SweBank.openAccount("Sofie");
        Nordea.openAccount("Sofie");
        DanskeBank.openAccount("Gertrud");
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Test: Bank names as expected", "SweBank", SweBank.getName());
    }

    @Test
    public void testGetCurrency() {
        Assert.assertEquals("Test: Currency of bank as expected", "SEK", SweBank.getCurrency().getName());
    }

    @Test
    public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
        DanskeBank.openAccount("Dominik");
        Assert.assertEquals("Test: Account exist after opening", "Dominik", DanskeBank.getAccountFromAccountlist("Dominik").getAccountName());


    }

    @Test
    public void testDeposit() throws AccountDoesNotExistException {
        SweBank.deposit("Sofie", new Money(10000, SEK));
        SweBank.deposit("Sofie", new Money(10000, SEK));
        Assert.assertEquals("Test: Deposits are adding to account", Integer.valueOf(20000), SweBank.getBalance("Sofie"));
    }

    @Test
    public void testWithdraw() throws AccountDoesNotExistException {
        SweBank.deposit("Sofie", new Money(10000, SEK));
        SweBank.withdraw("Sofie", new Money(10000, SEK));
        Assert.assertEquals("TODO", Integer.valueOf(0), SweBank.getBalance("Sofie"));
        //error here(not test error, but printed message in red color), Adam should have 0
        SweBank.withdraw("Sofie", new Money(20000, SEK));
    }

    @Test
    public void testGetBalance() throws AccountDoesNotExistException {
        Assert.assertEquals("Test: Get balance of Adam", Integer.valueOf(0), SweBank.getBalance("Adam"));
    }

    @Test
    public void testTransfer() throws AccountDoesNotExistException {

        SweBank.deposit("Adam", new Money(10000, SEK));
        SweBank.transfer("Adam", "Sofie", new Money(10000, SEK));
        Assert.assertEquals("Test: transfer fromAccount balance", Integer.valueOf(0), SweBank.getBalance("Adam"));
        Assert.assertEquals("Test: transfer toAccount balance", Integer.valueOf(10000), SweBank.getBalance("Sofie"));
        //error here(not test error, but printed message in red color), Sofie should have 0
        SweBank.transfer("Adam", "Sofie", new Money(10000, SEK));
        Assert.assertEquals("Test: transfer fromAccount balance", Integer.valueOf(0), SweBank.getBalance("Adam"));
        Assert.assertEquals("Test: transfer toAccount balance", Integer.valueOf(10000), SweBank.getBalance("Sofie"));
    }

    @Test
    public void testTimedPayment() throws AccountDoesNotExistException {
        SweBank.addTimedPayment("Adam", "1", 10, 5, new Money(100, SEK), SweBank, "Sofie");
        assertTrue("Test: timed payment added", SweBank.getAccountFromAccountlist("Adam").timedPaymentExists("1"));
        SweBank.removeTimedPayment("Adam", "1");
        assertFalse("Test: timed payment remove", SweBank.getAccountFromAccountlist("Adam").timedPaymentExists("1"));
        SweBank.deposit("Adam", new Money(1000, SEK));
        SweBank.addTimedPayment("Adam", "1", 1, 0, new Money(100, SEK), SweBank, "Sofie");
        SweBank.tick();
        SweBank.tick();
        Assert.assertEquals("Test: check balance after timedPayment", Integer.valueOf(900), SweBank.getBalance("Adam"));
        Assert.assertEquals("Test: check balance after timedPayment", Integer.valueOf(100), SweBank.getBalance("Sofie"));

    }
}
