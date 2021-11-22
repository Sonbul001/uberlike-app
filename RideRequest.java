import java.util.ArrayList;

public class RideRequest {
    private static ArrayList<Driver> drivers = new ArrayList<Driver>();
    private Customer customer;
    private String source;
    private String destination;
    RideRequest(){

    }
    RideRequest(Customer c, String src, String dst){
        customer = c;
        source = src;
        destination = dst;
    }
    public static void addDriver(Driver d){
        drivers.add(d);
    }
    public static void removeDriver(Driver d){
        drivers.remove(d);
    }
    public static void publishRequest(Customer c, String src, String dst){
        for (Driver driver : drivers) {
            if(driver.getFavAreas().contains(src))
                driver.recieveRequest(c, src, dst);
        }
    }
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    public Customer getCustomer(){
        return customer;
    }
    public void setSource(String source){
        this.source = source;
    }
    public String getSource(){
        return source;
    }
    public void setDestination(String destination){
        this.destination = destination;
    }
    public String getDestination(){
        return destination;
    }
}
