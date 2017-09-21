import java.util.ArrayList;

/**
 * Class ContactDao.
 */
public class ContactDao implements IContactDao {

    /**
     * Variable d'instance.
     */
    private ArrayList<Contact> contacts;

    /**
     * Constructeur pour instancier ArrayList Contact.
     */
    ContactDao() {
        this.contacts = new ArrayList<Contact>();
    }

    /**
     * Obtenir ArrayList Contact.
     * @return ArrayList Contact
     */
    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    /**
     * Ajouter Contact à ArrayList contact (appelé par ContactService).
     * @param c : Contact a ajouter
     */
    public void creerContact(final Contact c) {
            this.contacts.add(c);
    }

    /**
     * Recuperer contact à partir de nom.
     * @param nom : contact rechercher
     * @return contact avec le nom voulu
     */
    public Contact recupererContact(final String nom) {
        Contact contactFind = null;
        for (int i = 0; i < contacts.size(); i++) {
            contactFind = contacts.get(i);
        }
        return contactFind;
    }


    /**
     * Test si contact existe.
     * @param nom : contact recherché
     * @return true si trouvé false sinon
     */
    public boolean isContactExiste(final String nom) {
        boolean contactFind = false;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getNom() == nom) {
                contactFind = true;
            }
        }
        return contactFind;

    }

    /**
     * Supprimer contact à partir d'un nom.
     * @param nom : contact à supprimer
     * @throws ContactExistException : si contact non existant
     */
    public void supprimerContact(final String nom) throws ContactExistException {
        boolean contactFind = isContactExiste(nom);
        if (contactFind) {
            Contact c = recupererContact(nom);
            this.contacts.remove(c);
        } else {
            throw new ContactExistException("Echec : Contact non existant");
        }
    }
}
