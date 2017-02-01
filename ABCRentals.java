/**
 * An implementation of the inventory system for ABC Rentals.
 *
 * @author Franklin University
 * @version 2.0
 * Done 1/19/2017
 */
public class ABCRentals implements Inventory
{
    private Item[] items;
    private int numItems = 0;
    private int nextId = 1;
    /**
     * Default constructor.
     */
    public ABCRentals()
    {
        items = new Item[MAX_ITEMS];
    }

    /**
     * Add an item to the inventory.  The parameter item
     * should not be something already in the inventory.  As a
     * result of adding an item, the item will be assigned an ID starting
     * with 1 and increasing by 1 for each item added.  IDs
     * are not reused.  All items are kept
     * in a database internal to the inventory so that they may be searched
     * for using a query.
     * @param item the item to add.
     * @return true when the item is added, false if the item cannot
     * be added for any reason.
     */
    public boolean add(Item item)
    {
        if ((item != null) && (numItems < items.length))
        {
            items[numItems++] = item;
            item.setId("" + nextId++);
            return true;
        }
        return false;
    }

    /**
     * Remove an item.  The id should be the id of
     * an item in the inventory.  The item with the
     * specified id is located in inventory and removed.
     * @param id the id of the item to remove.
     * @return true if the item was found and removed, false otherwise.
     */
    public boolean remove(String id)
    {
        for (int i = 0 ; i < numItems ; i++ )
        {
            Item stock = items[i];

            if (stock.getId().equals(id))
            {
                items[i] = null;
                for (int j = i ; j < (numItems - 1) ; j++ )
                {
                    items[j] = items[j + 1]; 
                }
                items[numItems - 1] = null; 

                numItems--; 

                return true;
            }
        }
        return false;
    }

    /**
     * Return the number of items presently in inventory.
     * @return the number of items.
     */
    public int getItemCount()
    {
        return numItems;
    }

    /**
     * Create and return an array of items that match the given query
     * criteria.  The query will identify which items match.  The length
     * of the returned array should be equal to the number of items
     * that match, and each element in the array should be a matching
     * item.
     * @param query a query indicating which items to find.
     * @return an array of matching items.
     */
    public Item [] findItems(Lookup query)
    {
        int count = 0;
        for (int i = 0 ; i < numItems ; i++ )
        {
            Item stock = items[i]; //stock is item in inventory
            if (query.matches(stock))
            {
                count++;
            }
        }

        Item[] result = new Item[count];

        int resultPosition = 0;

        for (int i = 0 ; i < numItems ; i++ )
        {
            Item stock = items[i];
            if (query.matches(stock))
            {
                result[resultPosition++] = stock;
            }
        }
        
        return result;

    }

    /**
     * Rent an item in inventory. The rental fee for the item is
     * calculated, and the item is marked as rented.
     * @param id the id of the item to be rented.
     * @param weeks the number of weeks the item is to be rented.
     * @return the rental fee if the item was available for rent,
     * null otherwise.
     */
    public Money rent(String id, int weeks)
    {
        for (int i = 0 ; i < numItems ; i++ )
        {
            Item stock = items[i];
            if (stock.getId().equals(id))
            {
                if (stock.isRented())
                {
                    //item has already been rented
                    return null;
                }

                Money fee = stock.calculateFee(weeks);
                stock.rented();
                return fee;
            }
        }
        return null;
    }

    /**
     * Return an item to inventory. The item is marked as not
     * rented. Note that if the item isn't already rented, it cannot
     * be restocked.
     * @param id the id of the restocked item.
     * @return true if the item was sucessfully returned to inventory,
     * false otherwise.
     */
    public boolean restock(String id)
    {
        for (int i = 0 ; i < numItems ; i++ )
        {
            Item stock = items[i];
            if (stock.getId().equals(id))
            {
                if (stock.isRented())
                {
                    stock.returned();
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * Returns true if the objects are both null,
     * or comparing them with equals() returns true.
     * @param o1 object 1
     * @param o2 object 2
     * @return the result
     */
    public static boolean nullSafeEquals(Object o1, Object o2) 
    {
        if (o1 == null) {
            return o2 == null;
        }

        if (o2 == null) {
            return false;
        }

        return o1.equals(o2);
    }
}
