public abstract class User{
    protected String userName;
    protected String email;
    protected String password;
    protected String mobileNo;
    protected boolean isRegistered = false;

    User(){
        userName = "";
        email = "";
        password = "";
        mobileNo = "";
        isRegistered = false;
    }
    public void setRegisterStatus(boolean status){
        isRegistered = status;
    }
    public abstract void register();
    public abstract boolean login();
}