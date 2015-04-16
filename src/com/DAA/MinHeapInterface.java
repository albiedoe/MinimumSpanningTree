package com.DAA;

public interface MinHeapInterface {

	
	public boolean isEmpty();
	// returns true if MinHeap is empty, false otherwise

	public int insert(Object item);
	//inserts object in MinHeap and returns index in the array where it ended up

	public Object DeleteMin();
	//returns true if min was removed successfully, false otherwise

	public int decreaseKey(int idex, int value);
	//decreases to value the priority of the item in the specified index and returns the index in the array where the item ended up

}
