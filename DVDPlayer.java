
/**
 * This class represents a DVD player to be rented.
 *
 * @author Franklin University
 * @version 2.0
 */
public class DVDPlayer implements Item
{
    private String dvdDescript;
    private Money weeklyRate; 
    private String dvdId;
    private boolean rentalStatus;
    /**
     * Constructor for objects of class DVDPlayer.
     */
    public DVDPlayer()
    {
        this.dvdDescript = "Unknown";
        this.weeklyRate = null; 
        this.dvdId = "Unknown";
        this.rentalStatus = false;
    }

    /**
     * Return the description of the DVD player.
     * @return the description.
     */
    public String getDescription()
    {

        return dvdDescript;
    }

    /**
     * Change the description of the DVD player to the
     * given parameter.
     * @param desc the new description.
     */
    public void setDescription(String desc)
    {
        this.dvdDescript = desc;
    }

    /**
     * Return the weekly rental rate for the DVD player.
     * @return the rate.
     */
    public Money getWeeklyRate()
    {

        return weeklyRate;
    }

    /**
     * Change the weekly rental rate of the DVD player
     * to the given parameter.
     * @param wklyRate the new weekly rate.
     */
    public void setWeeklyRate(Money wklyRate)
    {
        
        (this.weeklyRate) = wklyRate;
        
        
    }

    /**
     * Return the ID of the DVD player.
     * @return the ID.
     */
    public String getId()
    {

        return dvdId;
    }

    /**
     * Change the ID of the DVD player to the given
     * parameter.
     * @param idNum the new ID.
     */
    public void setId(String idNum)
    {
        this.dvdId = idNum;
    }

    /**
     * Calculate the fees for renting the DVD player for a given
     * number of weeks. The weekly rate must be set and the
     * number of rental weeks must be valid in order for the fee
     * to be calculated.
     * @param weeks the number of rental weeks
     * @return the fee or null if the fee could not be calculated
     */
    public Money calculateFee(int weeks)
    {
        if ((weeklyRate == null) || (weeks <= 0))
        {
            return null;
        }
        return weeklyRate.mul(weeks); //multiplies by weeks rented
    }

    /**
     * Indicate the DVD player has been rented.
     */
    public void rented()
    {
        rentalStatus = true;
    }

    /**
     * Indicate the DVD player has been returned and is no
     * longer rented.
     */
    public void returned()
    {
        rentalStatus = false;
    }

    /**
     * Return the rental status of the DVD player.
     * @return true if the DVD player is rented, otherwise false.
     */
    public boolean isRented()
    {
        if (!rentalStatus)
        {
            rentalStatus = false;
            return rentalStatus;
        }
        else
        {
            rentalStatus = true;
            return rentalStatus;
        }
    }
}
