public class Offer {
    private Driver driver;
    private Customer customer;
    private String source;
    private String destination;
    private float Price;

    Offer(Driver d, Customer c, String src, String dst, float price){
        driver = d;
    	customer = c;
    	source = src;
    	destination = dst;
    	Price = price;
        c.recieveOffer(this);
    }
    public Driver getDriver(){
        return driver;
    }
    public String getSource(){
        return source;
    }
    public String getDestination(){
        return destination;
    }
    public float getPrice(){
        return Price;
    }
}
