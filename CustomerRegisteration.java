import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CustomerRegisteration implements Registeration{
	public void register(User u){
        boolean flag = false;
        File f = new File("CustomerAccounts.txt");
        File info = new File("CustomerInfo.txt");
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
                if(data.equalsIgnoreCase(u.userName))
                {
                    System.out.println("UserName already exists");
                    flag = true;
                    break;
                }
            }
            if(!flag){
                FileWriter writer = new FileWriter(f,true);
                writer.write(u.userName + "\n");
                writer.write(u.password + "\n");
                writer.close();
                FileWriter writer2 = new FileWriter(info,true);
                writer2.write("Customer name: "+u.userName + "\n");
                writer2.write("Customer Email: "+u.email + "\n");
                writer2.write("Customer Phone Number: "+u.mobileNo + "\n\n");
                writer2.close();
                u.isRegistered = true;
            }
            content.close();
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }
    }
    public boolean login(User u){
        boolean flag = false;
        File f = new File("CustomerAccounts.txt");
        try{
        Scanner content = new Scanner(f);
        while (content.hasNextLine()) {
            String data = content.nextLine();
            if(data.equalsIgnoreCase(u.userName))
            {
                flag = true;
                data = content.nextLine();
                if(data.equalsIgnoreCase(u.password)){
                    System.out.println("Login Successful");
                    break;
                }else{
                    System.out.println("Incorrect Password");
                    break;
                }
            }
        }
        if(!flag){
            System.out.println("UserName not found");
        }
        content.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return flag;
    }
}