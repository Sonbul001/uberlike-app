import java.util.ArrayList;

public class Customer extends User{
    private ArrayList<Offer> offers = new ArrayList<Offer>();
    private RideRequest rideRequest;

    Customer(){

    }
    Customer(String id, String email, String pwd, int mobile){

    }
    public void register(){

    }
    public void request(String src, String dst){
        rideRequest.publishRequest(this, src, dst);
    }
    public void recieveOffer(Offer o){

    }
    public void listOffers(){

    }
    public void selectOffer(Offer o){

    }
    public void rateCompletedRide(){
        
    }
}
