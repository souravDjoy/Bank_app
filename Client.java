public class Client {

    //declaring the variables
    private final String fName;//name cannot be changed
    private final String lName;
    private String sin;
    private String phone;
    private final Account acct;//acct type cannot be changed once created

    Client(String fName, String lName, String sin, String phone, Account acct){//setting up the values
        this.fName=fName;
        this.lName=lName;
        this.sin=sin;
        this.phone=phone;
        this.acct=acct;
    }


    public String toString(){ //displays client information and acct information together
        return "Your information:\n"+
                "First name:"+this.fName+
                ", Last name:"+this.lName+
                ", Phone no:"+this.phone+
                ", Sin:"+this.sin+
                acct;

    }

    public String acctInfo(){ //displays client information and acct information together
        return  "First name: "+this.fName+
                ", Last name:"+this.lName+
                ", Phone no:"+this.phone+
                ", Sin: "+this.sin+
                ", Acct number: "+acct.getAcctNo();
    }


    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getSin() {
        return sin;
    }

    public void setSin(String sin) {
        this.sin = sin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Account getAcct() {
        return acct;
    }
}
