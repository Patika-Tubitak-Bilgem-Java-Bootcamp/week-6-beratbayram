package utils;

import address.BusinessAddress;
import address.HomeAddress;

public class Utils {
    public static void print(String s) {
        System.out.println(s);
    }

    public static void print() {
        print("");
    }

    public static void printAddressInfo(BusinessAddress address) {
        _printAddress(
                address.getNeighbourhood(), address.getStreetName(), address.getBuildingName(),
                address.getFloorNumber(), address.getFlatNumber(), address.getPostCode(), address.getTown(),
                address.getDistrict(), address.getProvince(), address.getCountry()
        );
    }

    public static void printAddressInfo(HomeAddress address) {
        _printAddress(
                address.getNeighbourhood(), address.getStreetName(), address.getBuildingName(),
                address.getFloorNumber(), address.getFlatNumber(), address.getPostCode(), address.getTown(),
                address.getDistrict(), address.getProvince(), address.getCountry()
        );    }

    private static void _printAddress(
            String neighbourhood, String streetName, String buildingName, int floorNumber, int flatNumber,
            String postCode, String town, String district, String province, String country
    ) {
        print("Neighbourhood: " + neighbourhood);
        print("Street Name: " + streetName);
        print("Building Name: " + buildingName);
        print("Floor Name: " + floorNumber);
        print("Flat Number: " + flatNumber);
        print("Post Code: " + postCode);
        print("Town: " + town);
        print("District: " + district);
        print("Province: " + province);
        print("Country: " + country);
    }
}
