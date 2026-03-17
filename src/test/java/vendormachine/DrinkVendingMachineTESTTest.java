package vendormachine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vendormachine.users.Person;
import vendormachine.vendors.DrinkVendingMachine;
import vendormachine.vendors.enums.BRANDS;
import vendormachine.vendors.item.Snack;

public class DrinkVendingMachineTESTTest {
    
    private DrinkVendingMachine machine;
    private Person testUser;
    
    @BeforeEach
    public void setUp() {
        machine = new DrinkVendingMachine(100.0f, BRANDS.CaramelSprinkle);
        testUser = new Person("Test User");
    }
    
    @Test
    public void testConstructorWithParameters() {
        assertNotNull(machine);
        assertEquals(BRANDS.CaramelSprinkle, machine.brandName);
    }
    
    @Test
    public void testConstructorDefault() {
        DrinkVendingMachine defaultMachine = new DrinkVendingMachine();
        assertNotNull(defaultMachine);
        assertNotNull(defaultMachine.brandName);
    }
    
    @Test
    public void testSelectDrinkValidPosition() {
        float initialCredit = machine.availableCredit;
        Snack drink = machine.selectDrink(0);
        assertNotNull(drink);
        assertTrue(machine.availableCredit < initialCredit);
    }
    
    @Test
    public void testSelectDrinkInsufficientCredit() {
        machine = new DrinkVendingMachine(0.5f, BRANDS.CaramelSprinkle);
        Snack drink = machine.selectDrink(0);
        assertNull(drink);
    }
    
    @Test
    public void testSelectDrinkInvalidPosition() {
        assertThrows(IndexOutOfBoundsException.class, () -> machine.selectDrink(999));
    }
    
    @Test
    public void testGiveCredit() {
        float initialCredit = machine.availableCredit;
        machine.giveCredit(testUser, 5.0f);
        assertTrue(machine.availableCredit > initialCredit);
    }
    
    @Test
    public void testGetBrandName() {
        assertEquals(BRANDS.CaramelSprinkle, machine.brandName);
    }
    
    @Test
    public void testGetAvailableCredit() {
        assertEquals(100.0f, machine.availableCredit, 0.01f);
    }
    
    @Test
    public void testSelectDrinkValidPositionDefaultMachine() {
        DrinkVendingMachine defaultMachine = new DrinkVendingMachine();
        float initialCredit = defaultMachine.availableCredit;
        Snack drink = defaultMachine.selectDrink(0);
        assertNotNull(drink);
        assertTrue(defaultMachine.availableCredit < initialCredit);
    }
    
    @Test
    public void testSelectDrinkPosition1DefaultMachine() {
        DrinkVendingMachine defaultMachine = new DrinkVendingMachine();
        float initialCredit = defaultMachine.availableCredit;
        Snack drink = defaultMachine.selectDrink(1);
        assertNotNull(drink);
        assertTrue(defaultMachine.availableCredit < initialCredit);
    }
    
    @Test
    public void testSelectDrinkPosition2DefaultMachine() {
        DrinkVendingMachine defaultMachine = new DrinkVendingMachine();
        float initialCredit = defaultMachine.availableCredit;
        Snack drink = defaultMachine.selectDrink(2);
        assertNotNull(drink);
        assertTrue(defaultMachine.availableCredit < initialCredit);
    }
    
    @Test
    public void testSelectDrinkPosition3DefaultMachine() {
        DrinkVendingMachine defaultMachine = new DrinkVendingMachine();
        float initialCredit = defaultMachine.availableCredit;
        Snack drink = defaultMachine.selectDrink(3);
        assertNotNull(drink);
        assertTrue(defaultMachine.availableCredit < initialCredit);
    }
    
    @Test
    public void testSelectDrinkInvalidPosition4DefaultMachine() {
        DrinkVendingMachine defaultMachine = new DrinkVendingMachine();
        assertThrows(IndexOutOfBoundsException.class, () -> defaultMachine.selectDrink(4));
    }
    
    @Test
    public void testSelectDrinkInvalidPositionNegativeDefaultMachine() {
        DrinkVendingMachine defaultMachine = new DrinkVendingMachine();
        assertThrows(IndexOutOfBoundsException.class, () -> defaultMachine.selectDrink(-1));
    }
    
    @Test
    public void testSelectDrinkInsufficientCreditDefaultMachine() {
        DrinkVendingMachine defaultMachine = new DrinkVendingMachine();
        defaultMachine.availableCredit = 0.5f;
        Snack drink = defaultMachine.selectDrink(0);
        assertNull(drink);
    }
    
    @Test
    public void testGiveCreditZero() {
        float initialCredit = machine.availableCredit;
        machine.giveCredit(testUser, 0.0f);
        assertEquals(initialCredit, machine.availableCredit, 0.01f);
    }
    
    @Test
    public void testGiveCreditNegative() {
        float initialCredit = machine.availableCredit;
        machine.giveCredit(testUser, -5.0f);
        assertEquals(initialCredit, machine.availableCredit, 0.01f); // Assuming it doesn't add negative
    }
    
    @Test
    public void testSelectDrinkAfterSelection() {
        DrinkVendingMachine defaultMachine = new DrinkVendingMachine();
        defaultMachine.selectDrink(0); // Select first
        Snack drink = defaultMachine.selectDrink(0); // Try to select again, assuming removed
        assertNull(drink); // If removed, should be null or throw, but assuming null if position out
    }
}