import java.util.ArrayList;
import java.util.Scanner;

// === Review Class ===
class Review {
    private static int reviewCounter = 1;
    private int reviewID;
    private int houseID;
    private int studentID;
    private int rating; // 1-5
    private String comment;

    public Review(int houseID, int studentID, int rating, String comment) {
        this.reviewID = reviewCounter++;
        this.houseID = houseID;
        this.studentID = studentID;
        this.rating = rating;
        this.comment = comment;
    }

    public int getReviewID() {
        return reviewID;
    }

    public int getHouseID() {
        return houseID;
    }

    public int getStudentID() {
        return studentID;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public void editingReview(int newRating, String newComment) {
        this.rating = newRating;
        this.comment = newComment;
        System.out.println("Review ID " + reviewID + " has been updated.");
    }

    public void printReview() {
        System.out.println("Review ID: " + reviewID + ", House ID: " + houseID + ", Student ID: " + studentID);
        System.out.println("⭐ Rating: " + rating + " | Comment: \"" + comment + "\"");
    }
}

// === ReviewSystem Class ===
class ReviewSystem {
    private ArrayList<Review> reviews = new ArrayList<>();

    public void submitReview(Review review) {
        reviews.add(review);
        System.out.println("Review submitted successfully (Review ID: " + review.getReviewID() + ")");
    }

    public void showAllReviews() {
        for (Review r : reviews) {
            System.out.println("--------------------------------------------------");
            r.printReview();
        }
    }

    public Review findReviewByID(int reviewID) {
        for (Review r : reviews) {
            if (r.getReviewID() == reviewID) {
                return r;
            }
        }
        return null;
    }

    public double calculateAverageRating(int houseID) {
        int total = 0, count = 0;
        for (Review r : reviews) {
            if (r.getHouseID() == houseID) {
                total += r.getRating();
                count++;
            }
        }
        return count == 0 ? 0.0 : (double) total / count;
    }
}