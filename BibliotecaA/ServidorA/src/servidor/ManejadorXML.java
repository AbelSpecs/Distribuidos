package servidor;

import java.io.File;
import java.io.IOException;
import java.util.List;
import common.Libro;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;



public class ManejadorXML {
    
    public String path ;
    
    static final String TITLE = "title";
    static final String AUTHOR = "author";
    static final String LIBRO = "libro";
    
    public ManejadorXML(String ruta){
        this.path = ruta;
    }
    
    @SuppressWarnings({ "unchecked", "null" })   
    public List<Libro> cargarXML() {
        List<Libro> catalogo = new ArrayList<Libro>();
        try {
            // First, create a new XMLInputFactory
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            // Setup a new eventReader
            InputStream in = new FileInputStream(path);
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
            // read the XML document
            Libro libro = null;

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    // If we have an item element, we create a new item
                    String elementName = startElement.getName().getLocalPart();
                    switch (elementName) {
                        case LIBRO:
                            libro = new Libro();
                            // We read the attributes from this tag and add the date
                            // attribute to our object
                            Iterator<Attribute> attributes = startElement.getAttributes();
                            while (attributes.hasNext()) {
                                Attribute attribute = attributes.next();
                                if (attribute.getName().toString().equals(AUTHOR)) {
                                    libro.setAuthor(attribute.getValue());
                                }
                            }
                            break;
                        case TITLE:
                            event = eventReader.nextEvent();
                            libro.setTitle(event.asCharacters().getData());
                            break;
                    }
                }
                // If we reach the end of an item element, we add it to the list
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals(LIBRO)) {
                        catalogo.add(libro);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return catalogo;
    }
    
    @SuppressWarnings({ "unchecked", "null" })   
    public List<Libro> buscarAuthor(String autor) {
        List<Libro> catalogo = new ArrayList<Libro>();
        try {
            // First, create a new XMLInputFactory
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            // Setup a new eventReader
            InputStream in = new FileInputStream(path);
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
            // read the XML document
            Libro libro = null;

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    // If we have an item element, we create a new item
                    String elementName = startElement.getName().getLocalPart();
                    switch (elementName) {
                        case LIBRO:
                            libro = new Libro();
                            // We read the attributes from this tag and add the date
                            // attribute to our object
                            Iterator<Attribute> attributes = startElement.getAttributes();
                            while (attributes.hasNext()) {
                                Attribute attribute = attributes.next();
                                if (attribute.getName().toString().equals(AUTHOR)) {
                                    libro.setAuthor(attribute.getValue());
                                }
                            }
                            break;
                        case TITLE:
                            event = eventReader.nextEvent();
                            libro.setTitle(event.asCharacters().getData());
                            break;
                    }
                }
                // If we reach the end of an item element, we add it to the list
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals(LIBRO)) {
                        if(autor.contains(libro.getAuthor()) || libro.getAuthor().contains(autor)){
                            catalogo.add(libro);     
                        }

                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return catalogo;
    }
    
    @SuppressWarnings({ "unchecked", "null" })   
    public List<Libro> buscarTitulo(String titulo) {
        List<Libro> catalogo = new ArrayList<Libro>();
        try {
            // First, create a new XMLInputFactory
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            // Setup a new eventReader
            InputStream in = new FileInputStream(path);
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
            // read the XML document
            Libro libro = null;

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    // If we have an item element, we create a new item
                    String elementName = startElement.getName().getLocalPart();
                    switch (elementName) {
                        case LIBRO:
                            libro = new Libro();
                            // We read the attributes from this tag and add the date
                            // attribute to our object
                            Iterator<Attribute> attributes = startElement.getAttributes();
                            while (attributes.hasNext()) {
                                Attribute attribute = attributes.next();
                                if (attribute.getName().toString().equals(AUTHOR)) {
                                    libro.setAuthor(attribute.getValue());
                                }
                            }
                            break;
                        case TITLE:
                            event = eventReader.nextEvent();
                            libro.setTitle(event.asCharacters().getData());
                            break;
                    }
                }
                // If we reach the end of an item element, we add it to the list
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals(LIBRO)) {
                        if(titulo.contains(libro.getTitle()) || libro.getTitle().contains(titulo)){
                            catalogo.add(libro);     
                        }
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return catalogo;
    }
}