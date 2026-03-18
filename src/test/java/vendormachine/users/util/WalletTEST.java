package vendormachine.users.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WalletTEST {

    private Wallet wallet;

    @BeforeEach
    public void setUp() {
        wallet = new Wallet();
    }

    @Test
    public void testDefaultConstructor() {
        assertNotNull(wallet);
        assertEquals(0.5f, wallet.getAllCredit(), 0.01f);
        assertEquals("Generic", wallet.getBrand(""));
    }

    @Test
    public void testConstructorWithStartCredit() {
        Wallet wallet2 = new Wallet(10.0f);
        assertNotNull(wallet2);
        assertEquals(10.0f, wallet2.getAllCredit(), 0.01f);
        assertEquals("Generic", wallet2.getBrand(""));
    }

    @Test
    public void testConstructorWithBrandAndCredit() {
        Wallet wallet3 = new Wallet("Premium", 25.5f);
        assertNotNull(wallet3);
        assertEquals(25.5f, wallet3.getAllCredit(), 0.01f);
        assertEquals("Premium", wallet3.getBrand(""));
    }

    @Test
    public void testAddCredit() {
        float initialCredit = wallet.getAllCredit();
        wallet.addCredit(5.0f);
        assertEquals(initialCredit + 5.0f, wallet.getAllCredit(), 0.01f);
    }

    @Test
    public void testAddCreditZero() {
        float initialCredit = wallet.getAllCredit();
        wallet.addCredit(0.0f);
        assertEquals(initialCredit, wallet.getAllCredit(), 0.01f);
    }

    @Test
    public void testGetCreditValid() {
        wallet.setCredit(10.0f);
        float retrieved = wallet.getCredit(5.0f);
        assertEquals(5.0f, retrieved, 0.01f);
        assertEquals(5.0f, wallet.getAllCredit(), 0.01f);
    }

    @Test
    public void testGetCreditExceedsBalance() {
        wallet.setCredit(5.0f);
        float retrieved = wallet.getCredit(10.0f);
        assertEquals(0.0f, retrieved, 0.01f);
        assertEquals(5.0f, wallet.getAllCredit(), 0.01f);
    }

    @Test
    public void testGetCreditExactAmount() {
        wallet.setCredit(5.0f);
        float retrieved = wallet.getCredit(5.0f);
        assertEquals(5.0f, retrieved, 0.01f);
        assertEquals(0.0f, wallet.getAllCredit(), 0.01f);
    }

    @Test
    public void testSetCredit() {
        wallet.setCredit(20.0f);
        assertEquals(20.0f, wallet.getAllCredit(), 0.01f);
    }

    @Test
    public void testSetBrand() {
        wallet.setBrand("Premium");
        assertEquals("Premium", wallet.getBrand(""));
    }

    @Test
    public void testGetAllCredit() {
        wallet.setCredit(15.75f);
        assertEquals(15.75f, wallet.getAllCredit(), 0.01f);
    }
}
