package servidor;

import common.IMiddlewareZ39;
import common.Libro;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class MiddlewareA implements IMiddlewareZ39 {
    
    private static int portZ39 = 8001;
    private static String pathZ39 = "Get";
    private ServidorA server;
    
    public MiddlewareA(ServidorA serverA){
        this.server = serverA;  
    }

    @Override
    public List<Libro> getTitle(String titulo) throws RemoteException {
        return server.pedirLibro(titulo);
    }

    @Override
    public List<Libro> getAuthor(String autor) throws RemoteException {
        return server.pedirAutor(autor);
    }

    @Override
    public List<Libro> getLibros() throws RemoteException {
        return server.getLibros();
    }
    
    public int getPort(){
        return portZ39;
    }
    
    public String getPath(){
        return pathZ39;
    }
    
}
