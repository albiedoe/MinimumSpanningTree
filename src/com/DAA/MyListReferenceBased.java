package com.DAA;
// Please note that this code is slightly different from the textbook code
// //to reflect the fact that the Node class is implemented using data encapsulation
//
//
// // ****************************************************
// // Reference-based implementation of ADT list.
// // ****************************************************
public class MyListReferenceBased implements ListInterface
{
// reference to linked list of items
    private Node head;


    public MyListReferenceBased()
    {
        head = null;
    }  // end default constructor

    public boolean isEmpty()
    {
        return size() == 0;
    }  // end isEmpty

    private Node find(int index)
    {
// --------------------------------------------------
// Locates a specified node in a linked list.
// Precondition: index is the number of the desired
// node. Assumes that 0 <= index <= numItems
// Postcondition: Returns a reference to the desired
// node.
// --------------------------------------------------
        Node curr = head;
        for (int skip = 0; skip < index; skip++)
        {
            curr = curr.getNext();
        } // end for
        return curr;
    } // end find

    public Object get(int index)
    throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < size())
        {
// get reference to node, then data in node
            Node curr = find(index);
            Object dataItem = curr.getEdge();
            return curr;
        }
        else
        {
            throw new ListIndexOutOfBoundsException(
                "List index out of bounds exception on get");
        } // end if
    } // end get

    public void add(int index, Object item)
    throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < size()+1)
        {
            if (index == 0)
            {
                // insert the new node containing item at
                // beginning of list
                Node newNode = new Node((Edge) item, head);
                head = newNode;
            }
            else
            {
                Node prev = find(index-1);
                // insert the new node containing item after
                // the node that prev references
                Node newNode = new Node((Edge) item, prev.getNext());
                prev.setNext(newNode);
            } // end if

        }
        else
        {
            throw new ListIndexOutOfBoundsException(
                "List index out of bounds exception on add");
        } // end if
    }  // end add

    public void remove(int index)
    throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < size())
        {
            if (index == 0)
            {
// delete the first node from the list
                head = head.getNext();
            }
            else
            {
                Node prev = find(index-1);
// delete the node after the node that prev
// references, save reference to node
                Node curr = prev.getNext();
                prev.setNext(curr.getNext());
            } // end if

        } // end if
        else
        {
            throw new ListIndexOutOfBoundsException(
                "List index out of bounds exception on remove");
        } // end if
    }   // end remove

    public void removeAll()
    {
// setting head to null causes list to be
// unreachable and thus marked for garbage
// collection
        head = null;

    } // end removeAll

    public int size()
    {
        int counter = 0;
        Node n=head;
        while(n != null)
        {
            counter++;
            n = n.getNext();
        }
        return counter;
    }
    public String toString()
    {
        String contents ="";
        Node n = head;
        while(n != null)
        {
            contents = contents + n.getEdge()+" ";
            n = n.getNext();
        }
        return contents;
    }
}
// end ListReferenceBased
