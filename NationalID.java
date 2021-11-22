public class NationalID {
    private String name;
    private String dateOfBirth;
    private String address;
    private String idNo;
    private String expirationDate;

    NationalID(String name, String dateOfBirth, String address, String idNo, String expirationDate){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.idNo = idNo;
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
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return address;
    }
    public void setID(String id){
        idNo = id;
    }
    public String getID(){
        return idNo;
    }
    public void setExpDate(String date){
        expirationDate = date;
    }
    public String getExpDate(){
        return expirationDate;
    }
}
