package AppointmentService;  

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {
  private String ID, description, tooLongDescription;
  private Date date, pastDate;

  
  @SuppressWarnings("deprecation") // Eclipse recommended using this warning so i could utilize a date
  @BeforeEach // before each test use these variables
  void startingVaraibles() {
    ID = "0123456789";
    description = "An appointment requires a description.";
    date = new Date(2023, 01, 26);
    tooLongDescription = "This description is going to be too long and contain more than 50 characters.";
    pastDate = new Date(0); 
  }

  // The appointment service shall be able to add appointments with a unique appointment ID.
  @Test
  void testNewAppointment() {
    AppointmentService service = new AppointmentService();

    service.newAppointment();
    assertNotNull(service.getAppointmentList().get(0).getAppointmentID());
    assertNotNull(service.getAppointmentList().get(0).getAppointmentDate());
    assertNotNull(service.getAppointmentList().get(0).getDescription());

    service.newAppointment(date);
    assertNotNull(service.getAppointmentList().get(1).getAppointmentID());
    assertEquals(date,
                 service.getAppointmentList().get(1).getAppointmentDate());
    assertNotNull(service.getAppointmentList().get(1).getDescription());

    service.newAppointment(date, description);
    assertNotNull(service.getAppointmentList().get(2).getAppointmentID());
    assertEquals(date,
                 service.getAppointmentList().get(2).getAppointmentDate());
    assertEquals(description,
                 service.getAppointmentList().get(2).getDescription());

    assertNotEquals(service.getAppointmentList().get(0).getAppointmentID(),
                    service.getAppointmentList().get(1).getAppointmentID());
    assertNotEquals(service.getAppointmentList().get(0).getAppointmentID(),
                    service.getAppointmentList().get(2).getAppointmentID());
    assertNotEquals(service.getAppointmentList().get(1).getAppointmentID(),
                    service.getAppointmentList().get(2).getAppointmentID());

    assertThrows(IllegalArgumentException.class,
                 () -> service.newAppointment(pastDate));
    assertThrows(IllegalArgumentException.class,
                 () -> service.newAppointment(date, tooLongDescription));
  }

  	// The appointment service shall be able to delete appointments per appointment ID.
  @Test
  void deleteAppointment() throws Exception {
    AppointmentService service = new AppointmentService();

    service.newAppointment();
    service.newAppointment();
    service.newAppointment();

    String ID1 = service.getAppointmentList().get(0).getAppointmentID();
    String ID2 = service.getAppointmentList().get(1).getAppointmentID();
    String ID3 = service.getAppointmentList().get(2).getAppointmentID();

    assertNotEquals(ID1, ID2);
    assertNotEquals(ID1, ID3);
    assertNotEquals(ID2, ID3);
    assertNotEquals(ID, ID1);
    assertNotEquals(ID, ID2);
    assertNotEquals(ID, ID3);

    assertThrows(Exception.class, () -> service.deleteAppointment(ID));

    service.deleteAppointment(ID1);
    assertThrows(Exception.class, () -> service.deleteAppointment(ID1));
    assertNotEquals(ID1, service.getAppointmentList().get(0).getAppointmentID());
  }
}