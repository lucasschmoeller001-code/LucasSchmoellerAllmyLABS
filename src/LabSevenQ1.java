public class LabSevenQ1 {
    static class Book {
        private String title;
        private String author;
        private int totalPages;
        private int currentPages;

        public Book(String title, String author, int totalPages) {
            this.title = title;
            this.author = author;
            this.totalPages = totalPages;
            this.currentPages = 0; //starts at 0
        }
        public void readPages(int pages) {
            if (pages < 0) { //has to be greater than 0
                System.out.println("Invalid Number Of Pages.");
                return;
            }
            currentPages += pages; //adds pages read to current amount

            if (currentPages > totalPages) {
                currentPages = totalPages; //cannot pass the total amount of pages
            }
            System.out.println(" Currently on page " + currentPages + "/" + totalPages);
        }
        public double getProgress() {
            return ((double) (currentPages * 100) / totalPages); //multiply by 100 to give a percentage as a whole number
        }
        public boolean isFinished(){
            return currentPages == totalPages;
        }
        public String getTitle() {
            return title;
        }
        public String getAuthor() {
            return author;
        }
        public String toString(){
            return title + " By " + author + " Pages: " + currentPages + "/" + totalPages;
        }
    }
        public static void main(String[] args){
           //creates the books
            Book bookOne = new Book (" The Departed ", " Joe Swanson ", 365);
            Book bookTwo = new Book (" My Life ", " Luke Schmo ", 405);
            //pages that are read
            bookOne.readPages(29);
            bookTwo.readPages(203);

            System.out.println(bookOne);
            System.out.printf(" Progress: %.2f%%\n", bookOne.getProgress());

            System.out.println(bookTwo);
            System.out.printf(" Progress: %.2f%%\n", bookTwo.getProgress());

            bookOne.readPages(336);
            System.out.println(" Finished The Departed? " + (bookOne.isFinished() ? "Yes" : "No"));
        }

    }


