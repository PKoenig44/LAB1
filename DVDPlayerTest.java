import org.junit.*;
import static org.junit.Assert.*;
/**
 * The test class DVDPlayerTest.
 *
 * @author  (Patrick Koenig)
 * @version January 25th, 2017 
 */
public class DVDPlayerTest extends junit.framework.TestCase
{
    private static final String DVD1 = "Samsung";
    private static final String DVD2 = "Sony";
    private static final String ID1 = "ju11111";
    private static final String ID2 = "su22222";

    
    /**
     * test the Constructor.
     * 
     **/
    @Test
    public void testConstructorDVD()
    { 
        DVDPlayer newDvd = new DVDPlayer();

        assertNotNull(newDvd); 

        assertEquals("Unknown", newDvd.getDescription());
        assertNull(null, newDvd.getWeeklyRate());
        assertEquals("Unknown", newDvd.getId());
        assertEquals(false, newDvd.isRented());
    } 

    /**
     * test the weekly rate and rental fee
     * 
     **/
    @Test
    public void testRateandFee()
    { 
        DVDPlayer newDvd = new DVDPlayer();

        assertNotNull(newDvd); 

        Money rate1 = new Dollar();
        newDvd.setWeeklyRate(rate1);

        assertEquals(0.00, newDvd.getWeeklyRate().asDouble(), 0.01);

        Money rate2 = new Dollar(9.99);
        newDvd.setWeeklyRate(rate2);
        assertEquals(9.99, newDvd.getWeeklyRate().asDouble(), 0.01);

        
        assertEquals(19.98, newDvd.calculateFee(2).asDouble(), 0.01);

        assertEquals(49.95, newDvd.calculateFee(5).asDouble(), 0.01);
        
        assertEquals(null, newDvd.calculateFee(0));


    } 

    /**
     * test the rented, returned and rental status
     * 
     **/
    @Test
    public void testRentalStatus()
    { 
        DVDPlayer newDvd = new DVDPlayer();

        assertNotNull(newDvd); 

        newDvd.rented();
        assertEquals(true, newDvd.isRented());

        DVDPlayer myDvd = new DVDPlayer();
        myDvd.returned();
        assertEquals(false, myDvd.isRented());


    } 

    /**
     * test set and get description and id of dvd player
     * 
     **/
    @Test
    public void testDescription()
    { 
        DVDPlayer newDvd = new DVDPlayer();

        assertNotNull(newDvd); 
        assertEquals("Unknown", newDvd.getDescription());

        newDvd.setDescription(DVD1);
        newDvd.setId(ID1);
        assertEquals("Samsung", newDvd.getDescription());
        assertEquals(ID1, newDvd.getId());

        newDvd.setDescription(DVD2);
        newDvd.setId(ID2);
        assertEquals("Sony", newDvd.getDescription());
        assertEquals(ID2, newDvd.getId());

    } 
}
