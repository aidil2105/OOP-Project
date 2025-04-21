package admin;

import java.util.Date;
import java.util.Scanner;

// Payment class to track rent payment status
class Payment {
    private static int paymentCounter = 1;
    private int paymentId;
    double amount;
    private Date dueDate;
    private Date paymentDate;
    private String status; // "Paid", "Pending", "Overdue", "On Time"

    public Payment(double amount, Date dueDate) {
        this.paymentId = paymentCounter++;
        this.amount = amount;
        this.dueDate = dueDate;
        this.status = "Pending"; // Initially status is "Pending"
    }

    // Confirm payment
    public void confirmPayment() {
        this.paymentDate = new Date();  // Current time of payment confirmation
        if (paymentDate.before(dueDate) || paymentDate.equals(dueDate)) {
            this.status = "On Time";  // If paid before or on the due date
        } else {
            this.status = "Paid";  // If paid after the due date
        }
    }

    // Check if payment is overdue
    public boolean isOverdue() {
        return status.equals("Pending") && new Date().after(dueDate); // Overdue if current date is after the due date
    }

    public String getStatus() {
        return status;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void printPaymentDetails() {
        System.out.println("Payment ID: " + paymentId + ", Amount: " + amount + ", Due Date: " + dueDate + ", Status: " + status);
    }
}

// Student class to represent a student who can make payments
class Student {
    private int studentId;
    private String studentName;

    public Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    // Make a payment for rent
    public void makePayment(Payment payment) {
        payment.confirmPayment();
        System.out.println("Payment confirmed for student: " + studentName);
        payment.printPaymentDetails();
    }

    // Check if there are overdue payments
    public void checkOverduePayments(Payment payment) {
        if (payment.isOverdue()) {
            System.out.println("Your payment for " + payment.amount + " is overdue!");
        } else {
            System.out.println("Your payment is not overdue.");
        }
    }
}