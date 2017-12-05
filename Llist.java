package inventory;

public class Llist<T> implements ListInterface<T>
{
	private Node<T> head;	//pointer to beginning of line
	private Node<T> tail;	//pointer to end of line
        private Node<T> point;	//pointer to specific location
        public int num = 0;

	
        
        public Llist()
                {
                    head = null;
                    tail = null;
                    point = null;
                }
        
        public Llist(T item)
                {
                    head = new Node(item, null);
                    tail = head;
                    point = head;
                    num++;
                }
   /** Adds a new entry to the end of this List.
	   The list size will increase by 1.
	   Other entry positions will be unaffected
       @param item  An object to be added. */
        @Override
   public void add(T item)
   {
       if (head == null)
       {
           head = new Node(item,null);
            tail = head;
       }
       else
       {
           Node node = new Node(item, null);
           tail.next = node;
           tail = node;
       }
       num++;
   }
   
      /** Adds a new entry to the specified position of this List.
	   The list size will increase by 1.
	   All items positions at or below specified position will be effected
	   @param position position in list where item will be added
           @param item  An object to be added. 
	   @throws IndexOutOfBoundsException if either position < 1 or 
			   position > DEFAULT_CAPACITY */
        @Override
   public void add(int position, T item)
   {
       if(position > num)
           throw new IndexOutOfBoundsException();
       else
       {
           if (head == null)
           {
               head = new Node(item,null);
               tail = head;
           }
           else
           {
               Node node = new Node(item, null);
               tail.next = node;
               tail = node;
           }
       }   
   }
   
   /** Removes the entry at the specified location.
	   All items below on list move up on the list
	   The list size will decrease by 1.
	   @param position location of the item you would like to remove
       @throws IndexOutOfBoundsException f either position < 1 or 
			   position > DEFAULT_CAPACITY */
        @Override
   public void remove(int position)
   {
       if(position > num)
           throw new IndexOutOfBoundsException();
       else
       {
           Node Tnode = head;
           int temp = 1;
           while (temp != position)
           {
               if(temp == position-1)
                   Tnode = point;
               point = point.next;
               temp++;
           }
           Tnode.next = point.next;
           point.data = null;
           point.next = null;
           point = head;
           num--;
           
       }   
   }
   
   /**  Removes all entries from this List. 
		All entries will be effected. */
        @Override
   public void clear()
   {
       while(head.next != null)
       {
           head.data = null;
           head = head.next;
       }
       head = null;
       tail = null;
       point = null;
   }
   
   /** Verifies if an item is an entry of this List.
	   @param position Where on the list we are looking.
       @return Item if item is found or Null if not. */
        @Override
   public T view(int position)
   {
       T tempd;
       Node Tnode = head;
       int temp = 1;
       while (temp != position)
       {
           point = point.next;
           temp++;
       }
       tempd = point.data;
       point = head;
       return tempd;
   }
   
   /** Verifies if an item is an entry of this List.
     * @param obj
       @return true if item is found or false if not. */
        @Override
   public boolean contains(T obj)
   {
       for(int i = 1; i <= num; i++)
       {
           if(obj == point.data)
               return true;
       }
       
       return false;
   }
   
   /**  Detects whether this dequeue is empty.
       @return  True if the queue is empty, or false otherwise. */
        @Override
   public boolean isEmpty()
   {
            return num <= 0;
   }

   
}