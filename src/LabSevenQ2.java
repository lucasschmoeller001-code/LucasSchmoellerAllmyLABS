public class LabSevenQ2 {
    public static class Movie {

    private String title;
    private int[] ratings;
    private int ratingCount;

    public Movie(String title) {
        this.title = title;
        this.ratings = new int[10]; //Sets limit of 10 for array
        this.ratingCount = 0;
    }

        public void addRating(int rating) {
            if (rating < 1 || rating > 5) {  //rating value should be between 1 and 5
                System.out.println( rating + " Is an invalid Input. Rating must be a number between 1 and 5");
                return;
            }
            if (ratingCount >= ratings.length) { //If amount of ratings reaches 10
                System.out.println("List is full already.");
                return;
            }
            ratings[ratingCount] = rating;
            ratingCount++;
        }

        public double getAverageRating() {
            if (ratingCount == 0) {
                return 0.0;
            }
            int sum = 0;
            for (int i = 0; i < ratingCount; i++) { // loops through ratings
                sum += ratings[i]; //adds them
            }
            return (double) sum / ratingCount; //gets the average in decimal
        }

        public int getHighestRating() {
            if (ratingCount == 0) {
                return 0;
            }
            int highest = ratings[0]; //first rating is the highest until replaced
            for (int i = 1; i < ratingCount; i++) { //loops through ratings
                if (ratings[i] > highest) {
                    highest = ratings[i]; // changes the highest with new highest
                }
            }
            return highest;
        }
        }
        public static void main(String[] args) {
            //movies
            Movie movieOne = new Movie("Astro-boy");
            Movie movieTwo = new Movie("Zodiac");

            //Movie ratings
            movieOne.addRating(3);
            movieOne.addRating(3);
            movieOne.addRating(4);
            movieOne.addRating(5);
            movieOne.addRating(5);
            movieOne.addRating(3);
            movieOne.addRating(5);
            movieOne.addRating(4);
            movieOne.addRating(3);
            movieOne.addRating(4);
            movieOne.addRating(4);

            movieTwo.addRating(7);
            movieTwo.addRating(3);
            movieTwo.addRating(3);
            movieTwo.addRating(2);
            movieTwo.addRating(1);

            System.out.println(movieOne.title + " Avg Rating: " + movieOne.getAverageRating() + " Highest Rating: " + movieOne.getHighestRating());
            System.out.println(movieTwo.title + " Avg Rating: " + movieTwo.getAverageRating() + " Highest Rating: " + movieTwo.getHighestRating());

        }
}
