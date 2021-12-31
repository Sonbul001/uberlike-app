
import java.util.Scanner;

public class Interface {
    public static void main(String[] args){
        boolean loop = true;
        while(loop){
            System.out.println("Please choose a user: ");
            System.out.println("1.Customer");
            System.out.println("2.Driver");
            System.out.println("3.Admin");
            System.out.println("4.Exit");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch(choice){
                case 1:
                    Customer customer = new Customer();
                    CustomerModel customerModel = new CustomerModel();
                    CustomerController customerController = new CustomerController(customer,customerModel);
                    CustomerView customerView = new CustomerView(customerController,customer);
                    customerController.setView(customerView);
                    customerView.menuStart();
                    break;
                case 2:
                    Driver driver = new Driver();
                    DriverModel driverModel = new DriverModel();
                    DriverController driverController = new DriverController(driver, driverModel);
                    DriverView driverView = new DriverView(driver,driverController);
                    driverController.setView(driverView);
                    driverView.menuStart();
                    break;
                case 3:
                    Admin admin = new Admin();
                    AdminModel adminModel = new AdminModel();
                    AdminController adminController = new AdminController(admin, adminModel);
                    AdminView adminView = new AdminView(admin,adminController);
                    adminController.setView(adminView);
                    adminView.menuStart();
                    break;
                case 4:
                    loop = false;
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }
    }
}
