import java.util.Scanner;
public class DriverView {
    private DriverController controller;
    private Driver driver;
    
    public DriverView(Driver driver, DriverController controller){
        this.driver = driver;
        this.controller = controller;
    }
    public void menuStart(){
        boolean checked = false;
        boolean exit = false;
        String userName;
        String pwd;
        String mail;
        String mobileNo;
        String drivingLicense;
        String nationalID;
        
        Scanner input = new Scanner(System.in);
        int choice;
        System.out.println("This is the driver menu");
        while(!checked){
            System.out.println("\nPlease select one of the following choices:");
            System.out.println("1.Register");
            System.out.println("2.Login");
            System.out.println("3.Exit");
            choice = input.nextInt();
            input.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Please enter the username, email,password,mobile number,driving licence,national id");
                    userName = input.nextLine();
                    mail = input.nextLine();
                    pwd = input.nextLine();
                    mobileNo = input.nextLine();
                    drivingLicense = input.nextLine();
                    nationalID = input.nextLine();
                    Driver driver1 = new Driver(userName,mail,pwd,mobileNo,drivingLicense,nationalID);
                    driver = driver1;
                    controller.register(driver1);
                    controller.setDriver(driver);
                    checked = true;
                    break;
                case 2:
                    System.out.println("Please enter the username and password");
                    userName = input.nextLine();
                    pwd = input.nextLine();
                    Driver driver2 = new Driver(userName,pwd);
                    driver = controller.login(driver2);
                    if(driver != null){
                        checked = true;
                        controller.setDriver(driver);
                    }
                    break;
                case 3:
                    exit = true;
                    checked = true;
                    break;
                default:
                    System.out.println("Wrong Input");
            }
        }
        if(!exit && driver.registerationStatus()){
            String area;
            String customerName;
            String source;
            String destination;
            double price;
            int offerID;
            boolean loop = true;
            System.out.println("You are logged in as driver " + driver.getUserName());
            while(loop){
                System.out.println("\nPlease select one of the following choices:");
                System.out.println("1.Add a favorite area");
                System.out.println("2.Remove a favorite area");
                System.out.println("3.Create an offer");
                System.out.println("4.List all requests");
                System.out.println("5.End the ride");
                System.out.println("6.Clear notifications");
                System.out.println("7.Exit");
                choice = input.nextInt();
                input.nextLine();
                switch(choice){
                    case 1:
                        System.out.println("Please enter the area");
                        area = input.nextLine();
                        controller.addFavArea(area);
                        break;
                    case 2:
                        System.out.println("Please enter the area");
                        area = input.nextLine();
                        controller.removeFavArea(area);
                        break;
                    case 3:
                        System.out.println("Please enter Customer name, source, destination and price");
                        customerName = input.nextLine();
                        source = input.nextLine();
                        destination = input.nextLine();
                        price = input.nextDouble();
                        controller.createOffer(customerName, source, destination, price);
                        break;
                    case 4:
                        System.out.println(controller.listRequests());
                        break;
                    case 5:
                        controller.endRide();
                        break;
                    case 6:
                        controller.clearNotifications();
                        System.out.println("Notifications cleared");
                        break;
                    case 7:
                        loop = false;
                        break;
                    default:
                        System.out.println("Wrong Input");
                }
            }
        }
    }
    public void print(String message){
        System.out.println(message);
    }
}