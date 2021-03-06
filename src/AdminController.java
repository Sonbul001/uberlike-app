public class AdminController {
    private AdminModel model;
    private AdminView view;
    private Admin admin;
    private DriverModel pendingDrivers;
    
    public AdminController(Admin admin, AdminModel model){
        this.admin = admin;
        this.model = model;
        pendingDrivers = new DriverModel();
    }
    public void setView(AdminView view){
        this.view = view;
    }
    public void setAdmin(Admin admin){
        this.admin = admin;
    }
    public void register(Admin admin){
        model.insert(admin);
        view.print("Registeration Successful");
    }
    public boolean login(Admin admin){
        if(model.check(admin)){
            view.print("Login Successful");
            return true;
        }else{
            view.print("Login Failed");
            return false;
        }
    }
    public void listPendingDrivers(){
        String message = pendingDrivers.getPendingDrivers();
        view.print(message);
    }
    public void approveDriver(String driverUserName){
        pendingDrivers.insert("UPDATE Drivers SET isRegistered = true where driverID='" + driverUserName +"'");
        view.print(driverUserName + " is approved successfully ");
    }
    public void denyDriver(String driverUserName){
        pendingDrivers.remove(driverUserName);
        view.print(driverUserName + " is denied successfully");
    }
}
