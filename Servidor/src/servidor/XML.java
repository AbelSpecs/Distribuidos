package servidor;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Omar David
 */
public class XML {
    
    public XML(){
        
    }
    
    public static void main(String[] args) {
        XML archivo = new XML();
        archivo.leerArchivo();
        archivo.buscarLibro("Libro 5");
    }
    
    public void leerArchivo(){
        
        try {
            // Creo una instancia de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Creo un documentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
 
            // Obtengo el documento, a partir del XML
            Document documento = builder.parse(new File("C:\\Users\\Omar David\\Mi Carpeta\\Ucab\\9no Semestre\\Sistemas Distribuidos\\Distribuidos\\Servidor\\src\\servidor\\pruebaXML.xml"));
 
            // Cojo todas las etiquetas coche del documento
            NodeList listaLibros = documento.getElementsByTagName("libro");
 
            // Recorro las etiquetas
            for (int i = 0; i < listaLibros.getLength(); i++) {
                // Cojo el nodo actual
                Node nodo = listaLibros.item(i);
                // Compruebo si el nodo es un elemento
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    // Lo transformo a Element
                    Element e = (Element) nodo;
                    // Obtengo sus hijos
                    NodeList hijos = e.getChildNodes();
                    // Recorro sus hijos
                    for (int j = 0; j < hijos.getLength(); j++) {
                        // Obtengo al hijo actual
                        Node hijo = hijos.item(j);
                        // Compruebo si es un nodo
                        if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                            // Muestro el contenido
                            System.out.println("Propiedad: " + hijo.getNodeName()
                                    + ", Valor: " + hijo.getTextContent());
                        }
 
                    }
                    System.out.println("");
                }
 
            }
 
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex.getMessage());
        }      // Obtengo el documento, a partir del XML
      
    }
    
    public void buscarLibro(String param) {
        try {
            // Creo una instancia de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Creo un documentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
 
            // Obtengo el documento, a partir del XML
            Document documento = builder.parse(new File("C:\\Users\\Omar David\\Mi Carpeta\\Ucab\\9no Semestre\\Sistemas Distribuidos\\Distribuidos\\Servidor\\src\\servidor\\pruebaXML.xml"));
 
            // Cojo todas las etiquetas coche del documento
            NodeList listaLibros = documento.getElementsByTagName("libro");
 
            // Recorro las etiquetas
            for (int i = 0; i < listaLibros.getLength(); i++) {
                // Cojo el nodo actual
                Node nodo = listaLibros.item(i);
                // Compruebo si el nodo es un elemento
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    // Lo transformo a Element
                    Element e = (Element) nodo;
                    // Obtengo sus hijos
                    NodeList hijos = e.getChildNodes();
                    // Recorro sus hijos
                    for (int j = 0; j < hijos.getLength(); j++) {
                        // Obtengo al hijo actual
                        Node hijo = hijos.item(j);
                        // Compruebo si es un nodo
                        if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                            if(hijo.getTextContent().equals(param)){
                                  // Muestro el contenido
                                System.out.println("Propiedad: " + hijo.getNodeName()
                                        + ", Valor: " + hijo.getTextContent());
                                return;
                            }
                        }
                    }
                }
            }
 
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex.getMessage());
        }      // Obtengo el documento, a partir del XML
    }
}
