
import java.util.Scanner;

public class CustomerView {
    private CustomerController controller;
    private Customer customer;
    
    public CustomerView(CustomerController controller, Customer customer){
        this.customer = customer;
        this.controller = controller;
    }
    public void menuStart(){
        boolean checked = false;
        boolean exit = false;
        String userName;
        String pwd;
        String email;
        String mobileNo;
        Scanner input = new Scanner(System.in);
        int choice;
        System.out.println("This is the customer menu");
        while(!checked){
            System.out.println("\nPlease select one of the following choices:");
            System.out.println("1.Register");
            System.out.println("2.Login");
            System.out.println("3.Exit");
            choice = input.nextInt();
            input.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Please enter the username, password, email and mobile number");
                    userName = input.nextLine();
                    pwd = input.nextLine();
                    email = input.nextLine();
                    mobileNo = input.nextLine();
                    Customer customer1 = new Customer(userName, email, pwd, mobileNo);
                    customer = customer1;
                    controller.register(customer1);
                    controller.setCustomer(customer);
                    checked = true;
                    break;
                case 2:
                    System.out.println("Please enter the username and password");
                    userName = input.nextLine();
                    pwd = input.nextLine();
                    Customer customer2 = new Customer(userName, pwd);
                    customer = controller.login(customer2);
                    if(customer != null){
                        controller.setCustomer(customer);
                        checked = true;
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
        if(!exit && customer.registerationStatus()){
            int offerID;
            int rating;
            String source;
            String destination;
            boolean loop = true;
            System.out.println("You are logged in as customer " + customer.getUserName());
            while(loop){
                System.out.println("\nPlease select one of the following choices:");
                System.out.println("1.Request a ride");
                System.out.println("2.List all offers");
                System.out.println("3.Select an offer");
                System.out.println("4.Rate the completed ride");
                System.out.println("5.Clear Notifications");
                System.out.println("5.Exit");
                choice = input.nextInt();
                input.nextLine();
                switch(choice){
                    case 1:
                        System.out.println("Please enter the source and destination of the ride");
                        source = input.nextLine();
                        destination = input.nextLine();
                        controller.request(source, destination);
                        break;
                    case 2:
                        System.out.println(controller.listOffers());
                        break;
                    case 3:
                        System.out.println("Please enter the Offer ID");
                        offerID = input.nextInt();
                        controller.selectOffer(offerID);
                        break;
                    case 4:
                        System.out.println("Please enter the rating");
                        rating = input.nextInt();
                        controller.rateCompletedRide(rating);
                        break;
                    case 5:
                        controller.clearNotifications();
                        System.out.println("Notifications cleared");
                        break;
                    case 6:
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
