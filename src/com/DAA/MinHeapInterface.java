package com.DAA;

public interface MinHeapInterface {
	//this is a specialized MinHeap to be used by Prim's or Dijkstra's algos
	   
	public boolean isEmpty();
	// returns true if MinHeap is empty, false otherwise

	public boolean insert(Object item);
	//inserts object in MinHeap and returns outcome

	public Object deleteMin();
	//returns reference to object that has been removed 

	public boolean decreaseKey(int vertex, int value);
	//decreases to value the priority of the specified vertex and returns the outcome

	public int getValue(int vertex);
	//returns the value in the MinHeap of the specified vertex

	}// end MinHeapInterface