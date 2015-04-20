package com.DAA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {

	private static BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in));
	private static MinHeap minHeap = new MinHeap(10);
	
	public static void main(String[] args) throws IOException{
        //initialize(args);

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
	    public static void minHeapIsEmpty(){
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
	    public static void insertKey() throws IOException{

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
	    public static void deleteMin() throws IOException{

	    	int num = (int) minHeap.DeleteMin();
	    	System.out.println("Value "+num+" deleted from minheap.");    	
	    }
	    
	    
	    /*
	     * Menu Option #4 - Decrease key in MinHeap
	     * 
	     */
	    public static void decreaseKey() throws IOException{

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
	    public static void displayMinHeap() throws IOException{

	    	System.out.println("The MinHeap can viewed as in array order: ");
	    	System.out.println(minHeap);	
	    }	    
	    
	    	    
	/*
	 * This method sets up and initialized the job board
	 

	public static void initialize(String[] args) {

		System.out.print("Please enter the number of People (n): ");
		System.out.println(args[0]);
		numPeople = Integer.parseInt(args[0]);
		board = new int[numPeople][numPeople];
		bestCombo = new int[numPeople];
		bestPossibleCombination = new int[numPeople];
		
		int i = 0;
		int j = 0;

		// Convert args to ints
		int size = args.length;
		int[] argsNums = new int[size - 1];
		// start at 1 because first int specifies size
		for (i = 1; i < size; i++) {
			argsNums[i - 1] = Integer.parseInt(args[i]);
			// System.out.println(argsNums[i-1]);
		}

		// Row Counter
		for (i = 0; i < numPeople; i++) {

			// Column Counter
			for (j = 0; j < numPeople; j++) {
				int num = argsNums[numPeople * i + j];
				//Initializes board
				board[i][j] = num;
				//initializes bestPossibleCombination
				if(bestPossibleCombination[i]<num){
					bestPossibleCombination[i]=num;
				}
			}

		}
*/
}
