import java.util.ArrayList;

/**
 * Interface de IContactDao.
 */
public interface IContactDao {
    void creerContact(Contact c) throws ContactExistException;
    Contact recupererContact(String nom);
    boolean isContactExiste(String nom);
    void supprimerContact(String nom) throws ContactExistException;
    ArrayList<Contact> getContacts();

}
