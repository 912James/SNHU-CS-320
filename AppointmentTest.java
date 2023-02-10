package Appointment; 

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentTest {

	// Variables
  private String ID, description;
  private String tooLongID, tooLongDescription;
  private Date date, pastDate;

  @BeforeEach // before each test use these variables
  void startingVaraibles() {
    ID = "0123456789";
    description = "An appointment requires a description.";
    date = new Date(); // uses todays date
    tooLongID = "01234567899876543210";
    tooLongDescription = "This description is going to be too long and contain more than 50 characters.";
    pastDate = new Date(0); // used multiple varaibles 0 gave the highest coverage
  }

  @Test
  void testUpdateAppointmentID() {
    Appointment appointment = new Appointment();
    assertThrows(IllegalArgumentException.class,
                 () -> appointment.updateAppointmentID(null));
    assertThrows(IllegalArgumentException.class,
                 () -> appointment.updateAppointmentID(tooLongID));
    appointment.updateAppointmentID(ID);
    assertEquals(ID, appointment.getAppointmentID());
  }

  @Test
  void testGetAppointmentID() {
    Appointment appointment = new Appointment(ID);
    assertNotNull(appointment.getAppointmentID());
    assertEquals(appointment.getAppointmentID().length(), 10);
    assertEquals(ID, appointment.getAppointmentID());
  }

  @Test
  void testUpdateDate() {
    Appointment appointment = new Appointment();
    assertThrows(IllegalArgumentException.class, () -> appointment.updateDate(null));
    assertThrows(IllegalArgumentException.class,
                 () -> appointment.updateDate(pastDate));
    appointment.updateDate(date);
    assertEquals(date, appointment.getAppointmentDate());
  }

  @Test
  void testGetAppointmentDate() {
    Appointment appointment = new Appointment(ID, date);
    assertNotNull(appointment.getAppointmentDate());
    assertEquals(date, appointment.getAppointmentDate());
  }

  @Test
  void testUpdateDescription() {
    Appointment appointment = new Appointment();
    assertThrows(IllegalArgumentException.class,
                 () -> appointment.updateDescription(null));
    assertThrows(IllegalArgumentException.class,
                 () -> appointment.updateDescription(tooLongDescription));
    appointment.updateDescription(description);
    assertEquals(description, appointment.getDescription());
  }

  @Test
  void testGetDescription() {
    Appointment appointment = new Appointment(ID, date, description);
    assertNotNull(appointment.getDescription());
    assertEquals(description, appointment.getDescription());
  }
}