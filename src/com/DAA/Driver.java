package com.DAA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {

	private static BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in));
	
	public static void main(String[] args) {
        initialize(args);

        String choice = "";
        while (choice.equals("8") != true) {
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
	            customerEntersLine();
	            break;
	        case "2":
	            customerEntersTheater();
	            break;
	        case "3":
	            customerLeavesTheater();
	            break;
	        case "4":
	            displayTicketLines();
	            break;
	        case "5":
	            displayInterstellar();
	            break;
	        case "6":
	            displayMaleficent();
	            break;
	        case "7":
	            displayStats();
	            break;
	        case "8":
	            System.out.println("Exiting program... Good Bye.");
		    System.out.println("The Greco & Rynkiewicz Movie Theater who earned " + ((maleTicketsSold + interTicketsSold) * ticketPrice)+ " and kicks out the remaining customers and closes...");
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
	        System.out.println("    1. Customer(s) enter(s) movie theater.");
	        System.out.println("    2. Customer buys ticket(s).");
	        System.out.println("    3. Customer(s) leave(s) the theater.");
	        System.out
	        .println("    4. Display info about customers waiting for tickets.");
	        System.out
	        .println("    5. Display seating chart for Interstellar movie theater.");
	        System.out
	        .println("    6. Display seating chart for Malefcient movie theater.");
	        System.out
	        .println("    7. Display number of tickets sold and total earnings.");
	        System.out.println("    8. End the program.");
	    }

	/*
	 * This method sets up and initialized the job board
	 */

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

}
