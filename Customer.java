import java.util.ArrayList;

public class Customer extends User{
    private ArrayList<Offer> offers = new ArrayList<Offer>();
    private CustomerRegisteration cRegisteration = new CustomerRegisteration();

    Customer(){

    }
    Customer(String id, String email, String pwd, String mobile){
        userName = id;
        this.email = email;
        password = pwd;
        mobileNo = mobile;
    }
    Customer(String id, String pwd){
        userName = id;
        password = pwd;
    }
    public void register(){
        cRegisteration.register(this);
    }
    public boolean login(){
        return cRegisteration.login(this);
    }
    public void request(String src, String dst){
        RideRequest.publishRequest(this, src, dst);
    }
    public void recieveOffer(Offer o){
        System.out.println("You got a new offer "+this.userName+"\n");
        offers.add(o);
    }
    public void listOffers(){
        for (Offer offer : offers) {
            System.out.println("Offer:");
            System.out.println("Driver: " + offer.getDriver().userName);
            System.out.println("Source: " + offer.getSource());
            System.out.println("Destination: " + offer.getDestination());
            System.out.println("Price: " + offer.getPrice() + "\n");
        }
    }
    public void selectOffer(Offer o){

    }
    public void rateCompletedRide(){
        
    }
}
