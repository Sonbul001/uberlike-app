
import java.util.Scanner;

public class AdminView {
    private AdminController controller;
//    private AdminModel model;
    private Admin admin;
    
    public AdminView(Admin admin, AdminController controller){
        this.admin = admin;
//        this.model = model;
        this.controller = controller;
    }
    public void menuStart(){
        boolean checked = false;
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
                    register(admin1);
                    checked = true;
                    break;
                case 2:
                    System.out.println("Please enter the username and password");
                    userName = input.nextLine();
                    pwd = input.nextLine();
                    Admin admin2 = new Admin(userName,pwd);
                    checked = login(admin2);
                    if(checked){
                        admin = admin2;
                    }
                    break;
                case 6:
                    checked = true;
                    break;
                default:
                    System.out.println("Wrong Input");
            }
        }
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
                    listPendingDrivers();
                    break;
                case 2:
                    System.out.println("Please enter the driver's username");
                    driverName = input.nextLine();
                    approveDriver(driverName);
                    break;
                case 3:
                    System.out.println("Please enter the driver's username");
                    driverName = input.nextLine();
                    approveDriver(driverName);
                    break;
                case 4:
                    loop = false;
                    break;
                default:
                    System.out.println("Wrong Input");
            }
        }
    }
    public void register(Admin admin){
        controller.register(admin);
    }
    public boolean login(Admin admin){
        return controller.login(admin);
    }
    public void listPendingDrivers(){
        controller.listPendingDrivers();
    }
    public void approveDriver(String driverUserName){
        controller.approveDriver(driverUserName);
    }
    public void denyDriver(String driverUserName){
        controller.denyDriver(driverUserName);
    }
    public void print(String message){
        System.out.println(message);
    }
//    public static void main(String[] args){
//        Admin admin = new Admin();
//        AdminModel model = new AdminModel();
//        AdminController control = new AdminController(admin, model);
//        AdminView view = new AdminView(admin, model,control);
//        control.setView(view);
//        view.menuStart();
//    }
}
