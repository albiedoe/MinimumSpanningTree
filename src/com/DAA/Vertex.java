package com.DAA;

/*
 * This class represents a Vertex in a Graph used for finding a Minimum
 * Spanning Tree
 */
public class Vertex {

	private int id;
	private int distance;
	
	public Vertex(int _id, int _distance){
		id = _id;
		distance =_id;
	}
	
	public int getId(){
		return id;
	}

	public int getDistance(){
		return distance;
	}
	
	public void setDistance(int newDistance){
		distance = newDistance;
	}
}
