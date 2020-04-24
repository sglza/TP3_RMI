package subasta.tp3;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;
import java.util.Hashtable;

public interface Subasta extends Remote {

    void suscribe(Client_Interface c) throws RemoteException;

    public void updateModel() throws RemoteException;

    public void updatePriceList() throws RemoteException;

    public SubastaModelo recvModel() throws RemoteException;

    public SubastaModelo recvUpdatedModel() throws RemoteException;

    public void sendModel(SubastaModelo m) throws RemoteException;

    public void sendPriceList(Hashtable l) throws RemoteException;

}