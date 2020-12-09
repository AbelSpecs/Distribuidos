package servidor;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Omar David
 */
public class CrearXML {
    
    public static void main(String[] args) {
        CrearXML archivo = new CrearXML();
        archivo.crearArchivo("BibliotecaA");
    }
    
    public void crearArchivo(String biblioteca){
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            DOMImplementation implementacion = docBuilder.getDOMImplementation();

            // elemento raiz
            Document doc = implementacion.createDocument(null, biblioteca, null);
            Element libros = doc.createElement("libros");

            for (int i = 0; i < 10; i++) {
                // Libro
                Element libro = doc.createElement("libro");

                // atributo del elemento librp
                Attr attr = doc.createAttribute("id");
                attr.setValue(String.valueOf(i));
                libro.setAttributeNode(attr);

                // title
                Element title = doc.createElement("title");
                title.appendChild(doc.createTextNode("titulo " + String.valueOf(i)));
                libro.appendChild(title);

                // author
                Element author = doc.createElement("author");
                author.appendChild(doc.createTextNode("autor " + String.valueOf(i)));
                libro.appendChild(author);
                
                // author
                Element descrip = doc.createElement("descrip");
                descrip.appendChild(doc.createTextNode("descrip " + String.valueOf(i)));
                libro.appendChild(descrip);
                
                libros.appendChild(libro);
            }
            
            doc.getDocumentElement().appendChild(libros);

            // escribimos el contenido en un archivo .xml
           
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("biblioteca.xml"));
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //StreamResult result = new StreamResult(new File("archivo.xml"));

            // Si se quiere mostrar por la consola...
            result = new StreamResult(System.out);
            transformer.transform(source, result);
            System.out.println("");
            System.out.println("File saved!");
                       
        } catch (ParserConfigurationException | TransformerException pce) {
            pce.printStackTrace();
        }
    }
}
