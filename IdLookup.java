
/**
 * This class is a lookup that matches items whose id matches exactly
 * a specified id, to be passed into the constructor when creating
 * the instance of the lookup.
 *
 * @author Franklin University
 * @version 2.0
 */
public class IdLookup implements Lookup
{
    private String lookupId;
    /**
     * Constructor for objects of class IdLookup.
     * @param id the id to lookup.
     */
    public IdLookup(String id)
    {
        lookupId = id;
    }

    /**
     * Indicates whether the item's id exactly matches the id
     * passed into the contructor.
     * @param item the item being checked for a match.
     * @return true if the id of the item matches, otherwise
     * false.
     */
    public boolean matches(Item item)
    {
        String id;
        if (item == null)
        {
            return false;
        }
        id = item.getId();
        if (lookupId == null)
        {

            return false;
        }

        else
        {
            return lookupId.equals(id);
        }
    }
}
