package com.DAA;

/*
 * This class represents a Vertex in a Graph used for finding a Minimum
 * Spanning Tree
 */
public class Edge {

	private int to;
	private int weight;
	
	public Edge(int newTo, int newWeight){
		to = newTo;
		weight =newWeight;
	}
	
	public int getId(){
		return to;
	}

	public int getDistance(){
		return weight;
	}
	
	public String toString(){
		return "edge to vertex: "+to+" with weight: "+weight;
	}

}
