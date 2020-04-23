package tp3;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Subasta {

    SubastaModelo model;

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
        SubastaModelo m = new SubastaModelo();
        return m;
    }

    @Override
    public void sendModel(SubastaModelo m) throws RemoteException {
        model = m;
    }

}