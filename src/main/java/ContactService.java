/**
 * Class ContactService contenant les méthodes pour gérer les Contacts.
 */
public class ContactService {

    /**
     * Variable d'instance.
     */
    private IContactDao dao;

    /**
     * Contructeur de ContactService qui initalie ContactDao.
     */
    ContactService() {
        dao = new ContactDao();
    }

    /**
     * Permet de créer contact à partir d'un nom et d'un tel.
     * @param nom : >=3 && <=40 !vide && !null
     * @param tel : aucune règle
     * @throws Exception : si Contact déjà existant ou mauvais nom
     */
    void creerContact(final String nom, final String tel) throws Exception {
        Contact c;
        if (nom != null && nom.length() >= 3 && nom.length() <= 40) {
            if (!dao.isContactExiste(nom)) {
                c = new Contact(nom, tel);
            } else {
                throw new ContactExistException("Erreur : contact existant");
            }
        } else {
            throw new IllegalArgumentException("Erreur : nom incorrect");
        }
        dao.creerContact(c);
    }

    /**
     * Permet de créer contact à partir d'un nom.
     * @param nom : >=3 && <=40 !vide && !null
     * @throws Exception : Contact déjà existant ou mauvais nom
     */
    void creerContact(final String nom) throws Exception {
        Contact c;
        char[] nomTab = nom.toCharArray();
        if (nomTab.length >= 3 && nomTab.length <= 40) {
            if (!dao.isContactExiste(nom)) {
                c = new Contact(nom);
            } else {
                throw new ContactExistException("Erreur : contact existant");
            }
        } else {
            throw new IllegalArgumentException("Erreur : nom incorrect");
        }
        dao.creerContact(c);
    }

    /**
     * Permet de supprimer un Contact grâce au nom.
     * @param nom : Contact à supprimer
     * @throws Exception : contact non existant
     */
    void supprimerContact(final String nom) throws Exception {
        if (dao.isContactExiste(nom)) {
            Contact c = dao.recupererContact(nom);
            dao.getContacts().remove(c);
        } else {
            throw new ContactExistException("Erreur : contact non existant");
        }
    }
}
