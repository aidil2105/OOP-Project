import java.util.Scanner;
import java.util.Date;

// House class
class House {
    private int houseId;
    private String houseName;
    private boolean isAvailable;

    public House(int houseId, String houseName) {
        this.houseId = houseId;
        this.houseName = houseName;
        this.isAvailable = true; // Initially, the house is available
    }

    public void updateAvailability(boolean status) {
        this.isAvailable = status;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public int getHouseId() {
        return this.houseId;
    }

    public String getHouseName() {
        return this.houseName;
    }

    public void printHouseDetails() {
        System.out.println("House ID: " + houseId + ", Name: " + houseName + ", Available: " + isAvailable);
    }
}

// Student class
class Student {
    private int studentId;
    private String studentName;

    public Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public String getStudentName() {
        return this.studentName;
    }

    // Method to request booking
    public void requestBooking(House house, Landlord landlord) {
        if (house.isAvailable()) {
            // Create a new booking request and send it to the landlord
            Booking bookingRequest = new Booking(this, house); // Create the booking request here
            landlord.receiveBookingRequest(bookingRequest);    // Send it to the landlord
        } else {
            System.out.println("Sorry, the house " + house.getHouseName() + " is not available.");
        }
    }
}

// Booking class
class Booking {
    private static int bookingCounter = 1; // Static counter to generate Booking ID
    private int bookingId;
    private Student student;
    private House house;
    private Date bookingDate;
    private String status;

    public Booking(Student student, House house) {
        this.bookingId = bookingCounter++; // Increment the counter for each new booking
        this.student = student;
        this.house = house;
        this.bookingDate = new Date();  // Current date
        this.status = "Pending"; // Initial status
    }

    // Getters for Booking details
    public int getBookingId() {
        return this.bookingId;
    }

    public int getStudentId() {
        return this.student.getStudentId();
    }

    public int getHouseId() {
        return this.house.getHouseId();
    }

    public Date getBookingDate() {
        return this.bookingDate;
    }

    public String getStatus() {
        return this.status;
    }

    // Approve the booking
    public void approveBooking() {
        this.status = "Approved";
        house.updateAvailability(false); // House is no longer available
    }

    // Reject the booking
    public void rejectBooking() {
        this.status = "Rejected";
    }

    // Print Booking details
    public void printBookingDetails() {
        System.out.println("Booking ID: " + bookingId + ", Student ID: " + student.getStudentId() + 
                           ", House ID: " + house.getHouseId() + ", Booking Date: " + bookingDate + 
                           ", Status: " + status);
    }
}

// Landlord class
class Landlord {
    private int landlordId;
    private String landlordName;

    public Landlord(int landlordId, String landlordName) {
        this.landlordId = landlordId;
        this.landlordName = landlordName;
    }

    // Landlord's method to input name via user input
    public static Landlord createLandlord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Landlord's ID: ");
        int landlordId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Landlord's Name: ");
        String landlordName = scanner.nextLine();
        return new Landlord(landlordId, landlordName);
    }

    // Receive booking request from student
    public void receiveBookingRequest(Booking bookingRequest) {
        System.out.println("New booking request from Student ID: " + bookingRequest.getStudentId() + 
                           " for House ID: " + bookingRequest.getHouseId());
    }

    // Approve booking request
    public void approveBooking(Booking bookingRequest) {
        bookingRequest.approveBooking();
        System.out.println("Booking ID " + bookingRequest.getBookingId() + " has been approved.");
    }

    // Reject booking request
    public void rejectBooking(Booking bookingRequest) {
        bookingRequest.rejectBooking();
        System.out.println("Booking ID " + bookingRequest.getBookingId() + " has been rejected.");
    }
}

// Main class to test the system
public class Main {
    public static void main(String[] args) {
        // Create Scanner object to get user input
        Scanner scanner = new Scanner(System.in);

        // Create houses
        House house1 = new House(1, "House A");
        House house2 = new House(2, "House B");

        // Get student details from user
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character
        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();

        // Create a student object with the entered details
        Student student1 = new Student(studentId, studentName);

        // Create landlord object via user input
        Landlord landlord1 = Landlord.createLandlord();

        // Student requests a booking
        student1.requestBooking(house1, landlord1);

        // Let the landlord decide whether to approve or reject
        System.out.println("Do you want to approve or reject the booking? (approve/reject): ");
        String decision = scanner.nextLine();

        if (decision.equalsIgnoreCase("approve")) {
            // Find the booking that was created and approve it
            landlord1.approveBooking(new Booking(student1, house1));
        } else if (decision.equalsIgnoreCase("reject")) {
            // Find the booking that was created and reject it
            landlord1.rejectBooking(new Booking(student1, house1));
        } else {
            System.out.println("Invalid input! Booking will remain Pending.");
        }

        // Print house availability
        house1.printHouseDetails();

       
    }
}
