import org.junit.Test;


import static org.junit.Assert.*;

public class ContactDaoTest {
    @Test
    public void creerContact() throws Exception{
        ContactDao dao = new ContactDao();
        Contact c = new Contact("Kessab","");
        dao.creerContact(c);
    }

    @Test
    public void recupererContact() throws Exception{
        ContactDao dao = new ContactDao();
        Contact c = new Contact("Kessab","");
        dao.creerContact(c);

        assertEquals(c,dao.recupererContact("Kessab"));
    }

    @Test
    public void isContactExiste() throws Exception{
        ContactDao dao = new ContactDao();
        Contact c = new Contact("Kessab","");
        dao.creerContact(c);

        assertTrue(dao.isContactExiste("Kessab"));
        assertFalse(dao.isContactExiste("kesaz"));


    }

}