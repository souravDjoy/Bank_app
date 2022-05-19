import java.util.ArrayList;
import java.util.Scanner;

public class WelcomeMenu {

    //declaring the variables we need
    Scanner Kb= new Scanner(System.in);
    Bank bank= new Bank();
    boolean exit= false;


    //our methods are main, runApp, performFunction, getInput, printMenu, printWelcome, selectAccount
    public static void main(String[] args){
        WelcomeMenu menu= new WelcomeMenu();
        menu.runApp();
    }

    public void runApp(){
        printWelcome(); //print the welcoming line as the header
        
        while(!exit){//while the condition is true
            printMenu(); //list the functions the client can perform
            int choice= getInput();
            performFunction(choice);
        }
    }

    private void performFunction(int choice) {
        switch(choice) {
            case 0:
                ; //exit
                System.out.println("Bye. Thanks for using our application.");
                System.exit(0);
                break;

            case 1://opening account
                makeAccount();
                break;


            case 2://deposit money
                makeDeposit();
                break;

            case 3://withdraw money
                makeWithdraw();
                break;

            case 4://see the balance of the account
                showBalance();
                break;

            default:
                System.out.println("Error");
        }
    }

    private void makeAccount() {
        String fName, lName, phone, sin, accountType;
        double iniDeposit=0;
        System.out.println("Please write the account type you want to create. Checking/Savings/Credit:");
        System.out.println("If you want to create more than one type of account. Create each separately.");
        accountType= Kb.nextLine();

        //validating if the user put the right account type
        boolean valid= false;
        while(!valid){
            if(accountType.equalsIgnoreCase("checking")||accountType.equalsIgnoreCase("savings")||accountType.equalsIgnoreCase("credit"))
            {valid=true;}
            else
            {System.out.println("Write the right type of account. Check spelling that matches ours.");
            break;
            }
        }

        //taking information from the user to create acct
        System.out.println("Please write your first name:");
        fName= Kb.nextLine();

        System.out.println("Please write your last name:");
        lName= Kb.nextLine();

        System.out.println("Please write your phone number::");
        phone= Kb.nextLine();

        System.out.println("Please write your sin number:");
        sin= Kb.nextLine();

        System.out.println("Please insert an initial deposit.");
        iniDeposit= Double.parseDouble(Kb.nextLine());

        //creating an account object and its specific type
        Account acct= new Account();
        if(accountType.equalsIgnoreCase("checking")){Checking check=new Checking(iniDeposit);}
        else if(accountType.equalsIgnoreCase("savings")){Savings check=new Savings(iniDeposit);}
        else if(accountType.equalsIgnoreCase("credit")){Credit check=new Credit(iniDeposit);}


        Client client=new Client(fName, lName, phone, sin, acct);//creating a client with all the received info

        bank.addClient(client);//adding client to the bank

    }

    private void makeDeposit() {

        int acct= selectAccount();
        if (acct>=0){
        System.out.println("Deposit amount?");
        double amount=0;
        try{
            amount=Double.parseDouble(Kb.nextLine());
        }
        catch(NumberFormatException e){
            amount=0;
        }
        bank.getClient(acct).getAcct().deposit(amount);}

    }

    private void makeWithdraw() {
        int acct= selectAccount();
        if (acct>=0){
            System.out.println("Withdraw amount?");
            double amount=0;
            try{
                amount=Double.parseDouble(Kb.nextLine());
            }
            catch(NumberFormatException e){
                amount=0;
            }
            bank.getClient(acct).getAcct().withdraw(amount);}
    }

    private void showBalance() {

        int acct= selectAccount();
        if (acct >= 0) {
            System.out.println(bank.getClient(acct).getAcct().toString());
        }
        else
        {System.out.println("Account does not exist");}
    }

    private int getInput() {
    int choice=-1;
    do {
    System.out.println("Select one of these numbers:");
    try {//collects the choice as integer from the user
        choice = Integer.parseInt(Kb.nextLine());//taking input from the user that resembles the list of functions
    }

    catch (NumberFormatException e) { //if the user chooses something instead of our numbers
    }

    if (choice < 0 || choice > 4) { //if the user chooses a number outside our range
        System.out.println("Please select a number from our list.");
    }
    }while(choice<0 || choice>4);//this loop will work if the selected no is within our declared range
    return choice;
    }


    private void printMenu() { //show the functions the client can perform in list form
        System.out.println("Create account-->1");
        System.out.println("Deposit money-->2");
        System.out.println("Withdraw money-->3");
        System.out.println("Account balance-->4");
        System.out.println("Exit-->0");
    }

    private void printWelcome() { //displays the welcoming line
        System.out.println("Welcome to your bank!");
        System.out.println("We are thrilled to have you visiting our site!");
        System.out.println("CBM bank");
    }

    private int selectAccount() {
        ArrayList<Client> clients=bank.getClients();

        if(clients.size()<=0){
            System.out.println("No customer in bank.");
            return -1;
        }
        System.out.println("Select an account:");
        for (int i=0; i<clients.size(); i++){
            System.out.println((i+1)+")"+ clients.get(i).acctInfo());
        }
        int acct=0;
        System.out.print("Please make your selection:");
        try{
            acct=Integer.parseInt(Kb.nextLine())-1;
        }
        catch(NumberFormatException e){acct=-1;}
        if(acct<0 || acct>clients.size())
        {
            System.out.println("Invalid no selected.");
            acct=-1;
        }
        return acct;
    }

}
