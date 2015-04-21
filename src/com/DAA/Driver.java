package com.DAA;
/*
 * Purpose: Design and Analysis of Algorithms Assignment 4
 * Status: Complete and thoroughly tested
 * Last update: 04/21/15
 * Submitted:  04/22/15
 * Comment: 
 * @author: Albert Rynkiewicz
 * @version: 2015.04.21
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Driver {

	private static BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in));
	private static MinHeap minHeap;
	private static MyListReferenceBased[] AL;
	private static int numVertices;
	private static String MST="\nMST SOLUTION:";
	private static int parent[];
	private static boolean visited[];
	
	public static void main(String[] args) throws IOException{
        initialize(args);
        boolean minHeapDriver = false;
        if(minHeapDriver){
        	//MinHeapDriverCode
        	runMeanHeapTesting();

        }
        else{
        	//MST Solution
        	runMSTSolution();
        }
	}

	
	/**
	 * Runs the code for the MST Solution
	 */
	private static void runMSTSolution(){
		//For every vertex -- update parent and visited
		int i =0;
		for(i = 0;i<numVertices;i++){
			parent[i]=-1; 
			visited[i]=false;
		}
		
		//pull first vertex, make source, process AL
		parent[0] = 0;
		minHeap.decreaseKey(0, 0);

		while(!minHeap.isEmpty()){
			Vertex v = (Vertex) minHeap.deleteMin();
			int parentId = v.getId();
			visited[parentId] = true;
			addToMST(parentId,v.getWeight());
			
			//now we need to process!
			Node n = (Node) AL[parentId].get(0);
			while(n != null){
				
				Edge e = n.getEdge();
				int to = e.getId();
				int weight = e.getWeight();
				//This says "if the vertex at the end of this edge is not visited
				//yet and the weight of the edge is less than the previous shortest
				//edge...
				if(visited[to]==false && weight < minHeap.getValue(to)){
					parent[to]=parentId;//update parent
					minHeap.decreaseKey(to, weight);//update minHeap accordingly.
				}
				
				n=n.getNext();
			}
			
		}
		System.out.println(MST);
		
		
	}

	/**
	 * Runs the code to start the minHeapDriver 
	 */
	private static void runMeanHeapTesting() throws IOException{
        String choice = "";
        while (choice.equals("6") != true) {
            displayMenu();
            choice = reader.readLine();
            System.out.println(choice);
            selectMenuItem(choice);
        }
	}
	  /**
	    * checks which menu item is selected
	    * calls the corresponding method
	    *@param menuOptionSelected - the menu option the user selects 
	    */
	    private static void selectMenuItem(String menuOptionSelected)
	    throws IOException {
	        switch (menuOptionSelected) {
	        case "1":
	            minHeapIsEmpty();
	            break;
	        case "2":
	            insertKey();
	            break;
	        case "3":
	            deleteMin();
	            break;
	        case "4":
	            decreaseKey();
	            break;
	        case "5":
	            displayMinHeap();
	            break;
	        case "6":
	            System.out.println("Exiting program... Good Bye.");
	            break;
	        default:
	            System.out.println("Please enter a correct menu option.");
	            break;
	        }
	    }
	    /**
	    *displays the menu for the user to interact with
	    */
	    private static void displayMenu() {
	        System.out.println("Select from the following menu:");
	        System.out.println("    1. Check if MinHeap is empty.");
	        System.out.println("    2. Insert key in MinHeap.");
	        System.out.println("    3. Delete min key from MinHeap.");
	        System.out
	        .println("    4. Decrease key in MinHeap.");
	        System.out
	        .println("    5. Display items in MinHeap in array order.");
	        System.out
	        .println("    6. Exit Program.");
	    }

	    /*
	     * Menu Option #1 - Check if MinHeap is Empty
	     * 
	     */
	    private static void minHeapIsEmpty(){
	    	if(minHeap.isEmpty()){
	    		System.out.println("MinHeap is empty.");
	    	}
	    	else{
	    		System.out.println("MinHeap is not empty.");
	    	}
	    	
	    }
	    
	    /*
	     * Menu Option #2 - Insert Key into MinHeap
	     * 
	     */
	    private static void insertKey() throws IOException{

	    	System.out.print("Input value to add into minheap: ");
	    	int num = Integer.parseInt(reader.readLine());
	    	if(minHeap.insert(num)){
	    		System.out.println("Item inserted successfully.");
	    	}
	    	else{
	    		System.out.println("Item was not able to be inserted into minHeap.");
	    	}

	    	
	    }
	    
	    /*
	     * Menu Option #3 - Delete min key from MinHeap
	     * 
	     */
	    private static void deleteMin() throws IOException{

	    	Vertex v = (Vertex) minHeap.deleteMin();
	    	System.out.println("Vertex "+v.getId()+" with value "+v.getWeight()+" deleted from minheap.");    	
	    }
	    
	    
	    /*
	     * Menu Option #4 - Decrease key in MinHeap
	     * 
	     */
	    private static void decreaseKey() throws IOException{

	    	System.out.print("Input key to decrease in minHeap: ");
	    	int key = Integer.parseInt(reader.readLine());
	    	System.out.print("Input value to decrease given key: ");
	    	int value = Integer.parseInt(reader.readLine());
	    	
	    	if(minHeap.decreaseKey(key, value)){
	    		System.out.println("Item decreased successfully.");
	    	}
	    	else{
	    		System.out.println("Item was not able to be decreased in minHeap.");
	    	}	
	    }
	    
	    /*
	     * Menu Option #5 - Display items in MinHeap in array order
	     * 
	     */
	    private static void displayMinHeap() throws IOException{

	    	System.out.println("The MinHeap can viewed as in array order: ");
	    	System.out.println(minHeap);	
	    }	    
	    
	    	    
	/*
	 * This method sets up and initialized the job board
	*/

	    private static void initialize(String[] args) {
	    	
	    	//Input too large for string args to work in input 2. Read in from text file instead
	    		args = new String[14852];//lines in text file
	    		int q=0;
	    	   try {
	    		BufferedReader br = new BufferedReader(new FileReader("C:/Users/Albert/workspace/DAA_Assignment4/src/com/DAA/Input2.txt"));
	   	        String line;
	   	        while(q < 14852){
	   	        	line = br.readLine();
	   	        	args[q]= line;
	   	        	q++;
	   	        }
	   	        
	    	   } catch (Exception e) {
	    	       e.printStackTrace();
	    	   }

		System.out.print("Please enter the number of Vertices (n): ");
		System.out.println(args[0]);
		numVertices = Integer.parseInt(args[0]);
		AL = new MyListReferenceBased[numVertices];
		parent = new int[numVertices];
		visited= new boolean[numVertices];
		
		int numEdges = Integer.parseInt(args[1]);
		int i = 0;
			
		minHeap = new MinHeap(numVertices);

		
	
		//initialize linked lists in AL
		for(i=0; i<numVertices;i++){
			AL[i]=new MyListReferenceBased();
		}

		// Convert args to ints
		int size = args.length;
		int[] argsNums = new int[size - 1];
		// start at 2 because index 0 and 1 specifies size
		for (i = 2; i < size; i++) {
			argsNums[i - 2] = Integer.parseInt(args[i]);
		}
		System.out.println("INPUT:");
		//Set up AL
		int from;
		int to;
		int weight;
		for (i = 0; i < numEdges; i++) {
			from = argsNums[i*3];
			to = argsNums[i*3+1];
			weight = argsNums[i*3+2];
			AL[from].add(0, new Edge(to, weight));
			System.out.println(from+ " " +to+" "+weight);
			//need to add opposite edge as well
			AL[to].add(0, new Edge(from, weight));
			// the 0 here works because we can always add the item to the beginning of the linked list.
		}

		}
	
	private static void addToMST(int vertex, int distance){
		MST = MST + "\n"+vertex+" " +parent[vertex]+" "+distance;
	}

}
