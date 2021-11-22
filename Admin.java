import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin{
    private ArrayList<Driver> pendingDrivers = new ArrayList<Driver>();

    public void setPendingDriver(Driver d){
        pendingDrivers.add(d);
    }
    public void listPendingDrivers(){
        for (Driver driver : pendingDrivers) {
            System.out.println("Driver UserName: " + driver.userName);
            System.out.println("Driver Password: " + driver.password);
            System.out.println("Driver Email " + driver.email);
            System.out.println("Driver Phone Number: " + driver.mobileNo);
            System.out.println("Driver National Id: " + driver.getNationalID().getID());
            System.out.println("Driver's License expiration date: " + driver.getDrivingLicense().getExpDate() + "\n");
        }
    }
    public void approveDriver(Driver d){
        d.isRegistered = true;
        boolean flag = false;
        File f = new File("DriverAccounts.txt");
        File info = new File("DriverInfo.txt");
        try{
            f.createNewFile();
            info.createNewFile();
        }catch(IOException e){
            e.printStackTrace();
        }
        try{
            Scanner content = new Scanner(f);
            while (content.hasNextLine()) {
                String data = content.nextLine();
                if(data.equalsIgnoreCase(d.userName))
                {
                    System.out.println("UserName already exists");
                    flag = true;
                    break;
                }
            }
            if(!flag){
                FileWriter writer = new FileWriter(f,true);
                writer.write(d.userName + "\n");
                writer.write(d.password + "\n");
                writer.close();
                FileWriter writer2 = new FileWriter(info,true);
                writer2.write("Driver UserName: " + d.userName + "\n");
                writer2.write("Driver Email: " + d.email + "\n");
                writer2.write("Driver Phone Number: " + d.mobileNo + "\n");
                writer2.write("Driver National ID number: " + d.getNationalID().getID() + "\n");
                writer2.write("Driver's License expiration date: " + d.getDrivingLicense().getExpDate() + "\n\n");
                writer2.close();
            }
            content.close();
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }

    }  
    public void denyDriver(Driver d){
        d.notifyFromAdmin("Registeration was denied by admin");
    }
}
