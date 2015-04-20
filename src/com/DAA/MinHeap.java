package com.DAA;

public class MinHeap implements MinHeapInterface {

	private int[] heap;
	private int[] vertices;
	private int numItems = 0;
	
	public MinHeap(int size){
		heap = new int[size];
		vertices = new int[size];
		for(int i = 0; i<size; i++){
			vertices[i]=i;
		}
	}

	public boolean isEmpty() {
		if(numItems == 0){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean insert(Object item) {
		heap[numItems++] = (int) item;

		return true;
	}


	public Object DeleteMin() throws EmptyMinHeapException{
		
		//save first element to return later
		int num = heap[0];
		//move last element to first
		heap[0] = heap[numItems-1];
		//delete new last
		numItems--;
		
		//trickle down new first guy
		int index =0;
		int swappingIndex=0;
		while(swappingIndex != -1){
			//first check if current index has children
			if(2*index+2<numItems){
				//Definitely doesnt have two children
				if(2*index+1<numItems){
					//has no children
					swappingIndex=-1;
				}
				else{
					//has one child, compare to him to see if vertex needs to be 
					//trickled
					swappingIndex = 2*index +1;
				}
			}
			else{
				if(heap[2*index +1] < heap[2*index +2]){
					swappingIndex = 2*index +1;
				}
				else{
					swappingIndex = 2*index+2;
				}
			}

			if(swappingIndex!=-1){
				if(heap[index]> heap[swappingIndex]){
					//swap
					swap(index, swappingIndex);
				}
				else{
					//no more trickling to be done
					swappingIndex = -1;
				}
			}

		}

		return num;
	}

	
	public boolean decreaseKey(int index, int value) {

		boolean result = false;
		//change value of distance, bubble up
		int vertexsIndex = vertices[index];
		heap[vertexsIndex] = value;
		result = true;
		//now bubble up
		while(heap[vertexsIndex/2]>heap[vertexsIndex]){
				//swap them
				swap(vertexsIndex/2, vertexsIndex);
				vertexsIndex = vertexsIndex/2;

		}
	
		return result;
	}

	private void swap(int index1, int index2){
		int temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2]= temp;
		index1 = index2;
	}
	
	public int getValue(int vertex){
		return heap[vertices[vertex]];
	}
	/*
	 * @return returns the array that depicts this minheap)
	 * 
	 */
	public String toString(){
		String contents ="";
		for(int i=0; i< numItems;i++){
			contents = contents + heap[i]+ " ";
		}
		return contents;
	}
}
