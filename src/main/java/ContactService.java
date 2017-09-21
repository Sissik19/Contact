public class ContactService {

    private IContactDao dao;

    ContactService (){
        dao = new ContactDao();
    }


    void creerContact(String nom, String tel) throws Exception{
        Contact c ;
        if(nom!=null && nom.length() >= 3 && nom.length() <= 40) {
            if(!dao.isContactExiste(nom)) {
                c = new Contact(nom, tel);
            }
            else{
                throw new ContactExistException("Erreur : contact existant");
            }
        }
        else{
            throw new IllegalArgumentException("Erreur : nom incorrect");
        }
        dao.creerContact(c);
    }
    void creerContact(String nom) throws Exception{
        Contact c;
        char[] nomTab = nom.toCharArray();
        if(nomTab.length >= 3 && nomTab.length <= 40) {
            if(!dao.isContactExiste(nom)) {
                c = new Contact(nom);
            }
            else{
                throw new ContactExistException("Erreur : contact existant");
            }
        }
        else{
            throw new IllegalArgumentException("Erreur : nom incorrect");
        }
        dao.creerContact(c);
    }

    void supprimerContact(String nom) throws Exception{
        if(dao.isContactExiste(nom)) {
            Contact c = dao.recupererContact(nom);
            dao.getContacts().remove(c);
        }
        else{
            throw new ContactExistException("Erreur : contact non existant");
        }
    }
}
