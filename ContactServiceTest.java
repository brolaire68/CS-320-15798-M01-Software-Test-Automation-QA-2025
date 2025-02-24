import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        assertTrue(service.getAllContacts().containsKey("12345"));
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.deleteContact("12345");
        assertFalse(service.getAllContacts().containsKey("12345"));
    }

    @Test
    public void testUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateContact("12345", "Jane", null, "0987654321", null);
        Contact updatedContact = service.getAllContacts().get("12345");
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("Doe", updatedContact.getLastName());
        assertEquals("123 Main St", updatedContact.getAddress());
    }
}