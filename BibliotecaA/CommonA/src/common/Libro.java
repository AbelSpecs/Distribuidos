package common;

import java.io.Serializable;

/**
 *
 * @author Omar David
 */
public class Libro implements Serializable{
    
    private String title, author;
    private static final long serialVersionUID = 1;

    public Libro(){
    }
    
    public Libro(String title, String author){
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
