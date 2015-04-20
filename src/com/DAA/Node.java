package com.DAA;
//please note that this code is different from the textbook code, because the data is encapsulated!

public class Node
{
    private Edge edge;
    private Node next;

    public Node(Edge newEdge)
    {
        edge = newEdge;
        next = null;
    } // end constructor

    public Node(Edge newEdge, Node nextNode)
    {
        edge = newEdge;
        next = nextNode;
    } // end constructor


    public Edge getEdge()
    {
        return edge;
    } // end getItem
    

    public void setNext(Node nextNode)
    {
        next = nextNode;
    } // end setNext

    public Node getNext()
    {
        return next;
    } // end getNext
} // end class Node
