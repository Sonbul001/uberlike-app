import java.util.ArrayList;

public class Driver extends User {
    private DrivingLicense drivingLicense;
    private NationalID nationalID;
    private float balance;
    private ArrayList<String> favAreas = new ArrayList<String>();
    private ArrayList<Ride> rideHistory = new ArrayList<Ride>();
    private ArrayList<RideRequest> availableRequests = new ArrayList<RideRequest>();

    Driver(){
        
    }
    Driver(String id, String email, String pwd, int mobile, DrivingLicense d, NationalID nid){

    }
    public void register(){

    }
    public void addFavArea(String area){
        favAreas.add(area);
    }
    public void removeFavArea(String area){
        favAreas.remove(area);
    }
    public ArrayList<String> getFavAreas(){
        return favAreas;
    }
    public void listRequests(){
        for (RideRequest r : availableRequests) {
            System.out.println("Customer: "+r.getCustomer());
            System.out.println("Source: "+r.getSource());
            System.out.println("Destination: "+r.getDestination()+"\n");
        }
    }
    public void createOffer(Driver d, Customer c, String src, String dst, float price){

    }
    public void recieveRequest(Customer c, String src, String dst){
        System.out.println("A new request was recieved !");
        availableRequests.add(new RideRequest(c, src, dst));
    }
    public void endRide(Ride r){

    }

}
