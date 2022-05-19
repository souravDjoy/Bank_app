
import java.util.ArrayList;

public class Bank {
    ArrayList<Client> clients = new ArrayList<Client>();//creating an array list to hold all the client

    void addClient(Client client) {//adds a new client in the bank
        clients.add(client);
    }

    Client getClient(int account) {
        return clients.get(account);
    }

    ArrayList<Client> getClients()
    {
        return clients;
    }

}




