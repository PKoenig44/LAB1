
/**
 * This class represents a furniture item for rent.
 *
 * @author Franklin University
 * @version 2.0
 * Done 1/23/17
 */
public class Furniture implements Item
{
    private String furnDescript;
    private Money weeklyRate; 
    private Money monthlyRate;
    private String furnId;
    private boolean rentalStatus;
    /**
     * Constructor for objects of class Furniture.
     */
    public Furniture()
    {
        this.furnDescript = "Unknown";
        this.weeklyRate = null; 
        this.monthlyRate = null;
        this.furnId = "Unknown";
        this.rentalStatus = false;
    }

    /**
     * Return the description of the furniture.
     * @return the description.
     */
    public String getDescription()
    {
        return furnDescript;
    }

    /**
     * Change the description of the furniture to the
     * given parameter.
     * @param desc the new description.
     */
    public void setDescription(String desc)
    {
        this.furnDescript = desc;
    }

    /**
     * Return the weekly rental rate for the furniture
     * item.
     * @return the rate.
     */
    public Money getWeeklyRate()
    {

        return weeklyRate;
    }

    /**
     * Change the weekly rental rate of the furniture item
     * to the given parameter.
     * @param wklyRate the new weekly rate.
     */
    public void setWeeklyRate(Money wklyRate)
    {
        this.weeklyRate = wklyRate;
    }

    /**
     * Return the ID of the furniture item.
     * @return the ID.
     */
    public String getId()
    {

        return furnId;
    }

    /**
     * Change the ID of the furniture item to the given
     * parameter.
     * @param idNum the new ID.
     */
    public void setId(String idNum)
    {
        this.furnId = idNum;
    }

    /**
     * Calculate the fees for renting the furniture for a given
     * number of weeks. If the number of weeks is 4 or more, the
     * monthly rate is charged for each 4 week period. For example, if
     * the furniture item is rented for 6 weeks, the rental fee will
     * be the monthly fee plus 2 X the weekly fee.  Both the weekly
     * rate and the monthly rate must be set and the number of rental
     * weeks must be valid in order for the fee to be calculated.
     * @param weeks the number of rental weeks
     * @return the fee or null if the fee could not be calculated
     */
    public Money calculateFee(int weeks)
    {
        if ((weeklyRate == null) || (weeks <= 0))
        {
            return null;

        }

        if (weeks >= 4)
        {
            int months = weeks / 4; 
            int remainder = weeks % 4;
            return monthlyRate.mul(months).add(weeklyRate.mul(remainder));

        }

        return weeklyRate.mul(weeks);
    }

    /**
     * Return the monthly rental rate for the furniture
     * item.
     * @return the rate.
     */
    public Money getMonthlyRate()
    {

        return monthlyRate;
    }

    /**
     * Change the monthly rental rate of the furniture item
     * to the given parameter.
     * @param mnthlyRate the new weekly rate.
     */
    public void setMonthlyRate(Money mnthlyRate)
    {
        this.monthlyRate = mnthlyRate;

    }

    /**
     * Indicate the furniture item has been rented.
     */
    public void rented()
    {
        rentalStatus = true;
    }

    /**
     * Indicate the furniture item has been returned and is no
     * longer rented.
     */
    public void returned()
    {
        rentalStatus = false;
    }

    /**
     * Return the rental status of the furniture item.
     * @return true if the furniture item is rented, otherwise false.
     */
    public boolean isRented()
    {
        return rentalStatus;
    }
}
