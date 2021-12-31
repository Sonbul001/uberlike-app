public class CustomerController {
    private CustomerView view;
    private CustomerModel model;
    private Customer customer;
    
    public CustomerController(Customer customer, CustomerModel model){
        this.customer = customer;
        this.model = model;
    }
    public void setView(CustomerView view){
        this.view = view;
    }
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    public void register(Customer customer){
        model.insert(customer);
        view.print("Registeration Successful");
    }
    public Customer login(Customer customer){
        if(model.check(customer)){
            customer = model.getInfo(customer.getUserName());
            view.print("Login Successful");
            return customer;
        }else{
            view.print("Login Failed");
            return null;
        }
    }
    public void request(String source, String destination){
        RideRequest r = new RideRequest(source,destination,this.customer);
        r.publishRequest();
        view.print("A request has been sent");
    }
    public String listOffers(){
        return model.listOffers(this.customer);
    }
    public void selectOffer(int offerID){
        new DriverController().startRide(offerID);
        view.print("Offer has been selected and the ride is about to start");
    }
    public void rateCompletedRide(int rating){
        model.rateCompletedRide(rating,this.customer);
        view.print("Rating has been saved");
    }
    public void clearNotifications(){
        model.clearNotifications(customer.getUserName());
    }
}
