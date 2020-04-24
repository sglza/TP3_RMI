package subasta.tp3;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

public interface Subasta extends Remote {

    boolean suscribe(Client_Interface c) throws RemoteException;

    public boolean updateModel() throws RemoteException;

    // public boolean updateProductList(Vector l) throws RemoteException;

    public SubastaModelo recvModel() throws RemoteException;

    public SubastaModelo recvUpdatedModel() throws RemoteException;

    public void sendModel(SubastaModelo m) throws RemoteException;

}