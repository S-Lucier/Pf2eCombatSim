import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * Author: Scoots
 * Title : Pf2e Combat Simulator
 * License: Before use recite "I denounce the rarity system"
 * after that do whatever with the code.
 *
 * Purpose: Monte Carlo simulation of simplified pathfinder 2e combat.
 */

public class Pf2eCombatSimulator {
	
	// inter-class array lists
		public static ArrayList<Employee> employeeList = new ArrayList<>(); //template for later
		public static ArrayList<WorkOrder> workOrderList = new ArrayList<>(); //array of classes

	public static void main(String[] args) {
		
		System.out.println("intro text placeholder");
		
		
		//file names input
		Scanner scnr = new Scanner(System.in);
		System.out.println("Give Input File Name");
		String inputFileName = scnr.nextLine();
		System.out.println("Give Output File Name");
		String outputFileName = scnr.nextLine();
		
		
		scnr.close();
	}
}

//ask mechie (programmer friend) to show me how to use git, version control software