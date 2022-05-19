public class Credit extends Account{

    private static String accountType= "Credit";
    private double fee;

    Credit(double dep){
        super();
        this.setBalance(dep);
        if(dep>6000){//if the deposit is more than 6000, there is interest and no fee
            this.setInterest(5);
            this.setFee(0);

        }
        else{//if the deposit is less than 6000, there is no interest and fee
            this.setInterest(0);
            this.setFee(10);

        }
    }

    @Override
    public String toString(){ //displays account information
        return "\nAcct Type:"+this.accountType+
                "\nAcct No:"+this.getAcctNo()+
                "\nAcct Balance:"+this.getBalance()+
                "\nAcct Interest:"+this.getInterest()+"%"+
                "\nAcct Fee:"+this.getFee();

    }
}
