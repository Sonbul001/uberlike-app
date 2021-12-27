public class RideController {
    private Ride ride;
    private RideStrategy strategy;
    
    public RideController(Ride ride){
        this.ride = ride;
    }
    public void calcDistance(){
        
    }
    public void endRide(){
        ride.completed();
    }
}
