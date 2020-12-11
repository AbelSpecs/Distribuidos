package servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import common.Libro;
import common.Utils;
import common.IServidorA;

public class MainServer {
    
    public static String url = "rmi://127.0.0.1";
    public static int port = 8000;

    public static void main(String[] args) throws RemoteException, Exception {
        Utils.setCodeBase(IServidorA.class);
        String path = "Pedir";
        
        ServidorA server = new ServidorA();
        
        server.catalog.add(new Libro("mil años de soledad","Marquez"));
        server.catalog.add(new Libro("lord of the rings","king")); 
        
        IServidorA remote = (IServidorA)UnicastRemoteObject.exportObject(server, 9000);
        //Registry registry = LocateRegistry.getRegistry();
        Registry registry = LocateRegistry.createRegistry(port);
        registry.rebind(path, remote);
        
        System.out.println("Servidor listo presione enter para terminar");
        System.in.read();

        registry.unbind("BibliotecaA");
        UnicastRemoteObject.unexportObject(server, true);
    }
}
