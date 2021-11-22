import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class main {
    public static void main(String[] args){
        Admin admin = new Admin();
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Driver> drivers = new ArrayList<>();
        Customer c;
        Driver d;
        Scanner input = new Scanner(System.in);
        String choice;
        while(true){
            System.out.println("Please choose a User Type");
            System.out.println("1.Customer");
            System.out.println("2.Driver");
            choice = input.nextLine();
            System.out.println("\n");
            // Customer Choice
            if(choice.equalsIgnoreCase("1")){
                System.out.println("Please Choose one of the following");
                System.out.println("1.register");
                System.out.println("2.login");
                choice = input.nextLine();
                System.out.println("\n");
                if(choice.equalsIgnoreCase("1")){
                    System.out.print("Username: ");
                    String name = input.nextLine();
                    System.out.print("Password: ");
                    String pwd = input.nextLine();
                    System.out.print("Email (optional, just press enter if you don't want to add an email): ");
                    String email = input.nextLine();
                    System.out.print("Mobile Number: ");
                    String phone = input.nextLine();
                    System.out.println("\n");
                    c = new Customer(name, email, pwd, phone);
                    c.register();
                    System.out.println("You have registered successfully\n");
                    
                }else if(choice.equalsIgnoreCase("2")){
                    System.out.print("Username: ");
                    String name = input.nextLine();
                    System.out.print("Password: ");
                    String pwd = input.nextLine();
                    System.out.println("\n");
                    c = new Customer(name, pwd);
                    if(c.login()){
                        for (Customer customer : customers) {
                            if(customer.userName.equals(name))
                                c = customer;
                        }
                    }else{
                        continue;
                    }
                }else{
                    System.out.println("Wrong Choice ... Exiting the program");
                    break;
                }
                boolean bool = true;
                while(bool){
                System.out.println("Please enter a choice:");
                System.out.println("1.Request Ride");
                System.out.println("2.List Offers");
                System.out.println("3.Exit");
                String choice2 = input.nextLine();
                System.out.println("\n");
                    switch(choice2){
                        case "1":
                            System.out.print("Enter A Source: ");
                            String src = input.nextLine();
                            System.out.print("Enter A Destination: ");
                            String dst = input.nextLine();
                            System.out.println("\n");
                            c.request(src, dst);
                            break;
                        case "2":
                            c.listOffers();
                            break;
                        case "3":
                            bool = false;
                            break;
                        default:
                            System.out.println("Wrong Choice");
                    }
                }
                customers.add(c);
            // Driver Choice
            }else if(choice.equalsIgnoreCase("2")){
                System.out.println("Please Choose one of the following");
                System.out.println("1.register");
                System.out.println("2.login");
                choice = input.nextLine();
                System.out.println("\n");
                if(choice.equalsIgnoreCase("1")){
                    System.out.print("Username: ");
                    String name = input.nextLine();
                    System.out.print("Password: ");
                    String pwd = input.nextLine();
                    System.out.print("Email (optional, just press enter if you don't want to add an email): ");
                    String email = input.nextLine();
                    System.out.print("Mobile Number: ");
                    String phone = input.nextLine();
                    System.out.print("Date Of Birth: ");
                    String dateOfBirth = input.nextLine();
                    System.out.print("Driving License Expiration Date: ");
                    String dlExpirationDate = input.nextLine();
                    System.out.print("Address on national ID: ");
                    String address = input.nextLine();
                    System.out.print("National ID number: ");
                    String idNo = input.nextLine();
                    System.out.print("National ID Expiration Date: ");
                    String niExpirationDate = input.nextLine();
                    System.out.println("\n");
                    System.out.println("Please wait until an admin reviews your registeration");
                    System.out.println("\n");
                    DrivingLicense driv = new DrivingLicense(name, dateOfBirth, dlExpirationDate);
                    NationalID nid = new NationalID(name, dateOfBirth, address, idNo, niExpirationDate);
                    d = new Driver(name, email, pwd, phone, driv, nid, admin);
                    d.register();
                    try{
                        TimeUnit.SECONDS.sleep(1);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    admin.approveDriver(d);
                    System.out.println("You have registered successfully");
                    
                }else if(choice.equalsIgnoreCase("2")){
                    System.out.print("Username: ");
                    String name = input.nextLine();
                    System.out.print("Password: ");
                    String pwd = input.nextLine();
                    System.out.println("\n");
                    d = new Driver(name,pwd);
                    if(!d.login()){
                        break;
                    }
                    for (Driver driver : drivers) {
                        if(driver.userName.equals(name))
                            d = driver;
                    }
                }else{
                    System.out.println("Wrong Choice ... Exiting the program");
                    break;
                }
                boolean bool = true;
                while(bool){
                    System.out.println("Please enter a choice");
                    System.out.println("1.Add Favorite Area");
                    System.out.println("2.Remove Favorite Area");
                    System.out.println("3.List Requests");
                    System.out.println("4.Create Offer");
                    System.out.println("5.Exit");
                    String choice2 = input.nextLine();
                    System.out.println("\n");
                    switch(choice2){
                        case "1":
                            System.out.print("Enter The Area: ");
                            d.addFavArea(input.nextLine());
                            break;
                        case "2":
                            System.out.print("Enter The Area: ");
                            d.removeFavArea(input.nextLine());
                            break;
                        case "3":
                            d.listRequests();
                            break;
                        case "4":
                            System.out.print("Enter the customer's name: ");
                            String name = input.nextLine();
                            Customer chosen = new Customer();
                            boolean found = false;
                            for (Customer customer : customers) {
                                if(customer.userName.equals(name)){
                                    chosen = customer;
                                    found = true;
                                }
                            }
                            if(!found){
                                System.out.println("Customer not found");
                                break;
                            }
                            System.out.print("Enter Source : ");
                            String src = input.nextLine();
                            System.out.print("Enter Destination: ");
                            String dst = input.nextLine();
                            System.out.print("Enter Price: ");
                            float price = input.nextFloat();
                            input.nextLine();
                            System.out.println("\n");
                            d.createOffer(chosen, src, dst, price);
                            break;
                        case "5":
                            bool = false;
                            break;
                        default:
                            System.out.println("Wrong Choice");
                    }
                }
                drivers.add(d);
            }else{
                System.out.println("Wrong Choice ... Exiting the program");
                break;
            }
        }
        input.close();
    }
}
