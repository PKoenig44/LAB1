import org.junit.*;
import static org.junit.Assert.*;
/**
 * The test class FurnitureTest. 
 *
 * @author  (Patrick Koenig)
 * @version (1/28/2017)
 */
public class FurnitureTest extends junit.framework.TestCase
{
    private static final String FURN1 = "Chair";
    private static final String FURN2 = "Couch";
    private static final String ID1 = "chair123";
    private static final String ID2 = "couch123";
    

   
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp()
    {
        // Set Up
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown()
    {
        // Tear down
    }

    /**
     * test the Constructor.
     * 
     **/
    @Test
    public void testConstructorFurn()
    { 
        Furniture newFurn = new Furniture();

        assertNotNull(newFurn); 

        assertEquals("Unknown", newFurn.getDescription());
        assertNull(null, newFurn.getWeeklyRate());
        assertEquals("Unknown", newFurn.getId());
        assertEquals(false, newFurn.isRented());
    }

    /**
     * test the weekly rate and rental fee
     * 
     **/
    @Test
    public void testRateandFee()
    { 
        Furniture newFurn = new Furniture();

        assertNotNull(newFurn); 

        Money rate1 = new Dollar();
        newFurn.setWeeklyRate(rate1);

        assertEquals(0.00, newFurn.getWeeklyRate().asDouble(), 0.01);

        Money rate2 = new Dollar(9.99);
        Money month1 = new Dollar(5.00);
        newFurn.setMonthlyRate(month1);
        newFurn.setWeeklyRate(rate2);
        assertEquals(9.99, newFurn.getWeeklyRate().asDouble(), 0.01);

        assertEquals(19.98, newFurn.calculateFee(2).asDouble(), 0.01);
        
        assertEquals(5.00, newFurn.calculateFee(4).asDouble(), 0.01);
        
        assertEquals(24.98, newFurn.calculateFee(6).asDouble(), 0.01);
        
        assertEquals(10.00, newFurn.calculateFee(8).asDouble(), 0.01);
        
        assertEquals(19.99, newFurn.calculateFee(9).asDouble(), 0.01);
        
        assertEquals(54.97, newFurn.calculateFee(23).asDouble(), 0.01);
        
        assertEquals(null, newFurn.calculateFee(0));
        
        
        
    }

    /**
     * test the rented, returned and rental status
     * 
     **/
    @Test
    public void testRentalStatus()
    { 
        Furniture newFurn = new Furniture();

        assertNotNull(newFurn); 

        newFurn.rented();
        assertEquals(true, newFurn.isRented());

        Furniture furn1 = new Furniture();
        furn1.returned();
        assertEquals(false, furn1.isRented());

        
    } 
    
    /**
     * test set and get description and id of dvd player
     * 
     **/
    @Test
    public void testDescription()
    { 
        Furniture newFurn = new Furniture();

        assertNotNull(newFurn); 
        assertEquals("Unknown", newFurn.getDescription());

        newFurn.setDescription(FURN1);
        newFurn.setId(ID1);
        assertEquals("Chair", newFurn.getDescription());
        assertEquals(ID1, newFurn.getId());

        newFurn.setDescription(FURN2);
        newFurn.setId(ID2);
        assertEquals("Couch", newFurn.getDescription());
        assertEquals(ID2, newFurn.getId());

    }
}
