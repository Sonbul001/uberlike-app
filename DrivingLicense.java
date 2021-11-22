public class DrivingLicense {
    private String name;
    private String dateOfBirth;
    private String expirationDate;

    DrivingLicense(String name, String dateOfBirth, String expirationDate){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.expirationDate = expirationDate;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setDOB(String DOB){
        dateOfBirth = DOB;
    }
    public String getDOB(){
        return dateOfBirth;
    }
    public void setExpDate(String date){
        expirationDate = date;
    }
    public String getExpDate(){
        return expirationDate;
    }
}
