package ContactService; 

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ContactService.ContactService;



public class ContactServiceTest {
  protected String contactID, firstNameTest, lastNameTest, phoneNumberTest,
      addressTest;
  protected String tooLongContactID, tooLongFirstName, tooLongLastName,
      tooLongPhoneNumber, tooShortPhoneNumber, tooLongAddress;

  
  @BeforeEach
  void startingVariables() {
    contactID = "Player 23";
    firstNameTest = "Lebron";
    lastNameTest = "James";
    phoneNumberTest = "2121234567";
    addressTest = "Los Angeles Lakers";
    tooLongContactID = "0123456789876543210";
    tooLongFirstName = "Southern New";
    tooLongLastName = "Hampshire University";
    tooLongPhoneNumber = "18006681249";
    tooShortPhoneNumber = "6681249";
    tooLongAddress = "2500 N River Rd, Manchester, NH 03106";
  }

  @Test
  void newContactTest() {ContactService service = new ContactService();
    service.newContact();
    assertAll(
        "service",
        ()
            -> assertNotNull(service.getContactList().get(0).getContactID()),
        ()
            -> assertEquals("INITIAL",
                            service.getContactList().get(0).getFirstName()),
        ()
            -> assertEquals("INITIAL",
                            service.getContactList().get(0).getLastName()),
        ()
            -> assertEquals("1234567899",
                            service.getContactList().get(0).getPhone()),
        ()
            -> assertEquals("INITIAL",
                            service.getContactList().get(0).getAddress()));
    service.newContact(firstNameTest);
    assertAll(
        "service",
        ()
            -> assertNotNull(service.getContactList().get(1).getContactID()),
        ()
            -> assertEquals(firstNameTest,
                            service.getContactList().get(1).getFirstName()),
        ()
            -> assertEquals("INITIAL",
                            service.getContactList().get(1).getLastName()),
        ()
            -> assertEquals("1234567899",
                            service.getContactList().get(1).getPhone()),
        ()
            -> assertEquals("INITIAL",
                            service.getContactList().get(1).getAddress()));
    service.newContact(firstNameTest, lastNameTest);
    assertAll(
        "service",
        ()
            -> assertNotNull(service.getContactList().get(2).getContactID()),
        ()
            -> assertEquals(firstNameTest,
                            service.getContactList().get(2).getFirstName()),
        ()
            -> assertEquals(lastNameTest,
                            service.getContactList().get(2).getLastName()),
        ()
            -> assertEquals("1234567899",
                            service.getContactList().get(2).getPhone()),
        ()
            -> assertEquals("INITIAL",
                            service.getContactList().get(2).getAddress()));
    service.newContact(firstNameTest, lastNameTest, phoneNumberTest);
    assertAll(
        "service",
        ()
            -> assertNotNull(service.getContactList().get(3).getContactID()),
        ()
            -> assertEquals(firstNameTest,
                            service.getContactList().get(3).getFirstName()),
        ()
            -> assertEquals(lastNameTest,
                            service.getContactList().get(3).getLastName()),
        ()
            -> assertEquals(phoneNumberTest,
                            service.getContactList().get(3).getPhone()),
        ()
            -> assertEquals("INITIAL",
                            service.getContactList().get(3).getAddress()));
    service.newContact(firstNameTest, lastNameTest, phoneNumberTest,
                       addressTest);
    assertAll(
        "service",
        ()
            -> assertNotNull(service.getContactList().get(4).getContactID()),
        ()
            -> assertEquals(firstNameTest,
                            service.getContactList().get(4).getFirstName()),
        ()
            -> assertEquals(lastNameTest,
                            service.getContactList().get(4).getLastName()),
        ()
            -> assertEquals(phoneNumberTest,
                            service.getContactList().get(4).getPhone()),
        ()
            -> assertEquals(addressTest,
                            service.getContactList().get(4).getAddress()));
  }

  @Test
  void deleteContactTest() {ContactService service = new ContactService();
    service.newContact();
    assertThrows(Exception.class, () -> service.deleteContact(contactID));
    assertAll(()
                  -> service.deleteContact(
                      service.getContactList().get(0).getContactID()));
  }

  @Test
  void updateFirstNameTest() throws Exception {ContactService service = new ContactService();
    service.newContact();
    service.updateFirstName(service.getContactList().get(0).getContactID(),
                            firstNameTest);
    assertEquals(firstNameTest, service.getContactList().get(0).getFirstName());
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateFirstName(
                         service.getContactList().get(0).getContactID(),
                         tooLongFirstName));
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateFirstName(
                         service.getContactList().get(0).getContactID(), null));
    assertThrows(Exception.class,
                 () -> service.updateFirstName(contactID, firstNameTest));
  }

  @Test
  void updateLastNameTest() throws Exception {ContactService service = new ContactService();
    service.newContact();
    service.updateLastName(service.getContactList().get(0).getContactID(),
                           lastNameTest);
    assertEquals(lastNameTest, service.getContactList().get(0).getLastName());
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateLastName(
                         service.getContactList().get(0).getContactID(),
                         tooLongLastName));
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateLastName(
                         service.getContactList().get(0).getContactID(), null));
    assertThrows(Exception.class,
                 () -> service.updateLastName(contactID, lastNameTest));
  }

  @Test
  void updatePhoneTest() throws Exception {ContactService service = new ContactService();
    service.newContact();
    service.updatePhone(service.getContactList().get(0).getContactID(),
                              phoneNumberTest);
    assertEquals(phoneNumberTest,
                 service.getContactList().get(0).getPhone());
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updatePhone(
                         service.getContactList().get(0).getContactID(),
                         tooLongPhoneNumber));
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updatePhone(
                         service.getContactList().get(0).getContactID(),
                         tooShortPhoneNumber));
    assertThrows(
        IllegalArgumentException.class,
        ()
            -> service.updatePhone(
                service.getContactList().get(0).getContactID(), contactID));
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updatePhone(
                         service.getContactList().get(0).getContactID(), null));
    assertThrows(Exception.class,
                 () -> service.updatePhone(contactID, lastNameTest));
  }

  @Test
  void updateAddressTest() throws Exception {ContactService service = new ContactService();
    service.newContact();
    service.updateAddress(service.getContactList().get(0).getContactID(),
                          addressTest);
    assertEquals(addressTest, service.getContactList().get(0).getAddress());
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateAddress(
                         service.getContactList().get(0).getContactID(),
                         tooLongAddress));
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateAddress(
                         service.getContactList().get(0).getContactID(), null));
    assertThrows(Exception.class,
                 () -> service.updateAddress(contactID, addressTest));
  }
}
