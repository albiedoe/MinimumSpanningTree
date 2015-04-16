package com.DAA;

public class MinHeap implements MinHeapInterface {

	private Vertex[] elements;
	private int numItems = 0;
	
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
		elements[numItems] = (Vertex) item;
		return numItems++;
	}


	public Object DeleteMin() throws EmptyMinHeapException{
		
		//save first element to return later
		Vertex v = elements[0];
		//move last element to first
		elements[0] = elements[numItems-1];
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
				if(elements[2*index +1].getDistance() < elements[2*index +2].getDistance()){
					swappingIndex = 2*index +1;
				}
				else{
					swappingIndex = 2*index+2;
				}
			}

			if(swappingIndex!=-1){
				if(elements[index].getDistance()> elements[swappingIndex].getDistance()){
					//swap
					swap(index, swappingIndex);
				}
				else{
					//no more trickling to be done
					swappingIndex = -1;
				}
			}

		}
		numItems--;
		return elements[index];
	}

	
	public int decreaseKey(int index, int value) {
		//go through array until numItems, look for index == id,
		//change value of distance, bubble up
		for(int i =0; i<numItems;i++){
			if(elements[i].getId()==index){
				//we found our index
				elements[i].setDistance(value);
				//now bubble up
				while(elements[i/2].getDistance()<elements[i].getDistance()){
					//swap them
					swap(i/2, i);
					i = i/2;
				}
				return i;
			}
		}
		return -1;
	}

	private void swap(int index1, int index2){
		Vertex temp = elements[index1];
		elements[index1] = elements[index2];
		elements[index2]= temp;
		index1 = index2;
	}
}
