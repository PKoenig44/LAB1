import org.junit.*;
import static org.junit.Assert.*;

/**
 * The test class TelevisionTest. 
 *
 * @author  (Patrick Koenig)
 * @version (1/28/2017)
 */
public class TelevisionTest extends junit.framework.TestCase
{
    private static final String TV1 = "Samsung";
    
    private static final String TYPE1 = "4K";
    
    private static final int SIZE1 = 55;
    
    private static final String ID1 = "1234";
    
    
    
   

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp()
    {
        // Set up
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
    public void testConstructorTV()
    { 
        Television newTv = new Television();

        assertNotNull(newTv); 

        assertEquals("Unknown", newTv.getDescription());
        assertEquals("Unknown", newTv.getType());
        assertEquals("Unknown", newTv.getDescription());
        assertNull(null, newTv.getWeeklyRate());
        assertEquals(0, newTv.getSize());
        assertEquals(false, newTv.isRented());
    } 

    /**
     * test the weekly rate and rental fee
     * 
     **/
    @Test
    public void testRateandFee()
    { 
        Television newTv = new Television();

        assertNotNull(newTv);
        Money rate1 = new Dollar();

        newTv.setWeeklyRate(rate1);
        assertEquals(0.00, newTv.getWeeklyRate().asDouble(), 0.01);
        
        Money rate2 = new Dollar(9.99);
        newTv.setWeeklyRate(rate2);
        assertEquals(9.99, newTv.getWeeklyRate().asDouble(), 0.01);
        
        assertEquals(19.98, newTv.calculateFee(2).asDouble(), 0.01);
        
        assertEquals(49.95, newTv.calculateFee(5).asDouble(), 0.01);
        
        assertEquals(null, newTv.calculateFee(0));
        
    } 
    
    /**
     * test the rented, returned and rental status
     * 
     **/
    @Test
    public void testRentalStatus()
    { 
        Television newTv = new Television();

        assertNotNull(newTv);
        assertNull(null, newTv.getWeeklyRate());
        assertEquals(false, newTv.isRented());
        
        newTv.rented();
        assertEquals(true, newTv.isRented());
        
        Television myTv = new Television();
        myTv.returned();
        assertEquals(false, myTv.isRented());
        
        
        
        


    } 

    /**
     * test set and get description and id of TV player
     * 
     **/
    @Test
    public void testDescription()
    { 
        Television newTv = new Television();

        assertNotNull(newTv); 
        newTv.setDescription(TV1);
        newTv.setType(TYPE1);
        newTv.setSize(SIZE1);
        newTv.setId(ID1);
        assertEquals("Samsung", newTv.getDescription());
        assertEquals("4K", newTv.getType());
        assertEquals(55, newTv.getSize());
        assertEquals("1234", newTv.getId());
       

    } 
}

