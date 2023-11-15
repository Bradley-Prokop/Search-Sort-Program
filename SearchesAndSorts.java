package algorithms;

import java.util.Scanner;

/**
 * This class allows the user to either search or sort through arrays using various algorithms. The array will return to it's original  
 * state after being sorted to ensure that each sorting algorithm is actually resorting the array. 
 * @author Bradley Prokop
 */
public class SearchesAndSorts {
	
	static Scanner sc = new Scanner(System.in);
	static int[] list = {200, 100, 300, 1500, 400, 350,500, 800, 2000, 5000, 4320, 6544}, listTwo = {60, 80, 50, 20, 40, 10, 70, 30, 90};
	static int iterationCount = 0, key;
	static boolean mainMenu=false;
	
	/**
	 * Main method to control the flow of the program.
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("**************************************");
		System.out.print("Welcome to the search or sort program!\nWhat would you like to do today? options: 1-(search) or 2-(sort):");
		String userChoice = sc.next();
		
		while(!(userChoice.equalsIgnoreCase("1")||userChoice.equalsIgnoreCase("2"))) {
			System.out.println("Invalid option, please try again!\n");
			System.out.print("What would you like to do today? options: 1-(search) or 2-(sort):");
			userChoice = sc.next();
		}
		
		if(userChoice.equalsIgnoreCase("1")) 
			searchOption();
		else
			sortOption();
		
		System.out.print("\nWould you like to return to the main menu? (Yes/No): ");
		String returnToMainMenu = sc.next();
		
		while(!(returnToMainMenu.equalsIgnoreCase("yes")||returnToMainMenu.equalsIgnoreCase("no"))){
			System.out.println("Invalid option, please try again!\n");
			System.out.print("Would you like to return to the main menu? (Yes/No): ");
			returnToMainMenu = sc.next();
		}
		
		if(returnToMainMenu.equalsIgnoreCase("yes"))
			mainMenu=true;
			
		while(mainMenu&&iterationCount>0) {
			
			System.out.print("\nWelcome back to the main menu!\nWhat would you like to do? 1-(search) or 2-(sort):");
			userChoice = sc.next();
			
			while(!(userChoice.equalsIgnoreCase("1")||userChoice.equalsIgnoreCase("2"))) {
				System.out.println("Invalid option, please try again!\n");
				System.out.print("What would you like to do today? options: 1-(search) or 2-(sort):");
				userChoice = sc.next();
			}
			
			if(userChoice.equalsIgnoreCase("1")) 
				searchOption();
			else
				sortOption();
			
			System.out.print("\nWould you like to return to the main menu? (Yes/No): ");
			returnToMainMenu = sc.next();
			
			while(!(returnToMainMenu.equalsIgnoreCase("yes")||returnToMainMenu.equalsIgnoreCase("no"))){
				System.out.println("Invalid option, please try again!\n");
				System.out.print("\nWould you like to return to the main menu? (Yes/No): ");
				returnToMainMenu = sc.next();
			}
			
			if(returnToMainMenu.equalsIgnoreCase("no"))
				mainMenu=false;
		}
		System.out.println("\nThanks for stopping by!");
		sc.close();
	}
	
	/**
	 * This method executes the logic for the sorting options.
	 */
	public static void sortOption() {
		
		boolean sortAgain = true;
		
		String typeOfSort;
		
		while(sortAgain) {
			
			System.out.println("\nWhat kind of sort would you like to use?");
			System.out.print("Options: insertion sort (enter is), Merge sort (enter ms), or Bubble sort (enter bs): ");
			typeOfSort = sc.next();
			
			while(!(typeOfSort.equalsIgnoreCase("is")||typeOfSort.equalsIgnoreCase("ms")||typeOfSort.equalsIgnoreCase("bs"))) {
				System.out.println("Invalid option, please try again!\n");
				System.out.println("What kind of sort would you like to use?");
				System.out.print("Options: insertion sort (enter is), Merge sort (enter ms), or Bubble sort (enter bs): ");
				typeOfSort = sc.next();
			}
			
			System.out.print("\nEnter 'A' for descending or 'D' for Ascending: ");
			String direction = sc.next();
			
			while(!(direction.equalsIgnoreCase("a")||direction.equalsIgnoreCase("d"))) {
				System.out.println("Invalid option, please try again!\n");
				System.out.print("Enter 'A' for descending or 'D' for Ascending: ");
				direction = sc.next();
			}
			
			if(typeOfSort.equalsIgnoreCase("is")&&direction.equalsIgnoreCase("a")) 
				insertionSortAscending();
			else if (typeOfSort.equalsIgnoreCase("is")&&direction.equalsIgnoreCase("d"))
				insertionSortDescending();
			else if(typeOfSort.equalsIgnoreCase("ms")&&direction.equalsIgnoreCase("a"))
				mergeSortAscending();
			else if(typeOfSort.equalsIgnoreCase("ms")&&direction.equalsIgnoreCase("d"))
				mergeSortDescending();
			else if(typeOfSort.equalsIgnoreCase("bs")&&direction.equalsIgnoreCase("a"))
				bubbleSortAscending();
			else 
				bubbleSortDescending();
			
			returnToOriginal();
			
			System.out.print("\nWould you like to sort again? (Yes/No): ");
			String again = sc.next();
			
			while(!(again.equalsIgnoreCase("yes")||again.equalsIgnoreCase("no"))) {
				System.out.println("Invalid option, please try again!");
				System.out.print("\nWould you like to sort again? (Yes/No): ");
				again = sc.next();
			}
			
			if(again.equalsIgnoreCase("no")) 
				sortAgain=false;
			
			iterationCount++;
		}
	}
	
	/**
	 * This method executes the logic for the searching options.
	 */
	public static void searchOption() {
		
		boolean searchAgain = true;
		
		while(searchAgain) {
			System.out.println("\nWhat kind of search would you like to use?");
			System.out.print("Options: Binary search (enter bs) or Linear search (enter ls): ");
			String typeOfSearch = sc.next();
			
			while(!(typeOfSearch.equalsIgnoreCase("bs")||typeOfSearch.equalsIgnoreCase("ls"))) {
				System.out.println("Invalid option, please try again!\n");
				System.out.println("What kind of search would you like to use?");
				System.out.print("Options: Binary search (enter bs), Linear search (enter ls): ");
				typeOfSearch = sc.next();
			}
			
			System.out.print("\nWhat number are you searching for: ");
			key = sc.nextInt();
			
			if(typeOfSearch.equalsIgnoreCase("ls"))
				linearSearch(key);
			else {
				int index = binarySearch(key);
				if(index==-1)
					System.out.println("Sorry, key value not found!");
				else 
					System.out.println("The number "+key+ " is located at index: "+index);
			}
			
			returnToOriginal();
				
			System.out.print("\nWould you like to search again? (Yes/No): ");
			String again = sc.next();
			
			while(!(again.equalsIgnoreCase("yes")||again.equalsIgnoreCase("no"))) {
				System.out.println("Invalid option, please try again!");
				System.out.print("\nWould you like to search again? (Yes/No): ");
				again = sc.next();
			}
			
			if(again.equalsIgnoreCase("no")) 
				searchAgain=false;
	
			iterationCount++;
		}
	}
	
	/**
	 * This method uses the linear search algorithm to find the key value, if it's not found then the method
	 * will output "Sorry, key value not found!".
	 * @param key (the value to find)
	 */
	public static void linearSearch(int key) {
		
		int index = -1;
		
		for(int i=0; i<list.length;i++) 
			if(list[i]==key) {
				index = i;
				break;
			}
		
		System.out.print("[");
		for(int i=0;i<list.length;i++) 
			if(i==list.length-1)
				System.out.print(list[i]);
			else
				System.out.print(list[i]+",");
		System.out.println("]");
		
		if(index!=-1) 
			System.out.println("The number "+key+ " is located at index: "+index);
		else 
			System.out.println("Sorry, key value not found!");
	}

	/**
	 * This method uses the binary search algorithm to find the key value, if it's not found then the method
	 * will output "Sorry, key value not found!".
	 * @param key (the value to find)
	 */
	public static int binarySearch(int key) {
		
		for(int i=0;i<list.length;i++) 
			for(int j=i;j<list.length;j++) 
				if(list[i]>list[j]) {
					int temp = list[i];
					list[i]=list[j];
					list[j]=temp;
				}
		
		System.out.print("[");
		for(int i=0;i<list.length;i++) 
			if(i==list.length-1)
				System.out.print(list[i]);
			else
				System.out.print(list[i]+",");
		System.out.println("]");
		
		int low=0, high=list.length-1, middleIndex;
				
		while(low<=high) {
			
			middleIndex=(high+low)/2;
			
			if(key==list[middleIndex]) 
				return middleIndex;	
			
			if(key<list[middleIndex]) 
				high=middleIndex-1;
			else
				low=middleIndex+1;
		}
		return -1;
	}
	
	
	/**
	 * This method uses the insertion sort algorithm to sort the list ascending.
	 */
	public static void insertionSortAscending() {
		
		for(int i=0;i<list.length;i++) 
			for(int j=i;j<list.length;j++) 
				if(list[i]>list[j]) {
					int temp = list[i];
					list[i]=list[j];
					list[j]=temp;
				}
		
		System.out.print("[");
		for(int i=0;i<list.length;i++) 
			if(i==list.length-1)
				System.out.print(list[i]);
			else
				System.out.print(list[i]+",");
		System.out.println("]");
	}
	

	/**
	 * This method uses the insertion sort algorithm to sort the list descending.
	 */
	public static void insertionSortDescending() {
		
		for(int i=0;i<list.length;i++) 
			for(int j=i;j<list.length;j++) 
				if(list[i]<list[j]) {
					int temp = list[i];
					list[i]=list[j];
					list[j]=temp;
				}
		
		System.out.print("[");
		for(int i=0;i<list.length;i++) 
			if(i==list.length-1)
				System.out.print(list[i]);
			else
				System.out.print(list[i]+",");
		System.out.println("]");
	}
	
	
	/**
	 * This method sorts the merged array Ascending.
	 */
	public static void mergeSortAscending() {
		
		int[] mergedArray = new int[list.length + listTwo.length];
		
		int indexReset=0;
		for(int i=0;i<mergedArray.length;i++) 
			if(i>=list.length)
				mergedArray[i]=listTwo[indexReset++];
			else
				mergedArray[i]=list[i];
		
		
		for(int i=0;i<mergedArray.length;i++) 
			for(int j=i;j<mergedArray.length;j++) 
				if(mergedArray[i]>mergedArray[j]) {
					int temp = mergedArray[i];
					mergedArray[i]=mergedArray[j];
					mergedArray[j]=temp;
				}
		
		System.out.print("[");
		for(int i=0;i<mergedArray.length;i++) 
			if(i==mergedArray.length-1)
				System.out.print(mergedArray[i]);
			else
				System.out.print(mergedArray[i]+",");
		System.out.println("]");
	}

	
	/**
	 * This method sorts the merged array descending. 
	 */
	public static void mergeSortDescending() {
		
		int[] mergedArray = new int[list.length + listTwo.length];
		
		int indexReset=0;
		for(int i=0;i<mergedArray.length;i++) 
			if(i>=list.length)
				mergedArray[i]=listTwo[indexReset++];
			else
				mergedArray[i]=list[i];
		
		
		for(int i=0;i<mergedArray.length;i++) 
			for(int j=i;j<mergedArray.length;j++) 
				if(mergedArray[i]<mergedArray[j]) {
					int temp = mergedArray[i];
					mergedArray[i]=mergedArray[j];
					mergedArray[j]=temp;
				}
		
		System.out.print("[");
		for(int i=0;i<mergedArray.length;i++) 
			if(i==mergedArray.length-1)
				System.out.print(mergedArray[i]);
			else
				System.out.print(mergedArray[i]+",");
		System.out.println("]");
	}

	/**
	 * This method uses the bubble sort algorithm to sort the list ascending.
	 */
	public static void bubbleSortAscending() {
		
		boolean swapMade=true;
		
		while(swapMade) {
			
			swapMade=false;
			for(int i=0; i<list.length-1;i++) 
				if(list[i]>list[i+1]) {
					int temp = list[i];
					list[i]=list[i+1];
					list[i+1]=temp;
					swapMade=true;
				}
		}
		
		System.out.print("[");
		for(int i=0;i<list.length;i++) 
			if(i==list.length-1)
				System.out.print(list[i]);
			else
				System.out.print(list[i]+",");
		System.out.println("]");
	}
	
	/**
	 * This method uses the bubble sort algorithm to sort the list descending.
	 */
	public static void bubbleSortDescending() {
		

		boolean swapMade=true;
		
		while(swapMade) {
			
			swapMade=false;
			for(int i=0; i<list.length-1;i++) 
				if(list[i]<list[i+1]) {
					int temp = list[i];
					list[i]=list[i+1];
					list[i+1]=temp;
					swapMade=true;
				}
		}
		
		System.out.print("[");
		for(int i=0;i<list.length;i++) 
			if(i==list.length-1)
				System.out.print(list[i]);
			else
				System.out.print(list[i]+",");
		System.out.println("]");
	}

	/**
	 * Returns the array to it's original unsorted state.
	 */
	public static void returnToOriginal() {
		list[0]=200;
		list[1]=100;
		list[2]=300;
		list[3]=1500;        
		list[4]=400;
		list[5]=350;
		list[6]=500;
		list[7]=800;
		list[8]=2000;
		list[9]=5000;
		list[10]=4320;
		list[11]=6544;
	}
}