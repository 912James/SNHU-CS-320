package Contact;

public class Contact { 
	private static final int CONTACT_PHONE_LENGTH = 10; // max length of phone number
	private static final byte CONTACT_ID_LENGTH = 10; // max length of contact ID
	private static final byte CONTACT_FIRSTNAME_LENGTH = 10; // max length of first name
	private static final byte CONTACT_LASTNAME_LENGTH = 10; // max length of last name
	private static final byte CONTACT_ADDRESS_LENGTH = 30; // max length of address
	private static final String INITIALIZER = "INITIAL"; // initializer
	private static final String INITIALIZER_NUM = "1234567899"; // phone number we will use to test
	private String contactID; 
	private String firstName;
	private String lastName;
	private String phone;
	private String address; 
	
	Contact() { 
	    this.contactID = INITIALIZER;
	    this.firstName = INITIALIZER;
	    this.lastName = INITIALIZER;
	    this.phone = INITIALIZER_NUM;
	    this.address = INITIALIZER;
	  }

	  public Contact(String contactID) {
	    updateContactID(contactID);
	    this.firstName = INITIALIZER;
	    this.lastName = INITIALIZER;
	    this.phone = INITIALIZER_NUM;
	    this.address = INITIALIZER;
	  }

	  public Contact(String contactID, String firstName) {
	    updateContactID(contactID);
	    updateFirstName(firstName);
	    this.lastName = INITIALIZER;
	    this.phone = INITIALIZER_NUM;
	    this.address = INITIALIZER;
	  }

	  public Contact(String contactID, String firstName, String lastName) {
	    updateContactID(contactID);
	    updateFirstName(firstName);
	    updateLastName(lastName);
	    this.phone = INITIALIZER_NUM;
	    this.address = INITIALIZER;
	  }

	  public Contact(String contactID, String firstName, String lastName, String phone) {
	    updateContactID(contactID);
	    updateFirstName(firstName);
	    updateLastName(lastName);
	    updatePhone(phone);
	    this.address = INITIALIZER;
	  }

	  public Contact(String contactID, String firstName, String lastName, String phone, String address) {
	    updateContactID(contactID);
	    updateFirstName(firstName);
	    updateLastName(lastName);
	    updatePhone(phone);
	    updateAddress(address);
	  }

	  public final String getContactID() { return contactID; }

	  public final String getFirstName() { return firstName; }

	  public final String getLastName() { return lastName; }

	  public final String getPhone() { return phone; }

	  public final String getAddress() { return address; }

	  public void updateFirstName(String firstName) {
	    if (firstName == null) {
	      throw new IllegalArgumentException("Enter your first name");
	    } else if (firstName.length() > CONTACT_FIRSTNAME_LENGTH) {
	      throw new IllegalArgumentException("First name cannot be longer than " +
	                                         CONTACT_FIRSTNAME_LENGTH + " characters.");
	    } else {
	      this.firstName = firstName;
	    }
	  }

	  public void updateLastName(String lastName) {
	    if (lastName == null) {
	      throw new IllegalArgumentException("Enter your last name");
	    } else if (lastName.length() > CONTACT_LASTNAME_LENGTH) {
	      throw new IllegalArgumentException("Last name cannot be longer than " +
	                                         CONTACT_LASTNAME_LENGTH + " characters.");
	    } else {
	      this.lastName = lastName;
	    }
	  }

	  public void updatePhone(String phone) {
	    String regex = "[0-9]+";
	    if (phone == null) {
	      throw new IllegalArgumentException("Enter your Phone number");
	    } else if (phone.length() != CONTACT_PHONE_LENGTH) {
	      throw new IllegalArgumentException(
	          "Phone number length invalid. Ensure it is " +
	          CONTACT_PHONE_LENGTH + " digits.");
	    } else if (!phone.matches(regex)) {
	      throw new IllegalArgumentException(
	          "Only use numbers from 0-9 for your phone number.");
	    } else {
	      this.phone = phone;
	    }
	  }

	  public void updateAddress(String address) {
	    if (address == null) {
	      throw new IllegalArgumentException("Enter your Address");
	    } else if (address.length() > CONTACT_ADDRESS_LENGTH) {
	      throw new IllegalArgumentException("Address cannot be longer than " +
	                                         CONTACT_ADDRESS_LENGTH +
	                                         " characters.");
	    } else {
	      this.address = address;
	    }
	  }

	  public void updateContactID(String contactID) {
	    if (contactID == null) {
	      throw new IllegalArgumentException("Enter the ContactID");
	    } else if (contactID.length() > CONTACT_ID_LENGTH) {
	      throw new IllegalArgumentException("Contact ID cannot be longer than " +
	                                         CONTACT_ID_LENGTH + " characters.");
	    } else {
	      this.contactID = contactID;
	    }
	  }
	}