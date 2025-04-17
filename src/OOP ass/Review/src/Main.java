
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReviewSystem system = new ReviewSystem();

        // === Submit a Review ===
        System.out.println("=== Submit a Review ===");
        System.out.print("Enter House ID: ");
        int houseID = scanner.nextInt();

        System.out.print("Enter Student ID: ");
        int studentID = scanner.nextInt();

        System.out.print("Enter Rating (1-5): ");
        int rating = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter Comment: ");
        String comment = scanner.nextLine();

        Review review = new Review(houseID, studentID, rating, comment);
        system.submitReview(review);

        // === Optional Editing ===
        System.out.print("\nDo you want to edit your review? (yes/no): ");
        String edit = scanner.nextLine();

        if (edit.equalsIgnoreCase("yes")) {
            System.out.print("Enter Review ID to edit: ");
            int editID = scanner.nextInt();
            scanner.nextLine(); // consume newline
            Review found = system.findReviewByID(editID);

            if (found != null) {
                System.out.print("Enter new rating (1-5): ");
                int newRating = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter new comment: ");
                String newComment = scanner.nextLine();

                found.editingReview(newRating, newComment);
            } else {
                System.out.println("Review not found.");
            }
        }

        // === Show All Reviews ===
        System.out.println("\n=== All Reviews ===");
        system.showAllReviews();

        // === Show Average Rating for House ===
        System.out.print("\nEnter House ID to calculate average rating: ");
        int houseToCheck = scanner.nextInt();
        double avg = system.calculateAverageRating(houseToCheck);
        System.out.printf("Average Rating for House ID %d: %.2f\n", houseToCheck, avg);

        scanner.close();
    }
}