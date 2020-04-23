package tp3;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Client {

    private Client() {

    }

    public static void main(String[] args) {

        String host = (args.length < 1) ? null : args[0];

        SubastaVista view;
        SubastaControlador controller;
        SubastaModelo model;

        view = new SubastaVista();

        try {

            Registry registry = LocateRegistry.getRegistry(host);

            Subasta stub = (Subasta) registry.lookup("Subasta");

            model = stub.recvModel();

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

}