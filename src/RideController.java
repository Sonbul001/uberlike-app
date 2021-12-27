public class RideController {
    private Ride ride;
    private RideStrategy strategy;
    
    public void setRide(Ride ride){
        this.ride = ride;
    }
    public void calcDistance(){
        
    }
    public void endRide(){
        ride.isCompleted(true);
    }
}
