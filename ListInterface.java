package inventory;

/**
   An interface for the ADT LIST.
   @author Daniel Esparza
   @version 1.0
 * @param <T>
*/
public interface ListInterface<T>
{
   /** Adds a new entry to the end of this List.
       The list size will increase by 1.
       Other entry positions will be unaffected
       @param item  An object to be added. */
   public void add(T item);
   
    /** Adds a new entry to the specified position of this List.
        The list size will increase by 1.
	All items positions at or below specified position will be effected
	@param position position in list where item will be added
        @param item  An object to be added. 
	@throws IndexOutOfBoundsException if either position < 1 or 
                position > DEFAULT_CAPACITY */
   public void add(int position, T item);
   
   /**  Removes the entry at the specified location.
	All items below on list move up on the list
	The list size will decrease by 1.
	@param position location of the item you would like to remove
        @throws IndexOutOfBoundsException f either position < 1 or 
                position > DEFAULT_CAPACITY */
   public void remove(int position);
   
   /**  Removes all entries from this List. 
	All entries will be effected. */
   public void clear();
   
   /** Verifies if an item is an entry of this List.
       @param position Where on the list we are looking.
       @return Item if item is found or Null if not. */
   public T view(int position);
   
   /** Verifies if an item is an entry of this List.
       @param position Where on the list we are looking.
       @return Item if item is found or Null if not. */
   public boolean contains(T obj);
   
   /**  Detects whether an item is in the List or not.
        @return  True if the item is found, or false otherwise. */
   public boolean isEmpty();
   
}