public class KindleTest {

    private int totalPage;
    private int currentPage;


    public KindleTest(int theTotalPages) {
        totalPage = theTotalPages;
        currentPage = 1;
    } // end of constructor with 1 parameter

    public String toString() {
        return ("Page " + this.currentPage + " of " + this.totalPage);
    } // end of string method


    // method to turn pages
    public void turnPages(int currentPage) {
        int thisCurrentPage = currentPage;
    }

} // end of the KindleTest class
