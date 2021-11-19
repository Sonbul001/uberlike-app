public class Driver extends User {
    private Car car;
    private DrivingLicense drivingLicense;
    private NationalID nationalID;
    private float balance;
    private String[] FavAreas;
    private Ride[] rideHistory;
    private String[] availableRequests;

    Driver(){

    }
    Driver(String id, String email, String pwd, int mobile, Car c, DrivingLicense d, NationalID nid){

    }
    public void register(){

    }
    public void addFavArea(String area){

    }
    public void removeFavArea(String area){

    }
    public void listRequests(){

    }
    public void createOffer(Driver d, Customer c, String src, String dst, float price){

    }
    public void recieveRequest(Customer c, String src, String d){

    }
    public void endRide(Ride r){

    }

}
