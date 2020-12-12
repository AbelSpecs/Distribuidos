package servidor;

import common.IMiddlewareZ39;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import common.Libro;
import common.Utils;
import java.util.ArrayList;
import java.util.List;
import common.IServidorB;

public class MainServerB {
    
    public static int port = 8000;
    public static String path = "Buscar";

    public static void main(String[] args) throws RemoteException, Exception {
        Utils.setCodeBase(IServidorB.class);
        ServidorB server = new ServidorB();
        MiddlewareB translator = new MiddlewareB(server);        
       
        
        IServidorB remote = (IServidorB)UnicastRemoteObject.exportObject(server, 9000);
        Registry registry = LocateRegistry.createRegistry(port);
        registry.rebind(path, remote);
        
        IMiddlewareZ39 remote2 = (IMiddlewareZ39)UnicastRemoteObject.exportObject(translator, 9001);
        Registry registryZ39 = LocateRegistry.createRegistry(translator.getPort());
        registryZ39.rebind(translator.getPath(), remote2);
        
        System.out.println("Servidor encendido... presione enter para apagarlo");
        System.in.read();
        
        registry.unbind(path);
        UnicastRemoteObject.unexportObject(server, true);
        registryZ39.unbind(translator.getPath());
        UnicastRemoteObject.unexportObject(translator, true);
    }
}
