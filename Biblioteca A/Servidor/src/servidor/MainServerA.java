package servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import common.Libro;
import common.Utils;
import common.IServidorA;
import java.util.ArrayList;
import java.util.List;

public class MainServer {
    
    public static int port = 8000;
    String path = "Pedir";

    public static void main(String[] args) throws RemoteException, Exception {
        Utils.setCodeBase(IServidorA.class);
        String path = "Pedir";
        
        ServidorA server = new ServidorA();
        
        List<Libro> books = new ArrayList<>();
        books.add(new Libro("mil años de soledad","Marquez"));
        books.add(new Libro("lord of the rings","Tolkien"));
        server.Populate(books);
        
        IServidorA remote = (IServidorA)UnicastRemoteObject.exportObject(server, 9000);
        //Registry registry = LocateRegistry.getRegistry();
        Registry registry = LocateRegistry.createRegistry(port);
        registry.rebind(path, remote);
        
        System.out.println("Servidor listo presione enter para terminar");
        System.in.read();

        registry.unbind("Pedir");
        UnicastRemoteObject.unexportObject(server, true);
    }
}
