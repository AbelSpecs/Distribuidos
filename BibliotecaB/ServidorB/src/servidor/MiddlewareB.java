package servidor;

import common.IMiddlewareZ39;
import common.Libro;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class MiddlewareB implements IMiddlewareZ39 {
    
    private static int portZ39 = 8001;
    private static String pathZ39 = "Get";
    private ServidorB server;
    
    public MiddlewareB(ServidorB serverA){
        this.server = serverA;  
    }

    @Override
    public List<Libro> getTitle(String titulo) throws RemoteException {
        System.out.print("Middleware --> "); 
        return server.buscarLibro(titulo);
    }

    @Override
    public List<Libro> getAuthor(String autor) throws RemoteException {
        System.out.print("Middleware --> "); 
        return server.buscarAutor(autor);
    }

    @Override
    public List<Libro> getLibros() throws RemoteException {
        System.out.print("Middleware --> "); 
        return server.getLibros();
    }
    
    public int getPort(){
        return portZ39;
    }
    
    public String getPath(){
        return pathZ39;
    }
    
}
