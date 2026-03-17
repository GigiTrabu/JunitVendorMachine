package vendormachine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vendormachine.users.util.Wallet;

public class WalletTEST {
    
private Wallet wallet;
    
    @BeforeEach
    public void setUp() {
        wallet = new Wallet();
    }
    
    @Test
    public void testWalletInitialization() {
        assertNotNull(wallet);
        assertEquals(0.5f, wallet.getAllCredit(), 0);
    }
    
    @Test
    public void testAddMoney() {
        wallet.addCredit(100);
        assertEquals(100.5f, wallet.getAllCredit(), 0);
    }
    
    @Test
    public void testMultipleAddMoney() {
        wallet.addCredit(50);
        wallet.addCredit(75);
        assertEquals(125.5f, wallet.getAllCredit(), 0);
    }
    
    @Test
    public void testWithdrawMoney() {
        wallet.addCredit(100);
        float result = wallet.getCredit(30);
        assertEquals(30, result, 0);
        assertEquals(70.5f, wallet.getAllCredit(), 0);
    }
    
    @Test
    public void testWithdrawMoreThanBalance() {
        wallet.addCredit(50);
        float result = wallet.getCredit(100);
        assertEquals(0, result, 0);
        assertEquals(50.5f, wallet.getAllCredit(), 0);
    }
    
    @Test
    public void testWithdrawZero() {
        wallet.addCredit(100);
        float result = wallet.getCredit(0);
        assertEquals(0, result, 0);
        assertEquals(100.5f, wallet.getAllCredit(), 0);
    }
    
    @Test
    public void testGetBalance() {
        assertEquals(0.5f, wallet.getAllCredit(), 0);
        wallet.addCredit(50);
        assertEquals(50.5f, wallet.getAllCredit(), 0);
    }
    
    @Test
    public void testNegativeWithdraw() {
        wallet.addCredit(100);
        float result = wallet.getCredit(-10);
        assertEquals(-10, result, 0);
        assertEquals(110.5f, wallet.getAllCredit(), 0);
    }
}