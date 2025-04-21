package admin;

import java.util.ArrayList;
import java.util.List;
public class House {
    private String houseId;
    private String address;
    private double rent;
    private int numRooms;
    private List<String> amenities;
    private String imagePath;
    private List<String> inquiries;

    public House(String houseId, String address, double rent, int numRooms, List<String> amenities, String imagePath) {
        this.houseId = houseId;
        this.address = address;
        this.rent = rent;
        this.numRooms = numRooms;
        this.amenities = amenities;
        this.imagePath = imagePath;
        this.inquiries = new ArrayList<>();
    }

    public String getHouseId() {
        return houseId;
    }

    public void updateHouse(String address, double rent, int numRooms, List<String> amenities, String imagePath) {
        this.address = address;
        this.rent = rent;
        this.numRooms = numRooms;
        this.amenities = amenities;
        this.imagePath = imagePath;
    }

    public void addInquiry(String inquiry) {
        inquiries.add(inquiry);
    }

    public List<String> getInquiries() {
        return inquiries;
    }

    public String getAddress() {
        return address;
    }

    public double getRent() {
        return rent;
    }

    public int getNumRooms() {
        return numRooms;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public String getImagePath() {
        return imagePath;
    }

    @Override
    public String toString() {
        return "House ID: " + houseId +
               "\nAddress: " + address +
               "\nRent: RM" + rent +
               "\nRooms: " + numRooms +
               "\nAmenities: " + String.join(", ", amenities) +
               "\nImage Path: " + imagePath +
               "\nInquiries: " + inquiries;
    }
}


