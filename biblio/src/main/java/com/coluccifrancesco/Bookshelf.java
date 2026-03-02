package com.coluccifrancesco;

public class Bookshelf {

    public static final int BOOKSHELF_LIMIT = 50;
    private Book[] bookshelf = new Book[BOOKSHELF_LIMIT];
    
    public int booksOnTheShelf(){
        
        int booksOnTheBookshelf = 0;

        for(int i = 0; i < BOOKSHELF_LIMIT; i++){
            if (bookshelf[i] != null) {
                booksOnTheBookshelf += 1;
            }
        }

        return booksOnTheBookshelf;
    }

    public int emptySlots(){
        int emptySlots = (BOOKSHELF_LIMIT - booksOnTheShelf());
        return emptySlots;
    }

    public void addPhysicalBook(String title, String author, int pubYear){

        try {            
            
            if (emptySlots() > 0) {
    
                for(int i = 0; i < BOOKSHELF_LIMIT; i++){
    
                    if (bookshelf[i] == null) {
                        bookshelf[i] = new Book(title, author, pubYear);
                        System.out.println("Created " + bookshelf[i].getTitle() + "!");
                        break;
                    }
                }
            } 
        
        } catch (Exception e) {
            System.out.println("Bookshelf is full! Can't add a book at the moment.");
        }
    }


    public void addDigitalBook(String title, String author, int pubYear, int kbFileSize){

        try {            
            
            if (emptySlots() > 0) {
    
                for(int i = 0; i < BOOKSHELF_LIMIT; i++){
    
                    if (bookshelf[i] == null) {
                        bookshelf[i] = new DigitalBook(title, author, pubYear, kbFileSize);
                        System.out.println("Created " + bookshelf[i].getTitle() + "!");
                        break;
                    }
                }
            } 
        
        } catch (Exception e) {
            System.out.println("Bookshelf is full! Can't add a book at the moment.");
        }
    }

    public void showBookshelf(){

        for(int i = 0; i < BOOKSHELF_LIMIT; i++){
            
            if (bookshelf[i] != null) {
                
                System.out.println(bookshelf[i].toString());

                if (bookshelf[i].isClassic()) System.out.println(bookshelf[i].getTitle() + " is a classic.");
                
                if (bookshelf[i] instanceof DigitalBook){
                    System.out.println(bookshelf[i].getTitle() + " is digital.");
                    
                    DigitalBook that =  (DigitalBook) bookshelf[i];
                    if (that.isHuge()) System.out.println(that.getTitle() + " is huge too.");
                }

                System.out.println(" ");
            }
        }
    }

    public int classicsCounter(){
        int classics = 0;
        
        for(int i = 0; i < BOOKSHELF_LIMIT; i++){
            if (bookshelf[i] != null && bookshelf[i].isClassic()) classics += 1;
        }
        
        return classics;
    }

    public void removeBookByTitle(String titleToRemove){

        boolean bookFound = false;

        for(int i = 0; i < BOOKSHELF_LIMIT; i++){
            
            if (bookshelf[i] != null && bookshelf[i].getTitle().equals(titleToRemove)) {
                bookFound = true;
                bookshelf[i] = null;
                System.out.println(titleToRemove + " has been thrown away.");
                break;
            }
        }

        if (!bookFound) System.out.println("No " + titleToRemove + " on the bookshelf.");
    }
}