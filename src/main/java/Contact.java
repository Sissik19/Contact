/**
 * Class Contact, pour init Contacts.
 */
public class Contact {

    /**
     * Variables d'initalisation nom.
     */
    private String nom;
    /**
     * Variables d'initalisation tel.
     */
    private String tel;

    /**
     * Créer contact avec nom et tel.
     * @param name : nom contact
     * @param phone : tel contact
     */
    public Contact(final String name, final String phone) {
        this.nom = name;
        this.tel = phone;
    }

    /**
     * Créer contact avec nom.
     * @param name : nom contact
     */
    public Contact(final String name) {
        this.nom = name;
        this.tel = null;
    }

    /**
     * Obtenir nom.
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifier nom.
     * @param name : nouveau nom
     */
    public void setNom(final String name) {
        this.nom = name;
    }

    /**
     * Obtenir tel.
     * @return tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * Modifier tel.
     * @param phone : nouveau tel
     */
    public void setTel(final String phone) {
        this.tel = phone;
    }
}
