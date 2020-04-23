package subasta.tp3;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Subasta extends Remote {

    public SubastaModelo recvModel() throws RemoteException;

    public void sendModel(SubastaModelo m) throws RemoteException;

}