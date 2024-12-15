
import java.io.*;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 */
public class LoginFacade {

    public string pseudo;
    private string mdp;
    private AbstractFactory factory;
    private LoginFacade theLogFacade;

    /**
     * Default constructor wich is private because singleton
     */
    private LoginFacade() {

    }
    /**
     * 
     */
    public void getInstance() {
        if (this.theLogFacade == null) {
        this.theLogFacade = LoginFacade();
        }
        return this.theLogFacade;
    }

    public void setPseudo(string pseudo) {
        this.pseudo = pseudo;
    }
    publiv void setMdp(string mdp){
        this.mdp = hashPassword(mdp);
    }

    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

}