
public class Kindle {
    private int totalPages;  // Stores the total number of pages in the book
    private int currentPage; // Stores the current page the reader is on

    // Constructor that sets the total number of pages and initializes current page to 1
    public Kindle(int totalPages) {
        this.totalPages = totalPages;
        this.currentPage = 1;
    } // end off inner Kindle class

    // toString method to display the current page and the total pages in the book

    public String toString() {
        return String.format("Page %3d of %3d", this.currentPage, this.totalPages);
    }

    // Method to turn one page by default (overloaded)
    public void turnPages() {
        turnPages(1);  // Calls the overloaded method to turn one page
    }
    // Overloaded method to turn a specified number of pages
    public void turnPages(int pages) {
        if (pages < 0) {
            System.out.println("Invalid page increment.");
            return;
        } // error if pages less than 0

        int newPage = this.currentPage + pages;  // Calculate the new page number

        if (newPage > this.totalPages) {
            System.out.println("Turning " + pages + " pages would take you past the last page.");
            this.currentPage = this.totalPages;  // Set to the last page if over
        } else {
            this.currentPage = newPage;  // Update to the new page
        }

        // Print current status after turning pages
        System.out.print("You are now on             : ");
        System.out.println(this);
    } // end of turnPages class
} // end of outer Kindle class



