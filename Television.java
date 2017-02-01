

/**
 * This class represents a television to be rented.
 *
 * @author Franklin University
 * @version 2.0
 * Done 1/23/17
 */
public class Television implements Item
{
    private String tvDescript;
    private Money weeklyRate; 
    private String tvId;
    private String tvType;
    private int tvSize;
    private boolean rentalStatus;
    /**
     * Constructor for objects of class Television.
     */
    public Television()
    {
        this.tvDescript = "Unknown";
        this.weeklyRate = null; 
        this.tvType = "Unknown";
        this.tvId = "Unknown";
        this.tvSize = 0;
        this.rentalStatus = false;
    }

   /**
     * Return the description of the Television.
     * @return the description.
     */
    public String getDescription()
    {
        
        return tvDescript;
    }

    /**
     * Change the description of the television to the
     * given parameter.
     * @param desc the new description.
     */
    public void setDescription(String desc)
    {
        this.tvDescript = desc;
    }

   /**
     * Return the weekly rental rate for the television.
     * @return the rate.
     */
    public Money getWeeklyRate()
    {
        return weeklyRate;
    }

    /**
     * Change the weekly rental rate of the television
     * to the given parameter.
     * @param wklyRate the new weekly rate.
     */
    public void setWeeklyRate(Money wklyRate)
    {
        this.weeklyRate = wklyRate;
    }

    /**
     * Return the ID of the television.
     * @return the ID.
     */
    public String getId()
    {
        return tvId;
    }

    /**
     * Change the ID of the television to the given
     * parameter.
     * @param idNum the new ID.
     */
    public void setId(String idNum)
    {
        this.tvId = idNum;
    }

    /**
     * Calculate the fees for renting the television for a given
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
        return weeklyRate.mul(weeks);
    }

    /**
     * Return the size of the television.
     * @return the size.
     */
    public int getSize()
    {
        
        return tvSize;
    }

    /**
     * Change the size of the television to the given
     * parameter.
     * @param screenSize the new size.
     */
    public void setSize(int screenSize)
    {
        this.tvSize = screenSize;
    }

    /**
     * Return the type of the television.
     * @return the type.
     */
    public String getType()
    {
        
        return tvType;
    }

    /**
     * Change the type of the television to the given
     * parameter.
     * @param screenType the new type.
     */
    public void setType(String screenType)
    {
        this.tvType = screenType;
    }

    /**
     * Indicate the television has been rented.
     */
    public void rented()
    {
        rentalStatus = true;
    }

    /**
     * Indicate the television has been returned and is no
     * longer rented.
     */
    public void returned()
    {
        rentalStatus = false;
    }

    /**
     * Return the rental status of the television.
     * @return true if the television is rented, otherwise false.
     */
    public boolean isRented()
    {
        
        return rentalStatus;
    }
}
