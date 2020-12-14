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
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainServerB {
    
    public static int port = 8000;
    public static String path = "Buscar";
    public static String ip;

    public static void main(String[] args) throws RemoteException, Exception {
        Utils.setCodeBase(IServidorB.class);
        ServidorB server = new ServidorB();
        MiddlewareB translator = new MiddlewareB(server);        
       
        ipServer();
        System.setProperty("java.rmi.server.hostname",ip);
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
    
        public static void ipServer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la ip del host");
        ip = scanner.next();      
        while(!ipValida(ip)){
            System.out.println("Ingrese una ip valida");
            ip = scanner.next();            
        }
    }
      
    public static boolean ipValida(String ip) 
    { 
        String zeroTo255 
            = "(\\d{1,2}|(0|1)\\"
              + "d{2}|2[0-4]\\d|25[0-5])"; 
        String regex 
            = zeroTo255 + "\\."
              + zeroTo255 + "\\."
              + zeroTo255 + "\\."
              + zeroTo255; 
        Pattern p = Pattern.compile(regex); 
        if (ip == null) { 
            return false; 
        } 
        Matcher m = p.matcher(ip); 
        return m.matches(); 
    } 
}
