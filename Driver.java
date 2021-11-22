import java.util.ArrayList;

public class Driver extends User {
    private Admin admin;
    private DrivingLicense drivingLicense;
    private NationalID nationalID;
    private float balance;
    private ArrayList<String> favAreas = new ArrayList<String>();
    private ArrayList<Ride> rideHistory = new ArrayList<Ride>();
    private ArrayList<RideRequest> availableRequests = new ArrayList<RideRequest>();
    private DriverRegisteration dRegisteration = new DriverRegisteration();

    Driver(){
        userName = "";
        email = "";
        password = "";
        mobileNo = "";
        drivingLicense = null;
        nationalID = null;
        balance = 0;
        favAreas = null;
        rideHistory = null;
        availableRequests = null;
        dRegisteration = null;
        RideRequest.addDriver(this);
    }
    Driver(String id, String email, String pwd, String mobile, DrivingLicense d, NationalID nid, Admin admin){
        userName = id;
        this.email = email;
        password = pwd;
        mobileNo = mobile;
        drivingLicense = d;
        nationalID = nid;
        this.admin = admin;
        RideRequest.addDriver(this);
    }
    Driver(String id, String pwd){
        userName = id;
        password = pwd;
        RideRequest.addDriver(this);
    }
    public void register(){
        dRegisteration.addAdmin(admin);
        dRegisteration.register(this);
    }
    public boolean login(){
        dRegisteration.addAdmin(admin);
        return dRegisteration.login(this);
    }
    public void addFavArea(String area){
        favAreas.add(area);
    }
    public void removeFavArea(String area){
        if(!favAreas.remove(area)){
            System.out.println("Area not found");
        }
    }
    public ArrayList<String> getFavAreas(){
        return favAreas;
    }
    public void listRequests(){
        for (RideRequest r : availableRequests) {
            System.out.println("Customer: "+r.getCustomer().userName);
            System.out.println("Source: "+r.getSource());
            System.out.println("Destination: "+r.getDestination()+"\n");
        }
    }
    public void createOffer(Customer c, String src, String dst, float price){
        new Offer(this,c,src,dst,price);
    }
    public void recieveRequest(Customer c, String src, String dst){
        System.out.println("A new request was recieved " + this.userName + " !\n");
        availableRequests.add(new RideRequest(c, src, dst));
    }
    public void notifyFromAdmin(String message){
        System.out.println(message);
    }
    public NationalID getNationalID(){
        return nationalID;
    }
    public DrivingLicense getDrivingLicense(){
        return drivingLicense;
    }
    public void endRide(Ride r){

    }

}
