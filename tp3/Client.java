package subasta.tp3;

import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import subasta.tp3.Client_Interface;
import subasta.tp3.SubastaControlador;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Client implements Client_Interface {

    private String name;
    static SubastaModelo model;
    static SubastaVista view;
    static SubastaControlador controller;

    public static Client_Interface client_stub;

    public Client(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

        String host = null;
        // (args.length < 1) ? null : args[0];

        view = new SubastaVista();

        try {

            Client client = new Client(args[0]);
            client_stub = (Client_Interface) UnicastRemoteObject.exportObject(client, 0);

            Registry registry = LocateRegistry.getRegistry(host);
            Subasta stub = (Subasta) registry.lookup("Subasta");

            stub.suscribe(client_stub);

            model = stub.recvModel();
            System.out.println(model.usuarios);

            controller = new SubastaControlador(view, model);
            // para hacer out-of-process invocations
            controller.setStub(stub);

            view.asignarActionListener(controller);
            view.asignarListSelectionListener(controller);
            // stub.sendModel(model);

        } catch (Exception e) {

            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();

        }
    }

    @Override
    public boolean updateSubscription(String update) {
        System.out.println(update);
        return true;
    }

    @Override
    public boolean updateModels(SubastaModelo model) throws RemoteException {
        // System.out.println(Client.model.usuarios);
        Client.model = model;
        System.out.println("Updated data: ");
        System.out.println("USERS:    " + Client.model.usuarios);
        System.out.println("PRODUCTS: " + Client.model.productos);
        System.out.println("OFFERS:   " + Client.model.ofertas);
        return true;
    }

}