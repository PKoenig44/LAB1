import org.junit.*;
import static org.junit.Assert.*;
/**
 * The test class RentalStatusLookupTest. 
 *
 * @author  (Patrick Koenig)
 * @version (January 23rd, 2017)
 */
public class RentalStatusLookupTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class RentalStatusLookupTest.
     */
    public RentalStatusLookupTest()
    {
        // Default constructor
    }

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
    public void testConstructorRentalStatuslookup()
    { 
        boolean status = true;
        RentalStatusLookup rentalStatusTest = new RentalStatusLookup(status);

        assertNotNull(rentalStatusTest);
    }

    /**
     * test the matches method.
     * 
     **/
    @Test
    public void testMatches()
    { 
        
        
        boolean status = true;
        Lookup rentalStatusTest = new RentalStatusLookup(status);

        DVDPlayer newDvd = new DVDPlayer();
        newDvd.setDescription("Samsung");
        newDvd.setId("Sammy");
        Money rate1 = new Dollar(9.99);
        newDvd.setWeeklyRate(rate1);
        newDvd.rented();

        assertTrue(rentalStatusTest.matches(newDvd));
        
        newDvd.returned();
        assertFalse(newDvd.isRented());
        
        boolean status2 = true;
        Lookup rentalStatusTest2 = new RentalStatusLookup(status2);

        DVDPlayer newDvd2 = new DVDPlayer();
        
        assertFalse(rentalStatusTest2.matches(newDvd2));
    }
}

