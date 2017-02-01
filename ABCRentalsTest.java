import org.junit.*;
import static org.junit.Assert.*;
/**
 * The test class ABCRentalsTest.
 *
 * @author  (Patrick Koenig)
 * @version (January 25th, 2017)
 */
public class ABCRentalsTest extends junit.framework.TestCase
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
    public void testConstructorABC()
    {
        ABCRentals abc = new ABCRentals();
        assertNotNull(abc); 
        assertEquals(0, abc.getItemCount());
        
        

    }
    
    /**
     * test the item count.
     * 
     **/
    @Test
    public void testGetItemCount()
    {
        ABCRentals abc = new ABCRentals();

        assertNotNull(abc); 

        assertEquals(0, abc.getItemCount());
        
        DVDPlayer abcDvd = new DVDPlayer();
        Television abcTv = new Television();
        abc.add(abcDvd);
        abc.add(abcTv);
        assertEquals(2, abc.getItemCount());
        
    }

    /**
     * test rent and fee.
     * 
     **/
    @Test
    public void testRentFee()
    {
        ABCRentals abc = new ABCRentals();

        assertNotNull(abc); 
        
        
        DVDPlayer abcDvd = new DVDPlayer();
        abcDvd.setId("Sammy");
        abcDvd.setDescription("Samsung");
        Money fee = new Dollar(9.99);
        abcDvd.setWeeklyRate(fee);
        abcDvd.returned();
        abc.add(abcDvd);
        
        assertEquals(null, abc.rent("Sammy", 1));
       

    }

    /**
     * test find, add, and remove items.
     * 
     **/
    @Test
    public void testFindAddRemoveItems()
    {
        ABCRentals abc = new ABCRentals();

        assertNotNull(abc); 

        String id = "1";
        IdLookup idLookupTest = new IdLookup(id);
        boolean status = false;
        RentalStatusLookup statusTest = new RentalStatusLookup(status);

        DVDPlayer abcDvd = new DVDPlayer();
        abcDvd.setDescription("Samsung");
        abcDvd.setId(id);
        Money rate1 = new Dollar(9.99);
        abcDvd.setWeeklyRate(rate1);
        abcDvd.rented();

        abc.add(abcDvd);
        abc.findItems(idLookupTest);
        assertTrue(idLookupTest.matches(abcDvd));
        abc.findItems(statusTest);
        assertFalse(statusTest.matches(abcDvd));
        
        assertTrue(abcDvd.isRented());

        abc.remove(id);
        assertTrue(idLookupTest.matches(abcDvd));

    }
    /**
     * test find, add, and remove items.
     * 
     **/
    @Test
    public void testRestock()
    {
        ABCRentals abc = new ABCRentals();

        assertNotNull(abc); 

        String id = "1";
        IdLookup idLookupTest = new IdLookup(id);
        boolean status = false;
        RentalStatusLookup statusTest = new RentalStatusLookup(status);

        DVDPlayer abcDvd = new DVDPlayer();
        abc.add(abcDvd);
        abcDvd.rented();
        assertEquals(true, abcDvd.isRented());

        abc.findItems(statusTest);
        assertFalse(statusTest.matches(abcDvd));

        abcDvd.returned();
        assertEquals(false, abcDvd.isRented());
        abc.findItems(idLookupTest);
        assertTrue(idLookupTest.matches(abcDvd));
        abc.findItems(statusTest);
        assertTrue(statusTest.matches(abcDvd));
    }
}
