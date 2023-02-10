package ContactService;

import Contact.Contact;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {

@SuppressWarnings("unused")
private String uniqueID;
  private List<Contact> contactList = new ArrayList<>();

  {
    uniqueID = UUID.randomUUID().toString().substring(
        0, Math.min(toString().length(), 10));
  }

  public void newContact() {
    Contact contact = new Contact(newUniqueID());
    contactList.add(contact);
  }

  public void newContact(String firstName) {Contact contact = new Contact(newUniqueID(), firstName);
    contactList.add(contact);
  }

  public void newContact(String firstName, String lastName) {Contact contact = new Contact(newUniqueID(), firstName, lastName);
    contactList.add(contact);
  }

  public void newContact(String firstName, String lastName,
                         String phone) {Contact contact = new Contact(newUniqueID(), firstName, lastName, phone);
    contactList.add(contact);
  }

  public void newContact(String firstName, String lastName, String phone,
                         String address) {Contact contact = new Contact(newUniqueID(), firstName, lastName, phone, address);
    contactList.add(contact);
  }

  public void deleteContact(String ID) throws Exception {
    contactList.remove(searchForContact(ID));
  }

  public void updateFirstName(String ID, String firstName) throws Exception {
    searchForContact(ID).updateFirstName(firstName);
  }

  public void updateLastName(String ID, String lastName) throws Exception {
    searchForContact(ID).updateLastName(lastName);
  }

  public void updatePhone(String ID, String phone)
      throws Exception {
    searchForContact(ID).updatePhone(phone);
  }

  public void updateAddress(String ID, String address) throws Exception {
    searchForContact(ID).updateAddress(address);
  }

  protected List<Contact> getContactList() { return contactList; }

  private String newUniqueID() {
    return uniqueID = UUID.randomUUID().toString().substring(
               0, Math.min(toString().length(), 10));
  }

  private Contact searchForContact(String ID) throws Exception {
    int index = 0;
    while (index < contactList.size()) {
      if (ID.equals(contactList.get(index).getContactID())) {
        return contactList.get(index);
      }
      index++;
    }
    throw new Exception("Does not exist!");
  }
}