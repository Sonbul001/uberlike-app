import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DriverRegisteration implements Registeration{
    private Admin admin;
    
    public void addAdmin(Admin a){
        admin = a;
    }
	public void register(User u){
        admin.setPendingDriver((Driver)u);
    }
    public boolean login(User u){
        boolean flag = false;
        File f = new File("DriverAccounts.txt");
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
