public class DriverController {
    private DriverModel model;
    private DriverView view;
    private Driver driver;
    private Ride ride;
    
    public DriverController(){
        this.model = null;
        this.view = null;
        this.driver = null;
        this.ride = null;
    }
    public DriverController( Driver driver,DriverModel model){
    	this.driver=driver;
        this.model = model;
    }
    public void setView(DriverView view){
        this.view = view;
    }
    public void setDriver(Driver driver){
        this.driver = driver;
    }
    public void register(Driver driver){
        model.insert(driver);
        view.print("Registeration Successful");
    }
    public Driver login(Driver driver){
        if(model.check(driver)){
            driver = model.getInfo(driver.getUserName());
            view.print("Login Successful");
            return driver;
        }else{
            view.print("Login Failed");
            return null;
        }
    }
    public void addFavArea(String area){
        model.addFavArea(driver.getUserName(), area);
    }
    public void removeFavArea(String area){
        model.removeFavArea(driver.getUserName(), area);
    }
    public void createOffer(String customerName, String source, String destination, double price){
        Offer offer = new Offer(customerName, source, destination, driver, price);
        offer.publishOffer();
    }
    public String listRequests(){
        return model.listRequests(driver);
    }
    public void clearNotifications(){
        model.clearNotifications(driver.getUserName());
    }
    public void setRide(Ride ride){
        this.ride = ride;
    }
    public void startRide(int offerID){
        Ride currentRide = new Ride();
        ride = currentRide.getInfo(offerID);
        RideController rideController = new RideController(ride);
        rideController.startRide();
    }
    public void endRide(){
        Ride currentRide = new Ride();
        ride = currentRide.getInfo(this.driver.getUserName());
        if(ride == null){
            view.print("No active rides");
        }else{
            RideController rideController = new RideController(ride);
            rideController.endRide();
        }
    }
}