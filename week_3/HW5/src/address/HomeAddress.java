package address;

public class HomeAddress implements Address {

    private final String neighbourhood;
    private final String streetName;
    private final String buildingName;
    private final int floorNumber;
    private final int flatNumber;
    private final String

            postCode;
    private final String town;
    private final String district;
    private final String province;
    private final String country;
    private static int totalId = 1;
    private final int id;


    public HomeAddress(String neighbourhood, String streetName, String buildingName, int floorNumber, int flatNumber,
                       String postCode, String town, String district, String province, String country) {

        this.neighbourhood = neighbourhood;
        this.streetName = streetName;
        this.buildingName = buildingName;
        this.floorNumber = floorNumber;
        this.flatNumber = flatNumber;
        this.postCode = postCode;
        this.town = town;
        this.district = district;
        this.province = province;
        this.country = country;
        this.id = totalId++;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        if (this.getClass().getName().equals("HomeAddress")) {
            HomeAddress homeAddress = (HomeAddress) obj;
            return (homeAddress.getId() != this.getId());
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        return this.id;
    }

    @Override
    public void printAddress() {

    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getTown() {
        return town;
    }

    public String getDistrict() {
        return district;
    }

    public String getProvince() {
        return province;
    }

    public String getCountry() {
        return country;
    }

    public int getId() {
        return id;
    }
}
