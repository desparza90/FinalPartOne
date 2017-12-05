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
public class NodeStack<T> implements StackInterface<T> {
	private Node<T> firstN; 
	private int numberOfEntries = 0;
	private Node<T> front;
	private Node<T> back;


	/** Creates an empty stack having a given capacity. */
	public NodeStack()
	{
		firstN = null;
	} // end constructor
        
        public NodeStack(T obj)
        {
            firstN = new Node();
            firstN.data = obj;
            firstN.next = null;
            front = firstN;
            back = firstN;
            numberOfEntries++;
        }
	
	/** Adds a new entry to the top of this stack.
    @param newEntry  An object to be added to the stack. */
        @Override
	public void push(T newEntry)
	{
		if(isEmpty() == true)
            {
                Node node = new Node();
                node.data = newEntry;
                node.next = null;
                front = node;
                back = node;
                numberOfEntries++;
            }
            else{
                Node oldN = back;
                back = new Node();
                back.data = newEntry;
                oldN.next = back;
                numberOfEntries++;
            }
	}
	
	/** Removes and returns this stack's top entry.
    @return  The object at the top of the stack. */
        @Override
	public T pop()
	{
		if(isEmpty() == true)
                    throw new EmptyStackException();
                    //return null;
		else
		{
                    if(front == back){
                        T temp = back.data;
                        front.data = null;
                        front = null;
                        numberOfEntries--;
                        return temp;
                    }
                    
                    T temp = back.data;
                    Node tNode = front;
                    while(tNode.next != back)
                        tNode = tNode.next;
                    back = null;
                    back = tNode;
                    back.next = null;
                    numberOfEntries--;
                    return temp;
		}
			
	}
	
	/** Retrieves this stack's top entry.
    @return  The object at the top of the stack. */
        @Override
   public T peek()
   {
	   if (isEmpty() == true)
           {
               throw new EmptyStackException();
               //return null;
           }
	   else
               return back.data;
   }
   
	/** Detects whether this stack is empty.
    @return  True if the stack is empty. */
        @Override
   public boolean isEmpty()
   {
	   return numberOfEntries == 0;
   }
   
      public int  size()
   {
	   return numberOfEntries;
   }
/** Removes all entries from this stack. */
        @Override
   public void clear()
   {
       if (isEmpty() == false)
	{
            firstN = front;
            while(numberOfEntries > 0)
            {
                Node t = firstN;
                firstN.data = null;
                firstN = firstN.next;
                t.next = null;
                t = null;
                numberOfEntries--;
            }
            firstN.next = null;
        }
   }
   
}
