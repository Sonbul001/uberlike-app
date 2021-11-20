import java.util.ArrayList;

public class RideRequest {
    private ArrayList<Driver> drivers = new ArrayList<Driver>();
    private Customer customer;
    private String source;
    private String destination;

    RideRequest(Customer c, String src, String dst){
        customer = c;
        source = src;
        destination = dst;
    }
    public void addDriver(Driver d){
        drivers.add(d);
    }
    public void removeDriver(Driver d){
        drivers.remove(d);
    }
    public void publishRequest(Customer c, String src, String dst){
        for (Driver driver : drivers) {
            if(driver.getFavAreas().contains(src))
                driver.recieveRequest(c, src, dst);
        }
    }
    public Customer getCustomer(){
        return customer;
    }
    public String getSource(){
        return source;
    }
    public String getDestination(){
        return destination;
    }
}
