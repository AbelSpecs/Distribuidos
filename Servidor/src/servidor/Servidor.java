package servidor;

import common.IServidor;
import common.Libro;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Omar David
 */
public class Servidor implements IServidor{

    @Override
    public List<Libro> getTitle(String titulo) throws RemoteException {
        return null;
        
    }

    @Override
    public List<Libro> getAuthor(String autor) throws RemoteException {
        return null;
        
    }

    @Override
    public Libro getLibro() throws RemoteException {
        System.out.println("Traer libro");
        return null;
    }

    
    
}
