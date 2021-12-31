public class RideController {
    private Ride ride;
    private RideStrategy strategy;
    
    public RideController(Ride ride){
        this.ride = ride;
    }
    public String startRide(){
        return calcDistance();
    }
    public String calcDistance(){
        return "Distance calculated";
    }
    public void endRide(){
        ride.completed();
    }
}
