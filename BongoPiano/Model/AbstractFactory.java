
import java.io.*;
import java.util.*;

/**
 * 
 */
public class AbstractFactory {

    string username;
    string hashedpassword;
    AbstractFactory theFact;

    /**
     * Default constructor which is private because singleton
     */
    private AbstractFactory() {
    }

    /**
     * 
     */
    public void createUserDAO() {

    }

    /**
     * 
     */
    public void getInstance() {
        if (this.theFact == null){
            this.theFact = AbstractFactory();
        }
        return this.theFact;
    }

    public void setUsername(string username) {
        this.username = username;
    }
    public void setHashedPassword(string pw){
        this.hashedpassword = pw;
    }
}