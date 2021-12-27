public class Ride {
    private String source;
    private String destination;
    private Customer customer;
    private Driver driver;
    private boolean isCompleted = false;
    
    public Ride(String source, String destination, Customer customer){
        this.source = source;
        this.destination = destination;
        this.customer = customer;
    }
    public void setDriver(Driver driver){
        this.driver = driver;
    }
    public void isCompleted(boolean status){
        isCompleted = status;
    }
}
