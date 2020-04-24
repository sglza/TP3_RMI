
package subasta.tp3;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Hashtable;
import java.util.Vector;

public interface Client_Interface extends Remote {
    void updateSubscription(String update) throws RemoteException;

    void updateModel(SubastaModelo model) throws RemoteException;

    void updatePriceList(Hashtable priceList) throws RemoteException;
}
