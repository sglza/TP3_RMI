
package subasta.tp3;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

public interface Client_Interface extends Remote {
    boolean updateSubscription(String update) throws RemoteException;

    boolean updateModels(SubastaModelo model) throws RemoteException;

    // boolean updateProductLists(Vector list) throws RemoteException;
}
