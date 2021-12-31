import java.util.Scanner;

public class AdminView {
    private AdminController controller;
    private Admin admin;
    
    public AdminView(Admin admin, AdminController controller){
        this.admin = admin;
        this.controller = controller;
    }
    public void menuStart(){
        boolean checked = false;
        boolean exit = true;
        String userName;
        String pwd;
        Scanner input = new Scanner(System.in);
        int choice;
        System.out.println("This is the admin menu");
        while(!checked){
            System.out.println("\nPlease select one of the following choices:");
            System.out.println("1.Register");
            System.out.println("2.Login");
            System.out.println("3.Exit");
            choice = input.nextInt();
            input.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Please enter the username and password");
                    userName = input.nextLine();
                    pwd = input.nextLine();
                    Admin admin1 = new Admin(userName,pwd);
                    admin = admin1;
                    controller.register(admin);
                    controller.setAdmin(admin);
                    checked = true;
                    break;
                case 2:
                    System.out.println("Please enter the username and password");
                    userName = input.nextLine();
                    pwd = input.nextLine();
                    Admin admin2 = new Admin(userName,pwd);
                    checked = controller.login(admin2);
                    if(checked){
                        admin = admin2;
                        controller.setAdmin(admin);
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
        if(exit){
            String driverName;
            boolean loop = true;
            System.out.println("You are logged in as admin " + admin.getUserName());
            while(loop){
                System.out.println("\nPlease select one of the following choices:");
                System.out.println("1.List Pending Drivers");
                System.out.println("2.Approve Driver");
                System.out.println("3.Deny Driver");
                System.out.println("4.Exit");
                choice = input.nextInt();
                input.nextLine();
                switch(choice){
                    case 1:
                        controller.listPendingDrivers();
                        break;
                    case 2:
                        System.out.println("Please enter the driver's username");
                        driverName = input.nextLine();
                        controller.approveDriver(driverName);
                        break;
                    case 3:
                        System.out.println("Please enter the driver's username");
                        driverName = input.nextLine();
                        controller.denyDriver(driverName);
                        break;
                    case 4:
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
