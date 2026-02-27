package com.coluccifrancesco;

public class DigitalBook extends Book {

    private double kbFileSize;

    public DigitalBook(String title, String author, int pubYear, double kbFileSize){

        // Super --> Book's class constructor
        super (title, author, pubYear);

        this.kbFileSize = kbFileSize;
    }

    public void setKbFileSize(double kbFileSize){
        if (kbFileSize <= 0) {
            throw new IllegalArgumentException("File size can't be 0 or less");
        } else {
            this.kbFileSize = kbFileSize;
        }
    }

    public double getKbFileSize() {
        return this.kbFileSize;
    }

    // Class related functions
    public double sizeInMb(){
        return (this.kbFileSize / 1000);
    }

    // isHuge
    public boolean isHuge(){
        if(sizeInMb() < 100) return false;
        return true;
    }


    // Overrides
    @Override
    public String toString(){
        return "Title: " + this.getTitle() + "\nAuthor: " + this.getAuthor() + "\nPublication Year: " + this.getPubYear() + "\nFile Size (KB): " + this.getKbFileSize();
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        DigitalBook that = (DigitalBook) obj;
        return Double.compare(that.kbFileSize, kbFileSize) == 0;
    }
}
