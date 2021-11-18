public abstract class User{
    private String userName;
    private String email;
    private String password;
    private int mobileNo;
    private Registeration registeration;
    private boolean isRegistered;

    User(){
        userName = "";
        email = "";
        password = "";
        mobileNo = 0;
        registeration = null;
        isRegistered = false;
    }
    public abstract void register();
    public void setRegisterStatus(boolean status){
        isRegistered = status;
    }
    public boolean login(String id, String pwd){
        userName = id;
        password = pwd;
    }
}