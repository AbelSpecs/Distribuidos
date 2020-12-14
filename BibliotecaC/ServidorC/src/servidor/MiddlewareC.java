package servidor;

import common.IMiddlewareZ39;
import common.Libro;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class MiddlewareC implements IMiddlewareZ39 {
    
    private static int portZ39 = 8001;
    private static String pathZ39 = "Get";
    private ServidorC server;
    
    public MiddlewareC(ServidorC serverA){
        this.server = serverA;  
    }

    @Override
    public List<Libro> getTitle(String titulo) throws RemoteException {
        System.out.print("Middleware --> "); 
        return server.encontrarLibro(titulo);
    }

    @Override
    public List<Libro> getAuthor(String autor) throws RemoteException {
        System.out.print("Middleware --> "); 
        return server.encontrarAutor(autor);
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
