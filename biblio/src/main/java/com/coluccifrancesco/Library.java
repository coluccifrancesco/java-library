package com.coluccifrancesco;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Library {
	
	private Library(){
	}

	/**
	 * 
	 * @param args Command line arguments
	 * @author Francesco Colucci
	 * @version 0.1
	*/
    
	public static void main(String[] args){
    
		Scanner scanner = new Scanner(System.in);
		int userInput = 0;
		
		String title = "";
		String author = "";
		int pubYear = 0;
		double kbFileSize = 0;
		
		// Creating an istance of the bookshelf
		Bookshelf bookshelf = new Bookshelf();
		
		
		// The program runs while exit-command isn't pressed
		do {
			
			// The menu is shown until user inserts a valid input
			do {
		
				System.out.println(" ");
				System.out.println("Welcome to our library! Choose what to do:");
				System.out.println("1. Add a book");
				System.out.println("2. Remove a book");
				System.out.println("3. View the full library");
				System.out.println("4. Classics conter");
				System.out.println("5. Digital-books counter");
				System.out.println("6. Quit");
				System.out.println(" ");
				
				try {
					userInput = scanner.nextInt();
					scanner.nextLine();

				} catch (InputMismatchException e) {
					
					System.out.println("You didn't insert an integer, try again.");
					userInput = 0;
				
				} catch (IllegalStateException | NoSuchElementException e) {
				
					System.out.println("There's been a problem, try again.");
					System.exit(-1);
				}

				if (userInput < 1 || userInput > 6) {
					System.out.println("Input not valid.");
				}

			} while (userInput < 1 || userInput > 6);

			// App running user command
			switch (userInput) {	

				// Add a book
				case 1:

					int bookToAdd = 0;

					// Choose to add a digital book or not
					do {
						
						System.out.println(" ");
						System.out.println("Do you want to add a physical book or a digital one?");
						System.out.println("1. Physical");
						System.out.println("2. Digital");
						System.out.println("3. Quit");

						try {
							bookToAdd = scanner.nextInt();
							scanner.nextLine();

						} catch (InputMismatchException e) {
					
							System.out.println("You didn't insert an integer, try again.");
				
						} catch (IllegalStateException | NoSuchElementException e) {
				
							System.out.println("There's been a problem, try again.");
							System.exit(-1);
						}

						if (bookToAdd < 1 || bookToAdd > 3) {
							System.out.println("Input not valid.");
						}
						
					} while (bookToAdd < 1 || bookToAdd > 3);

					
					// Add book due to the type
					switch (bookToAdd) {
						
						// Add a physical book
						case 1:
							System.out.println(" ");
							System.out.print("Add a physical book.");
							System.out.println(" ");
							
							// Insert title
							System.out.print("Title :> ");
							
							try {
								title = scanner.nextLine();
							} catch (IllegalStateException | NoSuchElementException e) {
				
								System.out.println("There's been a problem, try again.");
								System.exit(-1);
							}

							// Insert author
							System.out.print("Author :> ");
							
							try {
								author = scanner.nextLine();
							} catch (IllegalStateException | NoSuchElementException e) {
				
								System.out.println("There's been a problem, try again.");
								System.exit(-1);
							}

							// Insert year of publication
							System.out.print("Year of publication :> ");

							try {
								pubYear = scanner.nextInt();
								scanner.nextLine();
							
							} catch (InputMismatchException e) {
							
								System.out.println("You didn't insert an integer");
							} catch (IllegalStateException | NoSuchElementException e) {
							
								System.out.println("There's been a problem, try again.");
								System.exit(-1);
							}

							bookshelf.addPhysicalBook(title, author, pubYear);
							
							System.out.println(" ");
							System.out.println("New physical book successfully created:");
							System.out.println(title);
							System.out.println("Written by: " +  author);
							System.out.println("Published in: " + pubYear);
							System.out.println(" ");

							break;
					
						// Add a digital book
						case 2:

							System.out.println(" ");
							System.out.print("Add a digital book.");
							System.out.println(" ");
							
							// Insert title
							System.out.print("Title :> ");
							
							try {
								title = scanner.nextLine();
							} catch (IllegalStateException | NoSuchElementException e) {
				
								System.out.println("There's been a problem, try again.");
								System.exit(-1);
							}

							// Insert author
							System.out.print("Author :> ");
							
							try {
								author = scanner.nextLine();
							} catch (IllegalStateException | NoSuchElementException e) {
				
								System.out.println("There's been a problem, try again.");
								System.exit(-1);
							}

							// Insert year of publication
							System.out.print("Year of publication :> ");

							try {
								pubYear = scanner.nextInt();
								scanner.nextLine();
							
							} catch (InputMismatchException e) {
							
								System.out.println("You didn't insert an integer");
							} catch (IllegalStateException | NoSuchElementException e) {
							
								System.out.println("There's been a problem, try again.");
								System.exit(-1);
							}

							// Insert file size 
							System.out.print("File size in KB :> ");

							try {
								kbFileSize = scanner.nextDouble();
								scanner.nextLine();
							
							} catch (InputMismatchException e) {
							
								System.out.println("You didn't insert a double");
							} catch (IllegalStateException | NoSuchElementException e) {
							
								System.out.println("There's been a problem, try again.");
								System.exit(-1);
							}

							bookshelf.addDigitalBook(title, author, pubYear, kbFileSize);
							
							System.out.println(" ");
							System.out.println("New digital book successfully created:");
							System.out.println(title);
							System.out.println("Written by: " +  author);
							System.out.println("Published in: " + pubYear);						
							System.out.println("File occupies: " + kbFileSize + " KB's");
							System.out.println(" ");						

							break;

						// Exit
						case 3:
							System.out.println(" ");
							System.out.println("Book creation menu exited.");
							break;
					}

					break;
				
				// Remove a book
				case 2:

					int userChoice = 0;

					do {
						
						System.out.println(" ");
						System.out.println("Are you sure you want to delete a book?");
						System.out.println("1. Yes");
						System.out.println("2. No");
						System.out.println(" ");

						try {
							userChoice = scanner.nextInt();
							scanner.nextLine();

						} catch (InputMismatchException e) {
					
							System.out.println("You didn't insert an integer, try again.");
							userChoice = 0;
				
						} catch (IllegalStateException | NoSuchElementException e) {
				
							System.out.println("There's been a problem, try again.");
							System.exit(-1);
						}

						if (userChoice < 1 || userChoice > 2) {
							System.out.println("Input not valid.");
						}
						
					} while (userChoice < 1 || userChoice > 2);
				

					switch (userChoice) {
						
						case 1:

							String titleToRemove = "";

							System.out.println(" ");
							System.out.println("Books list: ");
							bookshelf.booksList();
							
							System.out.print("Insert TITLE of the book you want to remove :> ");
									
							try {
								titleToRemove = scanner.nextLine();
							} catch (IllegalStateException | NoSuchElementException e) {
						
								System.out.println("There's been a problem, try again.");
								System.exit(-1);
							}
							
							try {
								bookshelf.removeBookByTitle(titleToRemove);
							} catch (Exception e) {
								System.out.println("There's been a problem, try again.");
							}
							
							System.out.println(" ");

							break;
					
						case 2:
							System.out.println(" ");
							System.out.println("Back to the menu.");
							break;
					}

					break;
				
				// View the full library
				case 3:

					System.out.println(" ");
					System.out.println("Full library: ");

					try {
						bookshelf.showBookshelf();
					} catch (Exception e) {
						System.out.println("There's been a problem, try again.");
					}

					System.out.println(" ");
					
					break;
				
				// Classics counter
				case 4:

					System.out.println(" ");
				
					int classics = bookshelf.classicsCounter();

					if (classics == 0) {
						System.out.println("There are no classic books in the bookshelf.");
					} else if (classics == 1){
						System.out.println("There's " + classics + " classic in the bookshelf.");
					} else if (classics > 1) {
						System.out.println("There are " + classics + " classics in the bookshelf.");
					}

					System.out.println(" ");
					
					break;
					
				// Digital books counter
				case 5:

					System.out.println(" ");

					int digitals = bookshelf.digitalsCounter();

					if (digitals == 0) {
						System.out.println("There are no digital books in the bookshelf.");
					} else if (digitals == 1){
						System.out.println("There's " + digitals + " digital book in the bookshelf.");
					} else if (digitals > 1) {
						System.out.println("There are " + digitals + " digital books in the bookshelf.");
					}
					
					System.out.println(" ");

					break;
				
				//Quit
				case 6:

					System.out.println(" "); 
					System.out.println("Bye!");
					break;
			}

			
		} while (userInput != 6);

		scanner.close();
    }
}