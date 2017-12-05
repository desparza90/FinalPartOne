/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import java.util.EmptyStackException;

/**
 *
 * @author despa
 * @param <T>
 */
public class NodeQueue<T> implements QueueInterface<T>{
    
	private Node<T> firstN; 
	private int numberOfEntries = 0;
	private Node<T> front;
	private Node<T> back;


	public NodeQueue()
	{
	} // end constructor
        
        public NodeQueue(T obj)
	{
            firstN = new Node();
            firstN.data = obj;
            firstN.next = null;
            front = firstN;
            back = firstN;
            numberOfEntries++;
	} // end constructor
	
  /** Adds a new entry to the back of this queue.
      @param newEntry  An object to be added. */
        @Override
	public void enqueue(T newEntry)
	{
            if(isEmpty() == true)
            {
                firstN = new Node();
                firstN.data = newEntry;
                firstN.next = null;
                front = firstN;
                back = firstN;
                numberOfEntries++;
            }
            else{
                Node newN = new Node();
                back.next = newN;
                newN.data = newEntry;
                back = newN;
                numberOfEntries++;
            }
	}
	
  /** Removes and returns the entry at the front of this queue.
      @return  The object at the front of the queue. */
        @Override
	public T dequeue()
	{
		if(isEmpty() == true){
                    throw new EmptyStackException();
                }
		else
		{
                    T temp = front.data;
                    if(front.next != null){
                        Node tNode = front;
                        front = front.next;
                        tNode.data = null;
                        tNode = null;
                    }
                    else {
                        front.data = null;
                        front = null;
                        back = null;
                    }
                    numberOfEntries--;
                    return temp;
		}
	}
	
  /**  Retrieves the entry at the front of this queue.
      @return  The object at the front of the queue. */
        @Override
   public T getFront()
   {
       if(isEmpty() == true)
           throw new EmptyStackException();
       return front.data;
   }
   
	/** Detects whether this stack is empty.
    @return  True if the stack is empty. */
        @Override
   public boolean isEmpty()
   {
       return numberOfEntries == 0;
   }
/** Removes all entries from this stack. */
        @Override
   public void clear()
   {
       
	if (!isEmpty())
	{
            firstN = front;
            while(numberOfEntries > 0)
            {
                Node t = firstN;
                firstN.data = null;
                firstN = firstN.next;
                t = null;
                numberOfEntries--;
            }
            firstN.next = null;
        }
   
    }
    
}
