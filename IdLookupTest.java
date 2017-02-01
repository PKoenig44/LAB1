import org.junit.*;
import static org.junit.Assert.*;
/**
 * The test class IdLookupTest.
 *
 * @author  (Patrick Koenig)
 * @version (January 23rd, 2017)
 */
public class IdLookupTest extends junit.framework.TestCase
{
   

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
    public void testConstructorIdLookupTest()
    { 
        String id = "DVD";
        IdLookup idLookupTest = new IdLookup(id);

        assertNotNull(idLookupTest);
        
    }
    
       /**
     * test the matches method.
     * 
     **/
    @Test
    public void testMatches()
    { 
        
        
        String id = "DVD";
        IdLookup idLookupTest = new IdLookup(id);

        DVDPlayer newDvd = new DVDPlayer();
        newDvd.setDescription("Samsung");
        newDvd.setId("DVD");
        Money rate1 = new Dollar(9.99);
        newDvd.setWeeklyRate(rate1);
        newDvd.rented();

        assertTrue(idLookupTest.matches(newDvd));
        
        newDvd.returned();
        assertFalse(newDvd.isRented());
        
        String id2 = null;
        IdLookup idLookupTest2 = new IdLookup(id2);
        DVDPlayer newDvd2 = new DVDPlayer();
        
        assertFalse(idLookupTest2.matches(newDvd2));
    }
}

