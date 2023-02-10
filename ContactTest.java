package Contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest{protected String contactID, firstNameTest, lastNameTest, phoneNumberTest,addressTest;
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
  void contactTest() {
    Contact contact = new Contact();
    assertAll("Test",
              ()
                  -> assertNotNull(contact.getContactID()),
              ()
                  -> assertNotNull(contact.getFirstName()),
              ()
                  -> assertNotNull(contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhone()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void contactIDTest() {
    Contact contact = new Contact(contactID);
    assertAll("Test one",
              ()
                  -> assertEquals(contactID, contact.getContactID()),
              ()
                  -> assertNotNull(contact.getFirstName()),
              ()
                  -> assertNotNull(contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhone()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void contactIDandFirstNameTest() {
    Contact contact = new Contact(contactID, firstNameTest);
    assertAll("Test two",
              ()
                  -> assertEquals(contactID, contact.getContactID()),
              ()
                  -> assertEquals(firstNameTest, contact.getFirstName()),
              ()
                  -> assertNotNull(contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhone()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void contactIDandFullNameTest() {
    Contact contact = new Contact(contactID, firstNameTest, lastNameTest);
    assertAll("Test three",
              ()
                  -> assertEquals(contactID, contact.getContactID()),
              ()
                  -> assertEquals(firstNameTest, contact.getFirstName()),
              ()
                  -> assertEquals(lastNameTest, contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhone()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void contactIDFullNamePhoneNumberTest() {
    Contact contact =
        new Contact(contactID, firstNameTest, lastNameTest, phoneNumberTest);
    assertAll("Test four",
              ()
                  -> assertEquals(contactID, contact.getContactID()),
              ()
                  -> assertEquals(firstNameTest, contact.getFirstName()),
              ()
                  -> assertEquals(lastNameTest, contact.getLastName()),
              ()
                  -> assertEquals(phoneNumberTest, contact.getPhone()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void allVariablesTest() {
    Contact contact = new Contact(contactID, firstNameTest, lastNameTest,
                                  phoneNumberTest, addressTest);
    assertAll("Testing all varaibles",
              ()
                  -> assertEquals(contactID, contact.getContactID()),
              ()
                  -> assertEquals(firstNameTest, contact.getFirstName()),
              ()
                  -> assertEquals(lastNameTest, contact.getLastName()),
              ()
                  -> assertEquals(phoneNumberTest, contact.getPhone()),
              () -> assertEquals(addressTest, contact.getAddress()));
  }

  @Test
  void updateFirstNameTest() {
    Contact contact = new Contact();
    contact.updateFirstName(firstNameTest);
    assertAll(
        "First name",
        ()
            -> assertEquals(firstNameTest, contact.getFirstName()),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateFirstName(null)),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateFirstName(tooLongFirstName)));
  }

  @Test
  void updateLastNameTest() {
    Contact contact = new Contact();
    contact.updateLastName(lastNameTest);
    assertAll(
        "Last name",
        ()
            -> assertEquals(lastNameTest, contact.getLastName()),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateLastName(null)),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateLastName(tooLongFirstName)));
  }

  @Test
  void updatePhoneNumberTest() {
    Contact contact = new Contact();
    contact.updatePhone(phoneNumberTest);
    assertAll("Phone number",
              ()
                  -> assertEquals(phoneNumberTest, contact.getPhone()),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.updatePhone(null)),
              ()
                  -> assertThrows(
                      IllegalArgumentException.class,
                      () -> contact.updatePhone(tooLongPhoneNumber)),
              ()
                  -> assertThrows(
                      IllegalArgumentException.class,
                      () -> contact.updatePhone(tooShortPhoneNumber)),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.updatePhone(contactID)));
  }

  @Test
  void updateAddressTest() {
    Contact contact = new Contact();
    contact.updateAddress(addressTest);
    assertAll("phone number",
              ()
                  -> assertEquals(addressTest, contact.getAddress()),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.updateAddress(null)),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.updateAddress(tooLongAddress)));
  }

  @Test
  void updatecontactIDTest() {
    Contact contact = new Contact();
    contact.updateContactID(contactID);
    assertAll(
        "contact ID",
        ()
            -> assertEquals(contactID, contact.getContactID()),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateContactID(null)),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateContactID(tooLongContactID)));
  }
}