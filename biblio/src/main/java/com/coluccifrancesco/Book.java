package com.coluccifrancesco;

import java.time.LocalDate;

public class Book {

    private String title;
    private String author;
    private int pubYear;

    // Constructor
    public Book(String title, String author, int pubYear){
        
        // invalid input handling
        if (title.equals("") || author.equals("") || pubYear > LocalDate.now().getYear() || pubYear < (-1000)){
            throw new IllegalArgumentException("Cannot create character");
        } else {

            this.title = title;
            this.author = author;
            this.pubYear = pubYear;
        }
    } 
    
    // Setters
    public void setTitle(String title){
        if (title.equals("")){
            throw new IllegalArgumentException("Cannot set title");
        } else {
            this.title = title;
        }
    }

    public void setAuthor(String author){
        if (author.equals("")){
            throw new IllegalArgumentException("Cannot set author");
        } else {
            this.author = author;
        }
    }

    public void setPubYear(int pubYear){
        if (pubYear > LocalDate.now().getYear() || pubYear < (-1000)){
            throw new IllegalArgumentException("Cannot set publication year");
        } else {
            this.pubYear = pubYear;
        }
    }
    
    // Getters
    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public int getPubYear(){
        return this.pubYear;
    }

    // Class related function
    public boolean isClassic(){

        if ((LocalDate.now().getYear() - pubYear) < 50){
            return false;
        }

        return true;
    }

    // Overrides
    @Override
    public String toString(){
        return this.title + " by " + this.author + ", published in " + this.pubYear;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return pubYear == book.pubYear && title.equals(book.title) && author.equals(book.author);
    }
}
