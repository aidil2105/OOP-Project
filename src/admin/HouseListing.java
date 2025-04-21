package admin;

import admin.House;
import java.util.*;
public class HouseListing {
        private Map<String, List<House>> listings = new HashMap<>();

    public void addHouse(String landlordUsername, House house) {
        listings.computeIfAbsent(landlordUsername, k -> new ArrayList<>()).add(house);
        System.out.println("House added for " + landlordUsername);
    }

    public void updateHouse(String landlordUsername, String houseId, House updatedHouse) {
        List<House> houses = listings.get(landlordUsername);
        if (houses != null) {
            for (House house : houses) {
                if (house.getHouseId().equals(houseId)) {
                    house.updateHouse(
                        updatedHouse.getAddress(),
                        updatedHouse.getRent(),
                        updatedHouse.getNumRooms(),
                        updatedHouse.getAmenities(),
                        updatedHouse.getImagePath()
                    );
                    System.out.println("House updated.");
                    return;
                }
            }
        }
        System.out.println("House not found.");
    }

    public void deleteHouse(String landlordUsername, String houseId) {
        List<House> houses = listings.get(landlordUsername);
        if (houses != null && houses.removeIf(h -> h.getHouseId().equals(houseId))) {
            System.out.println("House deleted.");
        } else {
            System.out.println("House not found.");
        }
    }

    public void showAllHouses(String landlordUsername) {
        List<House> houses = listings.getOrDefault(landlordUsername, new ArrayList<>());
        if (houses.isEmpty()) {
            System.out.println("No listings found.");
        } else {
            for (House house : houses) {
                System.out.println(house);
                System.out.println("----");
            }
        }
    }

    public void showInquiries(String landlordUsername, String houseId) {
        List<House> houses = listings.get(landlordUsername);
        if (houses != null) {
            for (House house : houses) {
                if (house.getHouseId().equals(houseId)) {
                    System.out.println("Inquiries:");
                    for (String inquiry : house.getInquiries()) {
                        System.out.println("- " + inquiry);
                    }
                    return;
                }
            }
        }
        System.out.println("No inquiries found.");
}
}