package com.DAA;

public class MinHeap implements MinHeapInterface {

	private Vertex[] elements;
	
	public MinHeap(int size){
		elements = new Vertex[size];
	}

	public boolean isEmpty() {
		if(elements[0] == null){
			return true;
		}
		else{
			return false;
		}
	}

	public int insert(Object item) {
		// TODO Auto-generated method stub
		return 0;
	}


	public Object DeleteMin() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int decreaseKey(int index, int value) {
		// TODO Auto-generated method stub
		return 0;
	}

}
