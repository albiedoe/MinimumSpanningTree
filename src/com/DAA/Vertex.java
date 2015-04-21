package com.DAA;

public class Vertex {

	private int id;
	private int weight;
	
	public Vertex(int newId, int newWeight){
		id = newId;
		weight = newWeight;
	}
	
	public int getId(){
		return id;
	}
	
	public int getWeight(){
		return weight;
	}
	
	public void setWeight(int newWeight){
		weight = newWeight;
	}
}
