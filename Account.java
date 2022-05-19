public class Account {

    //instance variables
    private double balance;
    private double interest;
    private double fee;
    private int acctNo;
    //static variable belonging to this class not instances
    private static int numberOfAcct=20000000;

    Account(){
        acctNo=numberOfAcct++;
    }


    //get and set methods for the variables
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public int getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(int acctNo) {
        this.acctNo = acctNo;
    }

    public void deposit(double money){//keeps track of the deposited money and total balance of the acct
        if(money<=0){
            System.out.println("You have not deposited anything yet.");
            return;//breaks out of the function
        }


        balance+= money;
        System.out.println("You have deposited "+money+".");
        interest();//to check the interest on current balance.
    }

    public void withdraw(double money){//keeps track of withdrawn money and total balance of the acct
        if(money>balance){
            System.out.println("You do not have sufficient balance.");
            return;//breaks out of the function
        }

        balance-= money;
        System.out.println("You have withdrawn "+money+".");
        interest();//to check the interest on current balance

    }

    public void interest(){
        if(balance>6000)//if the balance is adequate to get interest
        {
            interest=5;
            System.out.println("You will keep getting interest at the rate of "+interest+"%.");
        }
        else{
            interest=0;
            System.out.println("You will have no interest on this account.");}


    }

    public String toString(){ //displays account information
        return  "\nAcct No:"+this.getAcctNo()+
                "\nAcct Balance:"+this.getBalance()+
                "\nAcct Interest:"+this.getInterest()+"%"+
                "\nAcct Fee:"+this.getFee();

    }
}
