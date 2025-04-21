package admin;


import admin.Payment;
import admin.Student;
import java.util.Date;
import java.util.Scanner;

public class PaymentMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a student
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();

        Student student = new Student(studentId, studentName);

        // Get the payment amount from the user
        System.out.print("Enter Payment Amount: ");
        double paymentAmount = scanner.nextDouble();

        // Get the number of days until the payment is due
        System.out.print("Enter number of days until the payment is due: ");
        int daysUntilDue = scanner.nextInt();

        // Create a payment with due date set accordingly
        Payment payment = new Payment(paymentAmount, new Date(System.currentTimeMillis() + (daysUntilDue * 86400000L)));  // Due date based on input

        // Simulate payment confirmation
        student.makePayment(payment);

        // Check if the payment is overdue
        student.checkOverduePayments(payment);

        // Close scanner
        scanner.close();
    }
}