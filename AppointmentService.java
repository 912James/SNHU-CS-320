package AppointmentService; 

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import Appointment.Appointment;

public class AppointmentService {
  final private List<Appointment> appointmentList = new ArrayList<>();

  // Creates unique ID like previous assignments
  private String newUniqueID() {
    return UUID.randomUUID().toString().substring(
        0, Math.min(toString().length(), 10));
  }

  public void newAppointment() {
    Appointment appointment = new Appointment(newUniqueID());
    appointmentList.add(appointment);
  }

  public void newAppointment(Date date) {
    Appointment appointment = new Appointment(newUniqueID(), date);
    appointmentList.add(appointment);
  }

  public void newAppointment(Date date, String description) {
    Appointment appointment = new Appointment(newUniqueID(), date, description);
    appointmentList.add(appointment);
  } 

  protected List<Appointment> getAppointmentList() { return appointmentList; }

  private Appointment searchForAppointment(String ID) throws Exception {
    int index = 0;
    while (index < appointmentList.size()) {
      if (ID.equals(appointmentList.get(index).getAppointmentID())) {
        return appointmentList.get(index);
      }
      index++;
    }
    throw new Exception("The appointment you searched for does not exist!");
  }
  
  public void deleteAppointment(String ID) throws Exception {
	    appointmentList.remove(searchForAppointment(ID));
	  }
}