package com.DAA;

public class MinHeap implements MinHeapInterface {

	private Vertex[] vertexHeap;
	private int numItems = 0;
	
	public MinHeap(int size){
		vertexHeap = new Vertex[size];
		numItems = size;
		for(int i = 0; i<size; i++){
			vertexHeap[i]=new Vertex(i, Integer.MAX_VALUE);
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
		vertexHeap[numItems++] = (Vertex) item;

		return true;
	}


	public Object deleteMin() throws EmptyMinHeapException{
		
		if(numItems>0){
			//Save deleted Vertex
			Vertex v = vertexHeap[0];
			
			//move last element to first
			swap(0, numItems-1);
			//delete new last
			vertexHeap[numItems-1]=null;
			numItems--;
			
			//trickle down new first guy
			int index =0;
			int swappingIndex=0;
			while(swappingIndex != -1){
				//first check if current index has children
				if(vertexHeap[2*index+2]==null){
					//Definitely doesnt have two children
					if(vertexHeap[2*index+1]==null){
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
					if(vertexHeap[2*index +1].getWeight() < vertexHeap[2*index +2].getWeight()){
						swappingIndex = 2*index +1;
					}
					else{
						swappingIndex = 2*index+2;
					}
				}

				if(swappingIndex!=-1){
					if(vertexHeap[index].getWeight()> vertexHeap[swappingIndex].getWeight()){
						//swap
						swap(index, swappingIndex);
					}
					else{
						//no more trickling to be done
						swappingIndex = -1;
					}
				}

			}

			return v;
		}
		else{
			return -1;
		}
	}

	
	public boolean decreaseKey(int index, int value) {

		boolean result = false;
		
		//Find correct Vertex
		int i;
		for(i=0; i< numItems; i++){
			if(vertexHeap[i].getId()==index){
				//we found our vertex, lets change the weight
				vertexHeap[i].setWeight(value);
				result = true;
				break;//no need to continue
			}
		}
		

		//now we need to bubble up
		while(vertexHeap[i/2].getWeight()>vertexHeap[i].getWeight()){
				//swap them
				swap(i/2, i);
				i = i/2;

		}
	
		return result;
	}

	private void swap(int index1, int index2){
		Vertex temp = vertexHeap[index1];
		vertexHeap[index1] = vertexHeap[index2];
		vertexHeap[index2]= temp;
	
	
		
	}

	public int getValue(int vertex){
		
		for(int i=0;i<numItems;i++){
			if(vertexHeap[i].getId()==vertex){
				return vertexHeap[i].getWeight();
			}
		}
		return -1;
	}
	/*
	 * @return returns the array that depicts this minheap
	 * 
	 */
	public String toString(){
		String contents ="";
		for(int i=0; i< numItems;i++){
			contents = contents + vertexHeap[i].getWeight()+ " ";
		}
		return contents;
	}
}
