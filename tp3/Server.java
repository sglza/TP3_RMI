package subasta.tp3;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import subasta.tp3.SubastaModelo;

public class Server implements Subasta {

    SubastaModelo model = new SubastaModelo();
    Hashtable priceList;

    private List<Client_Interface> clients = new LinkedList<>();

    public Server() {
    }

    @Override
    public void suscribe(Client_Interface client) {

        int index = 0;
        clients.add(client);

        try {
            for (Client_Interface c : clients) {
                c.updateSubscription("A new user subscribed for updates");
                index++;
            }
        } catch (Exception e) {
            clients.remove(index);
            System.out.println("Unsubscribed client: #" + index);
        }

    }

    @Override
    public void updateModel() {

        int index = 0;

        try {
            for (Client_Interface c : clients) {
                c.updateModels(model);
                index++;
            }
        } catch (Exception e) {
            clients.remove(index);
            System.out.println("Removed Client: " + index);
        }

    }

    @Override
    public void updatePriceList() {

        int index = 0;

        System.out.println("MODEL PRICE LIST: " + model.priceList);

        try {
            for (Client_Interface c : clients) {
                c.updatePriceLists(model.priceList);
                index++;
            }
        } catch (Exception e) {
            clients.remove(index);
            System.out.println("Removed Client: " + index);
        }

    }

    public static void main(String args[]) {

        try {
            Server obj = new Server();
            Subasta stub = (Subasta) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Subasta", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

    @Override
    public SubastaModelo recvModel() throws RemoteException {
        return model;
    }

    @Override
    public void sendModel(SubastaModelo m) throws RemoteException {
        model = m;
        System.out.println(model.usuarios);
    }

    @Override
    public SubastaModelo recvUpdatedModel() throws RemoteException {
        return model;
    }

    @Override
    public void sendPriceList(Hashtable l) throws RemoteException {
        System.out.println("PRICE LIST SENT: " + l);
        model.priceList = l;
    }

}